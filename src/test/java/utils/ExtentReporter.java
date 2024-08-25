package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReporter extends CommonMethods {

    public static String reportPath;

    static ExtentReports extentReports;
    static ExtentSparkReporter extentSparkReporter;
    static ExtentTest extentTest;

    public static void initReport() {
        String path = System.getProperty("user.dir") + "\\Reports\\";  //current path
        String fileName = new SimpleDateFormat("ddMMyyyyhmm").format(new Date());  //generate fileName with date&time
        new File(path + "Report_" + fileName).mkdir();                       //new file created
        reportPath = path + "Report_" + fileName;
        extentReports = new ExtentReports();
        extentSparkReporter = new ExtentSparkReporter(reportPath);
        extentReports.attachReporter(extentSparkReporter);
    }

    public static void initTest(String testName) {
        extentTest = extentReports.createTest(testName);
    }

    public static void log(Status logStatus, String message) {
        switch (logStatus) {
            case FAIL:
            case PASS:
            case INFO:
            case SKIP:
            case WARNING:
                extentTest.log(logStatus, message);
        }
    }

    public static void logAlongWithScreenShot(Status logStatus, String message) throws IOException {
        switch (logStatus) {
            case FAIL:
            case PASS:
            case INFO:
            case SKIP:
            case WARNING:
                extentTest.addScreenCaptureFromPath(takeScreenShot(), message);
        }
    }

    public static void endReport(){
        extentReports.flush();
    }
}