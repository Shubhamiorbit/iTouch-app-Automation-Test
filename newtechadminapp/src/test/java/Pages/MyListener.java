package Pages;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener {

	public void onStart(ITestContext context ) {
		System.out.println("Test Execution Started....");
	}
	public void onTestStart(ITestResult result ) {
		System.out.println("Test Started....");
	}
	
	public void onTestSuccuss(ITestResult result ) {
		System.out.println("Test passed....");
	}
	public void onTestFailure(ITestResult result ) {
		System.out.println("Test failed....");
	}
	public void onTestSkipped(ITestResult result ) {
		System.out.println("Test Skipped....");
	}
	public void onFinish(ITestContext context) {
		System.out.println("Test Finished....");
	}
}


