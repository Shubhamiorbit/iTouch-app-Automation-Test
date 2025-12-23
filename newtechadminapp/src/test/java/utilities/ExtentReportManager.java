//package utilities;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import org.testng.ITestContext;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.reporter.configuration.Theme;
//
//import Pages.BaseClass;
//
//public class ExtentReportManager implements ITestListener {
//	
//public ExtentSparkReporter SparkReporter;
//public ExtentReports extent;
//public ExtentTest test;
//
//String repoName;
//public void onStart(ITestContext context) {
//	String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
//	repoName="Test-Report-"+timeStamp +".html";
//	SparkReporter = new ExtentSparkReporter("reports/" + repoName);
//	SparkReporter.config().setReportName("End-End Test");
//	SparkReporter.config().setTheme(Theme.DARK);
//	
//	extent =new ExtentReports();
//	extent.attachReporter(SparkReporter);
//	extent.setSystemInfo("Application", "Tech Admin App");
//	extent.setSystemInfo("Username", System.getProperty("User.name" ));
//	extent.setSystemInfo("Environment", "QA");
//}
//
//
//	
//		
//	
//@Override
//public void onTestSuccess(ITestResult result) {
//		test=extent.createTest(result.getTestClass().getName());
//		test.log(Status.PASS, result.getName()+"Got Succussfully Executed");
//		}
//	@Override
//	public void onTestFailure(ITestResult result ) {
//		test=extent.createTest(result.getTestClass().getName());
//		test.log(Status.FAIL, result.getName()+"Got Failed");
//		test.log(Status.INFO, result.getThrowable().getMessage());
//		try {
//		String imgpath = new BaseClass().captureScreen(result.getName());
//		test.addScreenCaptureFromPath(imgpath);
//		}catch (Exception e1) {
//			e1.printStackTrace();
//		}
//	}
//	@Override
//	public void onTestSkipped(ITestResult result ) {
//		test=extent.createTest(result.getTestClass().getName());
//		test.log(Status.SKIP, result.getName()+"Got Skipped");
//		test.log(Status.INFO, result.getThrowable().getMessage());
//		String imgpath = new BaseClass().captureScreen(result.getName());
//		test.addScreenCaptureFromPath(imgpath);
//	}
//	@Override
//	public void onFinish(ITestContext context) {
//extent.flush();
//}
//
//	
//
//}
//
//package utilities;
//
//import java.io.File;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import org.testng.*;
//
//import com.aventstack.extentreports.*;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.reporter.configuration.Theme;
//
//import Pages.BaseClass;
//
//public class ExtentReportManager implements ITestListener {
//
//    private static ExtentReports extent;
//    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
//
//    @Override
//    public void onStart(ITestContext context) {
//
//        new File("reports").mkdirs();
//
//        String timeStamp =
//                new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
//
//        String reportPath = "reports/Test-Report-" + timeStamp + ".html";
//
//        ExtentSparkReporter spark =
//                new ExtentSparkReporter(reportPath);
//
//        spark.config().setTheme(Theme.DARK);
//        spark.config().setReportName("Tech Admin Automation Report");
//
//        extent = new ExtentReports();
//        extent.attachReporter(spark);
//
//        extent.setSystemInfo("OS", System.getProperty("os.name"));
//        extent.setSystemInfo("User", System.getProperty("user.name"));
//        extent.setSystemInfo("Environment", "QA");
//        extent.setSystemInfo("Device", "Android Emulator");
//        extent.setSystemInfo("Automation", "Appium + TestNG");
//
//        System.out.println("=== Extent Report Started ===");
//    }
//
//    @Override
//    public void onTestStart(ITestResult result) {
//        ExtentTest extentTest =
//                extent.createTest(result.getMethod().getMethodName());
//
//        test.set(extentTest);
//
//        test.get().log(Status.INFO, "Test Started");
//    }
//
//    @Override
//    public void onTestSuccess(ITestResult result) {
//        test.get().log(Status.PASS, "Test Passed");
//    }
//
//    @Override
//    public void onTestFailure(ITestResult result) {
//
//        test.get().log(Status.FAIL, result.getThrowable());
//
//        try {
//            String screenshot =
//                    BaseClass.captureScreen(result.getMethod().getMethodName());
//            test.get().addScreenCaptureFromPath(screenshot);
//        } catch (Exception e) {
//            test.get().log(Status.WARNING, "Screenshot failed: " + e.getMessage());
//        }
//    }
//
//    @Override
//    public void onTestSkipped(ITestResult result) {
//        test.get().log(Status.SKIP, "Test Skipped");
//    }
//
//    @Override
//    public void onFinish(ITestContext context) {
//        extent.flush();
//        System.out.println("=== Extent Report Finished ===");
//    }
//}

package utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.*;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Pages.BaseClass;

public class ExtentReportManager implements ITestListener {

    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onStart(ITestContext context) {

        new File("reports").mkdirs();

        String timeStamp =
                new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

        ExtentSparkReporter spark =
                new ExtentSparkReporter("reports/Test-Report-" + timeStamp + ".html");

        spark.config().setTheme(Theme.DARK);
        spark.config().setReportName("Tech Admin Automation");

        extent = new ExtentReports();
        extent.attachReporter(spark);

        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("User", System.getProperty("user.name"));
        extent.setSystemInfo("Env", "QA");

        System.out.println(">>> EXTENT STARTED");
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest =
                extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.get().fail(result.getThrowable());

        try {
            String screenshot =
                    BaseClass.captureScreen(result.getMethod().getMethodName());
            test.get().addScreenCaptureFromPath(screenshot);
        } catch (Exception e) {
            test.get().warning("Screenshot failed: " + e.getMessage());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().skip("Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
        System.out.println(">>> EXTENT FINISHED");
    }
}

