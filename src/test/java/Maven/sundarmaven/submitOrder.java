package Maven.sundarmaven;


import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Maven.sundarmaven.testcomp.Basetest;
import io.github.bonigarcia.wdm.WebDriverManager;
import sundarmaven.pageobject.LandingPage;
import sundarmaven.pageobject.ProductCatalogue;
import sundarmaven.pageobject.cartPage;
import sundarmaven.pageobject.checkoutPage;
import sundarmaven.pageobject.lastpage;

public class submitOrder extends Basetest {

	
	@Test(dataProvider="getData",groups={"Purchase"})
	public  void submitOrder(HashMap<String,String> input) throws IOException 
	
	{
		
		
		
		String Country="India";
		ProductCatalogue productCat= landingpage.landing(input.get("email"),input.get("password"));
		List<WebElement> Product=productCat.getproductlist();
		productCat.clicladdtocart(input.get("product"));
		cartPage cartpage=productCat.gotocartPage();
		Boolean match=cartpage.checkavailableproduct(input.get("product"));
		Assert.assertTrue(match);
		checkoutPage checkout=cartpage.gotonextcheckout();
		checkout.checkouttheproduct(Country);
		lastpage latpage=checkout.submitorder();
		String confirmMessage=latpage.valueCheck();
		Assert.assertEquals(confirmMessage,"THANKYOU FOR THE ORDER.");
		

	}
	
	
	
	@DataProvider
	
	public Object[][]  getData() throws IOException
	{
		
		List<HashMap<String, String>> data= getJasondata(System.getProperty("user.dir")+"//src//test//java//Maven//sundarmaven//data//PurchaseOrder.json");
 		return new Object[][] {{data.get(0)},{data.get(1)}};
	}
	//public Object[][]  getData()
	//{
		
	//	return new Object[][] {{"arumugamsaravana05@gmail.com","S@ttur123","ZARA COAT 3"},{"arumugamsaravana05@gmail.com","S@ttur123","ADIDAS ORIGINAL"}};
	//}

	
	//HashMap<String,String> map=new HashMap<String,String>();
	//map.put("email","arumugamsaravana05@gmail.com");
	//map.put("password","S@ttur123");
	//map.put("product","ZARA COAT 3");
	
//	HashMap<String,String> map1=new HashMap<String,String>();
	//map1.put("email","arumugamsaravana05@gmail.com");
	//map1.put("password","S@ttur123");
	//map1.put("product","ADIDAS ORIGINAL");
	//return new Object[][] {{map},{map1}};
}
