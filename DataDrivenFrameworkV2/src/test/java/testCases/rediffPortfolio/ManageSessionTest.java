package testCases.rediffPortfolio;

import org.testng.ITestContext;
import org.testng.annotations.Test;

/**
 *
 * @author JonathanSaddler
 */
public class ManageSessionTest extends BaseTest{
    @Test
    public void doLogin(ITestContext con) { 
        app.i("Login Application");
        app.openBrowser("browser_name");
        app.openURL("URL");
        app.click("signIn_linkText");
        app.type("username_id", "student");
        app.type("password_id", "Password123");
        app.clickButton("submitBtn_id");
        app.reportAll();
    }
    @Test
    public void doLogout() { 
        app.i("***** LogOut Application *****");
    }
}
