package testCases;

import keywords.ApplicationKeywords;
import org.testng.annotations.Test;

/**
 *
 * @author JonathanSaddler
 */
public class CreatePortfolioTest extends ApplicationKeywords {
    
    @Test
    public void createPortfolioTest() {
        /*
         * 1. Open Target Webpage
         * 2. Click on SignIn Button/Link
         * 3. Enter Login Details
         * 4. Click on Submit Button
         * 5. Verify you are on Portfolio Page after Login
         * 6. Click Create Portfolio Link
         * 7. Enter Portfolio Name. 
         * 8. Click on Create Portfolio Link
         */
        /*
         * Generic
         *   | 
         * Validation 
         *   | 
         * Application 
         *   | 
         * Test Classes
        */
        ApplicationKeywords app = new ApplicationKeywords();
        app.openBrowser("browser_name");
        app.openURL("URL");
        app.click("signIn_linkText");
        app.type("username_id", "student");
        app.type("password_id", "Password123");
//        app.enterCaptcha("captcha_id");
        app.clickButton("submitBtn_id");
        app.validateTitle("successTitle");
//        app.click("Create Portfolio Link");
        app.shutdown();
    }
}