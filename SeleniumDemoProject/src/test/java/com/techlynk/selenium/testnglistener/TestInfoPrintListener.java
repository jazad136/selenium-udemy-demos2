/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techlynk.selenium.testnglistener;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestInfoPrintListener implements ITestListener {
    
    @Override
    public void onTestFailure(ITestResult result) { 
        System.out.println("******** TEST FAILURE ********");
        ExtentTest test = (ExtentTest) result.getAttribute("reporterObject");
        test.log(Status.INFO, "Test Case Name : " + result.getName());
        System.out.println("Test Case Name : " + result.getName());
        test.fail("Error: " + result.getThrowable().getMessage());
        System.out.println("Error: " + result.getThrowable().getMessage());
    }
    @Override
    public void onTestSuccess(ITestResult result) { 
        System.out.println("******** TEST SUCCESS ********");
        ExtentTest test = (ExtentTest) result.getAttribute("reporterObject");
        test.log(Status.INFO, "Test Case Name : " + result.getName());
        test.pass("Test Status is Success");
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentSparkReporter mergedSpark = new ExtentSparkReporter("src/test/resources/ExtentReportReview/review.html");
        ExtentReports mergedReports = new ExtentReports();
        File jsonOpDirectory = new File("src/test/resources/ExtentReportReview");
        try {
            if(jsonOpDirectory.exists()) { 
                Arrays.stream(jsonOpDirectory.listFiles(ff -> ff.getName().endsWith(".json"))).forEach(f -> {
                    try {
                        mergedReports.createDomainFromJsonArchive(f);
                    } catch(IOException e) { 
                        throw new RuntimeException(e);
                    }
                });
            }
            mergedReports.createDomainFromJsonArchive(new File("target/extent-report.json"));
        } catch(IOException e) { 
            throw new RuntimeException(e);
        }
        mergedReports.attachReporter(mergedSpark);
        mergedReports.flush();
    }
    
    
}
