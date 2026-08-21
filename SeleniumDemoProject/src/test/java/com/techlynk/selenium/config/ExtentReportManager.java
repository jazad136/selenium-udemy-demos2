package com.techlynk.selenium.config;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.JsonFormatter;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author JonathanSaddler
 */
public class ExtentReportManager {
    private static ExtentReports extent;
    private ExtentReportManager() { } 
    
    public static String getJsonArchive() { 
        return "target/extent-report.json";
    }
    public static ExtentReports getReporter() {
        if(extent == null) { 
            extent = new ExtentReports();
            final File CONF = new File("src/test/resources/ExtentConfigs/extentConfig.xml");
            ExtentSparkReporter spark = new ExtentSparkReporter("extent-report.html");
            JsonFormatter json = new JsonFormatter("target/extent-report.json");
            
            // load xml configuration
            try {spark.loadXMLConfig(CONF);} 
            catch(IOException e) {
                throw new RuntimeException("Could not set up suite with XML configuration"
                        + " at src/main/resources/ExtentConfigs/extentConfig.xml");
            }
            extent.attachReporter(spark, json);
        }
        return extent;
    }
    
}
