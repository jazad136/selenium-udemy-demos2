package com.jschway.example.pilot.testbase;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.jschway.example.pilot.ExtentReportManager;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public class TestBase {
    public ExtentReports report;
    public ExtentTest test;
    public SoftAssert softAssert;
    @BeforeMethod(alwaysRun=true)
    public void init(ITestResult res) { 
        report = ExtentReportManager.getReporter();
        test = report.createTest(res.getMethod().getMethodName().toUpperCase());
        res.setAttribute("reporterObject", test);
        softAssert = new SoftAssert();
    }
    @AfterMethod
    public void quit() { 
        report.flush();
    }
    
    /** Print the log in the extent report */
    public void log(String msg) { 
        System.out.println(msg);
        test.info(msg);
    }
    
    public void pass(String msg) { 
        System.out.println(msg);
        test.pass(msg);
    }
    public void fail(String msg) { 
        System.out.println(msg);
        test.fail(msg);
    }
    public void skip(String msg) { 
        System.out.println(msg);
        test.skip(msg);
    }
    
    
    /** Print SoftAssert in extent report, Fail the Test in TestNG */
    public void softAssert(String msg) { 
        fail(msg);
        softAssert.fail(msg);
    }
    
    /** Print SoftAssert error in Extent and Stop Test Execution */
    public void failAndStop(String msg) { 
        log(msg);
        softAssert.assertAll();
    }
}