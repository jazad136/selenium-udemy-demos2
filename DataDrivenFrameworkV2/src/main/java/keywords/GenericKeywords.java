package keywords;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;
import reports.ExtentManager;

/**
 *
 * @author JonathanSaddler
 */
public class GenericKeywords {
    public WebDriver driver = null;
    public SoftAssert softAssert = null;
    public Properties prop;
    public ExtentTest test;
    
    
    public void openBrowser(String propertyKey) {
        String browser = prop.getProperty(propertyKey);
        i("Opening Browser -- " + browser);
        driver = switch (browser.toLowerCase()) {
            case "chrome" -> new ChromeDriver();
            case "firefox" -> new FirefoxDriver();
            case "edge" -> new EdgeDriver();
            default -> new ChromeDriver();
        };
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }
    public void setReport(ExtentTest test) { 
    	this.test = test;
    }
    public void shutdown() { 
        driver.close();
    }
    public void reportFailure(String msg, boolean isCriticalFailure) { 
        logError(msg);
        takeScreenShot();
        softAssert.fail(msg);
        if(isCriticalFailure) {
            Reporter.getCurrentTestResult().getTestContext().setAttribute("isCriticalFailure", "true");            
            reportAll();
        }
    }
    public void reportFailure(String msg) {
        reportFailure(msg, false);
    }
    public void takeScreenShot() { 
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String formattedDate = dateFormat.format(currentDate);
        String screenshotFilestemStr = formattedDate;
        // take screenshot
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File screenshotFilestem = new File(ExtentManager.screenshotPath, screenshotFilestemStr);
        File copiedFile = copyScreenshot(srcFile, screenshotFilestem);
//        test.log(Status.INFO, "Screenshot -- "
//            + test.addScreenCaptureFromPath(copiedFile.getAbsolutePath()));
        test.log(Status.FAIL, MarkupHelper.createLabel("Screenshot", ExtentColor.GREEN));
        test.log(Status.FAIL, "<a href='" + copiedFile.getAbsolutePath() + "'><img src='" + copiedFile.getAbsolutePath() + "' style='width:100%;'/></a>");
    }
    public File copyScreenshot(File srcFile, File screenshotFilestem) { 
        int adderNum = 2;
        Path srcFilePath = srcFile.toPath();
        File screenshotNewFile = new File(screenshotFilestem.getParent(), screenshotFilestem.getName() + ".png");
        boolean printedMessage = false;
        do {
            try {
                Files.copy(srcFilePath, screenshotNewFile.toPath());
                return screenshotNewFile;
            } catch(FileAlreadyExistsException fae) { 
                if(!printedMessage)
                    System.err.println("Snapshot File " + screenshotNewFile + " already exists");
                String adder = "_" + adderNum;
                screenshotNewFile = new File(screenshotFilestem.getParentFile(), screenshotFilestem.getName() + adder + ".png");
                adderNum++;
            } catch(IOException e) {
                e.printStackTrace();
                break;
            }
        }while(true);
        return null;
    }
    public void reportAll() { 
        softAssert.assertAll();
    }
    public void openURL(String URLKey) { 
        i("Opening Web URL : " + prop.getProperty(URLKey));
        driver.get(prop.getProperty(URLKey));
    }
    
    public void click(String locatorKey) {
        i("Perform Click on Locator : " + prop.getProperty(locatorKey));
        getElement(locatorKey).click();
    }
    public void clickButton(String locatorKey) {
        i("Perform Click on Locator : " + prop.getProperty(locatorKey));
        getElement(locatorKey).click();
    }
    
    public By getLocator(String locatorKey) { 
        String property = prop.getProperty(locatorKey);
        By by = null;
        if(locatorKey.endsWith("_id"))
            by =  By.id(property);
        else if(locatorKey.endsWith("_xpath"))
            by = By.xpath(property);
        else if(locatorKey.endsWith("_css"))
            by = By.cssSelector(property);
        else if(locatorKey.endsWith("_linkText"))
            by = By.linkText(property);
        else if(locatorKey.endsWith("_partialLinkText"))
            by = By.partialLinkText(property);
        else if(locatorKey.endsWith("_name"))
            by = By.name(property);
        else if(locatorKey.endsWith("_className"))
            by = By.className(property);
        else if(locatorKey.endsWith("_tagName"))
            by = By.tagName(property);
        
        return by;
    }
    public void type(String locatorKey, String value) {
        i("Typing Text : " + value + " in Locator : " + prop.getProperty(locatorKey));
        getElement(locatorKey).sendKeys(value);
    }
    
    public void enterCaptcha(String locatorKey) { 
        i("Given Captcha Locator : " + prop.getProperty(locatorKey));
//        Scanner scanner = new Scanner(System.in);
        // handle the issue using user input
        // getElement(locator).sendKeys(locator);
    }
    public void select() {
        
    }
    
    public void getText() {
        
    }
    
    public void navigate() {
        
    }
    
    public void acceptAlert() {
        
    }
    
    public void dismissAlert() {
        
    }
    protected WebElement getElement(String locatorKey) {
        // Element is present
        if(!isElementPresent(locatorKey)) {
            // report error
            System.out.println("Element is not Present : " + prop.getProperty(locatorKey));
        }
        // Element is visible
        if(!isElementVisible(locatorKey)) { 
            // report error
            System.out.println("Element is not Visible : " + prop.getProperty(locatorKey));
        }
        
        // create webelement and return webelement
        WebElement element = driver.findElement(getLocator(locatorKey));
        return element;
    }
    protected boolean isElementPresent(String locatorKey) { 
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        try { 
            wait.until(ExpectedConditions.presenceOfElementLocated(getLocator(locatorKey)));
        } catch(Exception e) { 
            reportFailure("Unable to locate Element with locator : " + getLocator(locatorKey));
            reportFailure(e.getMessage());
            e.printStackTrace();
            return false;
        }
        return true;
    }
    protected boolean isElementVisible(String locatorKey) { 
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        try { 
            wait.until(ExpectedConditions.visibilityOfElementLocated(getLocator(locatorKey)));
        } catch(Exception e) { 
            reportFailure(e.getMessage());
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public void i(String msg) {
        System.out.println(msg);
        test.info(msg);
    }
    public void iFormat(String formatMsg, Object... formatObjs) {
        System.out.printf(formatMsg + "\n", formatObjs);
        test.info(String.format(formatMsg + "\n", formatObjs));
    }
    public void logError(String msg) { 
    	System.out.println(msg);
    	test.fail(msg);
    }
    
    public void pass(String msg) { 
        System.out.println(msg);
        test.pass(msg);
    }
    public void fail(String msg) { 
        System.out.println(msg);
        test.fail(msg);
    }
    public void logSkip(String msg) { 
        System.out.println(msg);
        test.skip(msg);
    }
}
