/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reports;

import java.io.File;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 *
 * @author JonathanSaddler
 */
public class ExtentManager {
    public static ExtentReports reports;
    public static File screenshotPath;
    public static ExtentReports getReports() {
        if(reports == null) { 
            reports = new ExtentReports();
            Date date = new Date();
            String reportFolderName = date.toString().replaceAll(":", "_").replaceAll(" ", "-");
            File reportPath = new File("target/Reports", reportFolderName);
            screenshotPath = new File(reportPath, "Screenshots");
            screenshotPath.mkdirs();
            ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
            reporter.config().setTheme(Theme.STANDARD);
            reporter.config().setReportName("Production Test Report");
            reporter.config().setDocumentTitle("Data Driven Test Report");
            reporter.config().setEncoding("utf-8");
            reports.attachReporter(reporter);
        }
        return reports;
    }
}
