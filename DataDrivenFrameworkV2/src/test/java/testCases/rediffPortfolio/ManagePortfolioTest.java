package testCases.rediffPortfolio;

import java.io.File;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;

/**
 *
 * @author JonathanSaddler
 */
public class ManagePortfolioTest extends BaseTest{
    @Test
    public void createPortfolio(ITestContext con) { 
        app.i("Creating portfolio...");
        app.openBrowser("browser_name");
        app.openURL("URL");
    }
    @Test
    public void deletePortfolio() { 
        app.i("Deleting portfolio...");
    }
}
