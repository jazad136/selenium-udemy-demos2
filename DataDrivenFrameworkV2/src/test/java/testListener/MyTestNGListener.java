package testListener;

import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 *
 * @author JonathanSaddler
 */
public class MyTestNGListener implements ITestListener {
    public void onTestFailure(ITestResult result) { 
        ExtentTest test = (ExtentTest) result.getTestContext().getAttribute("extentTest");
        test.fail(result.getThrowable().getMessage());
    }
    public void onTestSuccess(ITestResult result) { 
        ExtentTest test = (ExtentTest) result.getTestContext().getAttribute("extentTest");
        test.pass("Test Success : " + result.getName());
    }
    public void onTestSkipped(ITestResult result) { 
        ExtentTest test = (ExtentTest) result.getTestContext().getAttribute("extentTest");
        test.skip(result.getName() + " :: Test Skipped Due to Critical Error in Previous Test");
    }
}
