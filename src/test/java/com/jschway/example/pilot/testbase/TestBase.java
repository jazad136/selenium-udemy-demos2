package com.jschway.example.pilot.testbase;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.jschway.example.pilot.ExtentReportManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    public ExtentReports report;
    public ExtentTest test;
    
    @BeforeMethod
    public void init() { 
        report = ExtentReportManager.getReporter();
        test = report.createTest("Test A");
    }
    @AfterMethod
    public void quit() { 
        report.flush();
    }    
}
