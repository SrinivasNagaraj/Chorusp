package org.Chorus.genericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class   ListnerImplementation implements ITestListener{

	@Override //@BM
	public void onTestStart(ITestResult result) {
		
		
	}

	@Override //@AM
	public void onTestSuccess(ITestResult result) {
		
	}

	@Override //@AM
	public void onTestFailure(ITestResult result) {
	
			try {
				new WebDriverUtility().screenShot(BaseClass.sdriver, BaseClass.sjavaUtility, result.getMethod().getMethodName() );
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		
		}
		
	

	@Override //@AM
	public void onTestSkipped(ITestResult result) {
		
		
	}

	@Override //@AM
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	@Override //@BT
	public void onStart(ITestContext context) {
		
		
	}

	@Override //@AT
	public void onFinish(ITestContext context) {
		
		
	}

}
