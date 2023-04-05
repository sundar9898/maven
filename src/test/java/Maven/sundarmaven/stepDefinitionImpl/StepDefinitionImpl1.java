package Maven.sundarmaven.stepDefinitionImpl;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Maven.sundarmaven.testcomp.Basetest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import sundarmaven.pageobject.LandingPage;
import sundarmaven.pageobject.ProductCatalogue;
import sundarmaven.pageobject.cartPage;
import sundarmaven.pageobject.checkoutPage;
import sundarmaven.pageobject.lastpage;

public class StepDefinitionImpl1 extends Basetest{

	public LandingPage Landingpage;
	public ProductCatalogue productCat;
	String confirmMessage;
	public lastpage latpage;
	
	@Given("I Landed on Ecommerce page")
	
	
	public void I_landed_on_Ecommerce_page() throws IOException {
		
		Landingpage= LaunchApplication();
	}
	
	@Given("^login with username (.+) and password (.+)$")
	
	public void loggedin_name_password(String username,String password){
		productCat= landingpage.landing(username,password);
		
	}	
	
	@When("^I add product (.+) to cart$")
	
	public void addproduct(String Productname)
	{
		List<WebElement> Product=productCat.getproductlist();
		productCat.clicladdtocart(Productname);
	}
	
	@And("^Checkout (.+) and submit order$")
	public void Checkout_product(String Productname)
	{
		cartPage cartpage=productCat.gotocartPage();
		Boolean match=cartpage.checkavailableproduct(Productname);
		Assert.assertTrue(match);
		checkoutPage checkout=cartpage.gotonextcheckout();
		checkout.checkouttheproduct("India");
	    latpage=checkout.submitorder();
		
	}
	@Then("{string} message is displayed on Confirmationpage")
	
	public void stringcompare(String string){
		String confirmMessage=latpage.valueCheck();
		Assert.assertEquals(confirmMessage,string);	
		driver.close();
	}
	
	@Then("{string} error is displayed on Confirmationpage")
	public void errormessage(String string)
	
	{
		Assert.assertEquals(string,landingpage.geterrortext());	
		
	}
	
}
