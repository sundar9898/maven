package Maven.sundarmaven.testcomp;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import sundarmaven.resourse.ExtentreportNG;

public class Listeners extends Basetest implements ITestListener {
	
	  ExtentTest test;
      ExtentReports extent= ExtentreportNG.getreportfile();
      ThreadLocal<ExtentTest>  extenttest=new ThreadLocal<ExtentTest>();
      
      @Override
	  public  void onTestStart(ITestResult result) {
		    test=extent.createTest(result.getMethod().getMethodName());
		    extenttest.set(test);
		  }

      
      @Override
		 public  void onTestSuccess(ITestResult result) {
		    // not implemented
		  }

		  /**
		   * Invoked each time a test fails.
		   *
		   * @param result <code>ITestResult</code> containing information about the run test
		   * @see ITestResult#FAILURE
		   */
      @Override
		public  void onTestFailure(ITestResult result) {
		    extenttest.get().fail(result.getThrowable());
		   try { 
		    driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		   }
		   catch (Exception e1){
			   
			   e1.getStackTrace();
		   }
		   String filepath=null;
		   		try {
			filepath = getscreenshot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   		extenttest.get().addScreenCaptureFromPath(filepath,result.getMethod().getMethodName());
      }
		 
      @Override
	  	public  void onTestSkipped(ITestResult result) {
		    // not implemented
		  }

		  /**
		   * Invoked each time a method fails but has been annotated with successPercentage and this failure
		   * still keeps it within the success percentage requested.
		   *
		   * @param result <code>ITestResult</code> containing information about the run test
		   * @see ITestResult#SUCCESS_PERCENTAGE_FAILURE
		   */
		@Override
		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		    // not implemented
		  }

		  /**
		   * Invoked each time a test fails due to a timeout.
		   *
		   * @param result <code>ITestResult</code> containing information about the run test
		   */
		  @Override
		  public void onTestFailedWithTimeout(ITestResult result) {
		    onTestFailure(result);
		  }

		  @Override
		  public void onStart(ITestContext context) {
		    // not implemented
		  }

		  /**
		   * Invoked after all the test methods belonging to the classes inside the &lt;test&gt; tag have
		   * run and all their Configuration methods have been called.
		   *
		   * @param context The test context
		   */
		  @Override
		  public void onFinish(ITestContext context) {
		   extent.flush();
		  }	

}
