package testListener;

import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 *
 * @author JonathanSaddler
 */
public class MyTestNGListener implements ITestListener {
    public void onTestFailure(ITestResult result) { 
        System.out.println("****** TEST FAIL ******");
    }
    public void onTestSuccess(ITestResult result) { 
        System.out.println("****** TEST SUCCESS ******");
    }
    public void onTestSkipped(ITestResult result) { 
        System.out.println("****** TEST SKIPPED ******");
    }
}
