package testCases.rediffPortfolio;

import keywords.ApplicationKeywords;
import org.testng.ITestContext;
import org.testng.annotations.Test;

/**
 *
 * @author JonathanSaddler
 */
public class ManageSessionTest extends BaseTest{
    @Test
    public void doLogin(ITestContext con) { 
        app.i("***** Login Application *****");
        app.openBrowser("browser_name");
        app.openURL("URL");
        // arbitrary added failure
        app.reportFailure("Unable to open URL ....");
        app.click("signIn_linkText");
        app.type("username_id", "student");
        // arbitrary added failure
        app.reportFailure("Unable to Click submit button", true);
        app.type("password_id", "Password123");
        
    }
    @Test
    public void doLogout() { 
        app.i("***** LogOut Application *****");
    }
}
