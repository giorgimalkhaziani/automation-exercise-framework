package utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    public void onTestStart(ITestResult result) {
        System.out.println("Starting test: " + result.getName());
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("Test passed: " + result.getName());
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("Test failed: " + result.getName());
        try {
            if (result.getTestClass().getName().contains("ui")) {
                DriverManager.takeScreenshot();
            }
        } catch (Exception e) {
            System.out.println("Screenshot failed");
        }
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("Test skipped: " + result.getName());
    }

    public void onStart(ITestContext context) {
        System.out.println("Starting suite: " + context.getName());
    }

    public void onFinish(ITestContext context) {
        System.out.println("Finished suite: " + context.getName());
    }
}
