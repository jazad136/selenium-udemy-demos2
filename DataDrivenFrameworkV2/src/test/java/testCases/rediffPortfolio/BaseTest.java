package testCases.rediffPortfolio;

import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import keywords.ApplicationKeywords;
import reports.ExtentManager;

/**
 *
 * @author JonathanSaddler
 */
public class BaseTest {
    ApplicationKeywords app;
    public ExtentReports extentReport;
    public ExtentTest extentTest;
    @BeforeTest
    public void beforeTest(ITestContext context) {
        ApplicationKeywords app = new ApplicationKeywords();
        context.setAttribute("app", app);
        
        extentReport = ExtentManager.getReports();
        extentTest = extentReport.createTest(context.getCurrentXmlTest().getName());
        app.setReport(extentTest);
        app.i("Starting Test : " + context.getCurrentXmlTest().getName());
        
        context.setAttribute("extentReport", extentReport);
        context.setAttribute("extentTest", extentTest);
    }
    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(ITestContext context) { 
        app = (ApplicationKeywords) context.getAttribute("app");
        extentReport = (ExtentReports) context.getAttribute("extentReport");
        extentTest = (ExtentTest) context.getAttribute("extentTest");
    }
//    @AfterMethod(alwaysRun = true)
//    public void afterMethod() { 
//    	System.out.println("***** After Method *****");
//    }
    @AfterTest
    public void afterTest(ITestContext context) {
//        System.out.println("***** After Test *****");
    	app = (ApplicationKeywords) context.getAttribute("app");
    	if(app != null)
    		app.quitDriver();

    	extentReport = (ExtentReports) context.getAttribute("extentReport");
    	if(extentReport != null) 
    		extentReport.flush();
    }
}
