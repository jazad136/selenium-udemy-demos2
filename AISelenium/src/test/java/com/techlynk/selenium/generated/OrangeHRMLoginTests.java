package com.techlynk.selenium.generated;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class OrangeHRMLoginTests {

    private WebDriver driver;
    private WebDriverWait wait;

    // Core locators
    private static final String BASE_URL = "https://opensource-demo.orangehrmlive.com/";
    private static final By USERNAME_INPUT = By.name("username");
    private static final By PASSWORD_INPUT = By.name("password");
    private static final By LOGIN_BUTTON = By.cssSelector("button[type='submit']");
    private static final By DASHBOARD_HEADER = By.xpath("//h6[normalize-space()='Dashboard']");
    private static final By LEFT_NAV = By.cssSelector("aside.oxd-sidepanel");
    private static final By USER_MENU = By.xpath("//p[contains(@class,'oxd-userdropdown-name')]");
    private static final By INVALID_CREDENTIALS_ERROR = By.xpath("//p[contains(@class,'oxd-alert-content-text') and normalize-space()='Invalid credentials']");

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        // Set up ChromeDriver (requires WebDriverManager dependency)
//        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        // options.addArguments("--headless=new"); // Uncomment for headless runs in CI
        options.addArguments("--window-size=1280,900");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");

        driver = new ChromeDriver(options);
        driver.manage().window().setSize(new Dimension(1280, 900));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // Test 1: Login - Valid Credentials - Verify Dashboard Visibility
    @Test(description = "Registered user logs in with valid credentials and verifies dashboard visibility.")
    public void testLoginWithValidCredentials_VerifyDashboardVisibility() {
        // Step 1: Navigate and verify login form visibility
        openLoginPageAndVerifyForm();

        // Step 2: Verify page title
        waitForTitleEquals("OrangeHRM");

        // Steps 3-4: Enter username and password
        typeAndAssertValue(USERNAME_INPUT, "Admin");
        typeAndAssertValue(PASSWORD_INPUT, "admin123");

        // Step 5: Click Login
        clickAndWait(LOGIN_BUTTON);

        // Step 6: Verify Dashboard page elements
        assertDashboardVisible();
    }

    // Test 2: Login - Valid Credentials - Verify by Page Title and User Menu
    @Test(description = "Registered user logs in and verifies successful login using page title and user menu presence.")
    public void testLoginWithValidCredentials_VerifyByTitleAndUserMenu() {
        // Step 1: Navigate and verify login form visibility
        openLoginPageAndVerifyForm();

        // Step 2: Verify page title
        waitForTitleEquals("OrangeHRM");

        // Steps 3-4: Enter username and password
        typeAndAssertValue(USERNAME_INPUT, "Admin");
        typeAndAssertValue(PASSWORD_INPUT, "admin123");

        // Step 5: Click Login
        clickAndWait(LOGIN_BUTTON);

        // Step 6: Verify post-login state
        // Title remains "OrangeHRM"
        waitForTitleEquals("OrangeHRM");

        // User menu/profile dropdown visible
        Assert.assertTrue(isVisibleWithin(USER_MENU, Duration.ofSeconds(10)), "User menu/profile dropdown should be visible.");

        // Breadcrumb/header indicates "Dashboard"
        Assert.assertTrue(isVisibleWithin(DASHBOARD_HEADER, Duration.ofSeconds(10)), "Header 'Dashboard' should be visible after login.");
    }

    // Test 3: Login - Invalid Password - Error Handling
    @Test(description = "Invalid password should keep user on login page and display 'Invalid credentials' error.")
    public void testLoginWithInvalidPassword_ShowsErrorAndStaysOnLoginPage() {
        // Step 1: Navigate and verify login form visibility
        openLoginPageAndVerifyForm();

        // Step 2: Verify page title
        waitForTitleEquals("OrangeHRM");

        // Steps 3-4: Enter username and wrong password
        typeAndAssertValue(USERNAME_INPUT, "Admin");
        typeAndAssertValue(PASSWORD_INPUT, "WrongPass123!");

        // Step 5: Click Login
        clickAndWait(LOGIN_BUTTON);

        // Step 6: Verify error message and that user remains on login page
        Assert.assertTrue(isVisibleWithin(INVALID_CREDENTIALS_ERROR, Duration.ofSeconds(10)),
                "Error message 'Invalid credentials' should be displayed.");

        // User remains on login page: URL does not navigate to '/dashboard'
        String currentUrl = driver.getCurrentUrl();
        Assert.assertFalse(currentUrl.toLowerCase().contains("/dashboard"),
                "User should not navigate to dashboard URL on invalid login. Current URL: " + currentUrl);

        // Dashboard header is not visible
        Assert.assertFalse(isVisibleWithin(DASHBOARD_HEADER, Duration.ofSeconds(3)),
                "Dashboard header should not be visible on invalid login.");
    }

    // Helper: Navigate to login page and verify form elements are visible
    private void openLoginPageAndVerifyForm() {
        driver.get(BASE_URL);

        // Ensure we are at the login page with visible form controls
        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(USERNAME_INPUT));
        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(PASSWORD_INPUT));
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(LOGIN_BUTTON));

        Assert.assertTrue(username.isDisplayed(), "Username field should be visible.");
        Assert.assertTrue(password.isDisplayed(), "Password field should be visible.");
        Assert.assertTrue(loginBtn.isDisplayed(), "Login button should be visible.");
    }

    // Helper: Type into a field and assert value is set
    private void typeAndAssertValue(By locator, String value) {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        el.clear();
        el.sendKeys(value);
        // Assert the value in the input (for password fields, attribute 'value' is accessible)
        String actual = el.getAttribute("value");
        Assert.assertEquals(actual, value, "Input value should match for locator: " + locator.toString());
    }

    // Helper: Click element and small wait for async actions (spinner, navigation)
    private void clickAndWait(By locator) {
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(locator));
        el.click();
        // Optional short wait for any immediate async action
        sleep(250);
    }

    // Helper: Verify dashboard is visible (header, URL, and left nav)
    private void assertDashboardVisible() {
        // Wait for header 'Dashboard'
        WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(DASHBOARD_HEADER));
        Assert.assertEquals(header.getText().trim(), "Dashboard", "Dashboard header text should be 'Dashboard'.");

        // URL contains '/dashboard'
        wait.until(driver -> driver.getCurrentUrl().toLowerCase().contains("/dashboard"));
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains("/dashboard"),
                "URL should contain '/dashboard' after successful login.");

        // Left navigation menu is visible
        Assert.assertTrue(isVisibleWithin(LEFT_NAV, Duration.ofSeconds(10)),
                "Left navigation menu should be visible on dashboard.");
    }

    // Helper: Wait for exact page title
    private void waitForTitleEquals(String expectedTitle) {
        boolean ok = wait.until(ExpectedConditions.titleIs(expectedTitle));
        Assert.assertTrue(ok, "Page title should be '" + expectedTitle + "'. Actual: '" + driver.getTitle() + "'");
    }

    // Helper: Visible within custom timeout without throwing
    private boolean isVisibleWithin(By locator, Duration timeout) {
        try {
            WebDriverWait shortWait = new WebDriverWait(driver, timeout);
            shortWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    // Small sleep utility for minor stabilization without masking real waits
    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ignored) {
            Thread.currentThread().interrupt();
        }
    }
}