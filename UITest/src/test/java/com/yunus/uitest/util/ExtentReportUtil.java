package com.yunus.uitest.util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportUtil {
    private static ExtentReports extent;
    private static ExtentTest test;

    public static void setUp() {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("src/test/resources/extent-report.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    public static ExtentTest startTest(String testName, String testDescription) {
        test = extent.createTest(testName, testDescription);
        return test;
    }

    public static void endTest() {
        extent.flush();
    }

    public static void logToReport(Status status, String logMessage) {
        test.log(status, logMessage);
    }
}