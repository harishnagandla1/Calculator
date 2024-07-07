package org.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.extentreportgen.ExtentReportGenerator;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

public class TestListeners implements ITestListener {
    ExtentReports extentReports = ExtentReportGenerator.getExtentReporter();
    ExtentTest extentTest;
    ThreadLocal<ExtentTest> extentTestThread = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        extentTest = extentReports.createTest(result.getMethod().getMethodName() + Arrays.toString(result.getParameters()));
        extentTestThread.set(extentTest);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTestThread.get().fail(result.getThrowable());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String firstParam = result.getParameters()[0].toString();
        String secondParam = result.getParameters()[1].toString();
        String calculatorResult = result.getParameters()[2].toString();
        extentTestThread.get().log(Status.PASS, result.getMethod().getMethodName() + "With First Parameter : " + firstParam + ", Second Parameter : " + secondParam + " And Result Of Calculation : " + calculatorResult + " Successfully Completed");
    }

    @Override
    public void onFinish(ITestContext context) {
        extentReports.flush();
    }
}
