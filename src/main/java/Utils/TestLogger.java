package Utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

/**
 * Basic Logging on Test Methods
 */
public class TestLogger implements ITestListener {
    @Override
    public void onTestStart(ITestResult iTestResult) {
        Reporter.log("Test Started " + iTestResult.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        Reporter.log("Test Passed " + iTestResult.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Reporter.log("Test Failed " + iTestResult.getMethod().getMethodName());
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        Reporter.log("Test Skipped " + iTestResult.getMethod().getMethodName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        Reporter.log("Test partially failed " + iTestResult.getMethod().getMethodName());
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        Reporter.log("Test Started " + iTestContext.getSuite().getName());
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        Reporter.log("Test Finished " + iTestContext.getSuite().getName());
    }
}
