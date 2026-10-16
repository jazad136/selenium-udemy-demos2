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
    }
    @Test
    public void doLogout() { 
        app.i("***** LogOut Application *****");
    }
}
