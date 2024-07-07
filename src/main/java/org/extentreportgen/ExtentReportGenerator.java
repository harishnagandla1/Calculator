package org.extentreportgen;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportGenerator {

    public static ExtentReports getExtentReporter(){
        String reportFilePath = System.getProperty("user.dir") + "\\reports\\extentReport.html";
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(reportFilePath);
        extentSparkReporter.config().setReportName("Calculator App Automation Report");
        extentSparkReporter.config().setDocumentTitle("Calculator Results");
        ExtentReports extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        extentReports.setSystemInfo("Automation Tester","Harish Nagandla");
        return extentReports;
    }
}
