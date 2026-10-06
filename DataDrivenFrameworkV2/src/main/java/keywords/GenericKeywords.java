package keywords;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author JonathanSaddler
 */
public class GenericKeywords {
    public WebDriver driver = null;
    
    public void openBrowser(String browser) {
        driver = switch (browser.toLowerCase()) {
            case "chrome" -> new ChromeDriver();
            case "firefox" -> new FirefoxDriver();
            case "edge" -> new EdgeDriver();
            default -> new ChromeDriver();
        };
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }
    
    public void openURL(String URL) { 
        driver.get(URL);
    }
    
    public void click() {
        
    }
    
    public void type(String sendKeys) {
        
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
}
