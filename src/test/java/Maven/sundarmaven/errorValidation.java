package Maven.sundarmaven;


import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import Maven.sundarmaven.testcomp.Basetest;
import io.github.bonigarcia.wdm.WebDriverManager;
import sundarmaven.pageobject.LandingPage;
import sundarmaven.pageobject.ProductCatalogue;
import sundarmaven.pageobject.cartPage;
import sundarmaven.pageobject.checkoutPage;
import sundarmaven.pageobject.lastpage;

public class errorValidation extends Basetest {

	

	@Test(groups={"error"},retryAnalyzer= Maven.sundarmaven.testcomp.Retry.class)
	public  void loginerrorValidation() throws IOException
	
	{
				
		String productname="ZARA COAT 3";
		String Country="India";
		landingpage.landing("arumugamsaravana05@gmail.com","S00tur123");
		
		Assert.assertEquals("Incorrect email or password",landingpage.geterrortext());
		
}
	
	@Test(groups="error")
	public  void OrdererrorValidation() throws IOException
	
	{
		
		
		String productname="ZARA COAT 3";
		String Country="India";
		ProductCatalogue productCat= landingpage.landing("arumugamsaravana05@gmail.com","S@ttur123");
		List<WebElement> Product=productCat.getproductlist();
		productCat.clicladdtocart(productname);
		cartPage cartpage=productCat.gotocartPage();
		Boolean match=cartpage.checkavailableproduct("ZARA COAT 33");
		Assert.assertFalse(match);
	
}
}