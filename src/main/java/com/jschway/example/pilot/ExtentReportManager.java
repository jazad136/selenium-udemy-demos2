/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jschway.example.pilot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 *
 * @author JonathanSaddler
 */
public class ExtentReportManager {
    private static ExtentReports extent;
    private ExtentReportManager() { } 
    
    public static ExtentReports getReporter() {
        if(extent == null) { 
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter("index.html");
            spark.config().setTheme(Theme.STANDARD);
            spark.config().setReportName("TestNG Pilot Project");
            spark.config().setDocumentTitle("TestNG Extent Report");
            extent.attachReporter(spark);
        }
        return extent;
    }
    
}
