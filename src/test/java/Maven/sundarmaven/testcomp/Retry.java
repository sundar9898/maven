package Maven.sundarmaven.testcomp;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry extends Basetest implements IRetryAnalyzer{

	
	int count=0;
	int maxTry=1;
	@Override
	public boolean retry(ITestResult result) {
		if(count<maxTry){
			count++;
			return true;
			
		} 
		
		return false;
	}

	

}
