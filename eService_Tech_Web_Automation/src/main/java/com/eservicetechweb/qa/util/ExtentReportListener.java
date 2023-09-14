package com.eservicetechweb.qa.util;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.eservicetechweb.qa.base.BaseClass;
import com.eservicetechweb.qa.base.Constants;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.ITestContext;

import org.testng.ITestListener;

import org.testng.ITestResult;

import java.io.IOException;

import java.nio.file.Files;

import java.nio.file.Path;

import java.nio.file.Paths;

import java.util.Calendar;

import java.util.Date;


public class ExtentReportListener extends BaseClass implements ITestListener {


    public static String FILE_NAME = new Date().getTime() + "__" + "eServiceTechWebTest.html";
    public static String date;


    public static int pass_tc = 0;
    public static int fail_tc = 0;
    public static int skip_tc = 0;
    public static int total_tc;
    public static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
    UpdateResults updateResults;
    ExtentReportListener extentReportListener;


    public ExtentReportListener() throws IOException {

    }

    private static ExtentReports init() {


        Path path = Paths.get(Constants.OUTPUT_FOLDER);


        if (!Files.exists(path)) {

            try {

                Files.createDirectories(path);

            } catch (IOException e) {

                e.printStackTrace();

            }

        }

        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(Constants.OUTPUT_FOLDER + FILE_NAME);
        System.out.println(Constants.OUTPUT_FOLDER + FILE_NAME);

        htmlReporter.config().setDocumentTitle("Automation Test Results");

        htmlReporter.config().setReportName("Automation Test Results");

//htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);

        htmlReporter.config().setTheme(Theme.STANDARD);

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setReportUsesManualConfiguration(true);
        extent.setSystemInfo("Windows", "10");
        extent.setSystemInfo("User Name", System.getProperty("user.name"));
        extent.setSystemInfo("Browser", "Chrome");


        return extent;

    }

    public synchronized void onStart(ITestContext context) {


        System.out.println("Test Suite started!");


    }

    public synchronized void onFinish(ITestContext context) {

        try {

            extentReportListener = new ExtentReportListener();


        } catch (IOException e2) {

            e2.printStackTrace();

        }
        total_tc = pass_tc + fail_tc + skip_tc;
        System.out.println("Total number of pass cases: " + pass_tc);
        System.out.println("Total number of fail cases: " + fail_tc);
        System.out.println("Total number of skip cases: " + skip_tc);
        System.out.println("Total number of test cases: " + total_tc);
        updateResults = new UpdateResults();
        try {
            updateResults.updateJson(pass_tc, fail_tc, skip_tc);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }


        extent.flush();
        test.remove();

    }

    public synchronized void onTestStart(ITestResult result) {

        String methodName = result.getMethod().getMethodName();

        System.out.println(methodName + " started!");

        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName(),

                result.getMethod().getDescription());


        extentTest.assignCategory(result.getMethod().getGroups());


        test.set(extentTest);
        test.get().getModel().setStartTime(getTime(result.getStartMillis()));
        date = getTime(result.getStartMillis()).toString();

    }

    public synchronized void onTestSuccess(ITestResult result) {

        System.out.println((result.getMethod().getMethodName() + " passed!"));

//p test = extent.createTest(result.getName(), "This test case is passed");
        test.get().pass("Test passed");
        test.get().getModel().setEndTime(getTime(result.getEndMillis()));


        if (result.getStatus() == ITestResult.SUCCESS) {
            System.out.println("Test Success");
            pass_tc += 1;


        }

    }

    public synchronized void onTestFailure(ITestResult result) {

        System.out.println((result.getMethod().getMethodName() + " failed!"));

        test.get().fail(result.getThrowable());
        test.get().fail("Test failed");
        fail_tc += 1;
        test.get().getModel().setEndTime(getTime(result.getEndMillis()));


        try {

//System.out.println("Take Screenshot");
//            test.get().addScreenCaptureFromPath(BaseClass.getScreenshot());

        } catch (Exception e) {

            e.printStackTrace();

        }

        if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println("Test Failed");

        }


    }

    public synchronized void onTestSkipped(ITestResult result) {

        System.out.println((result.getMethod().getMethodName() + " skipped!"));
        test.get().getModel().setEndTime(getTime(result.getEndMillis()));


        if (result.getStatus() == ITestResult.SKIP) {
            System.out.println("Test skip");
            skip_tc += 1;

        }

    }

    @Override

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {


    }

    private Date getTime(long millis) {

        Calendar calendar = Calendar.getInstance();

        calendar.setTimeInMillis(millis);

        return calendar.getTime();

    }

    private static ExtentReports extent = init();


}




