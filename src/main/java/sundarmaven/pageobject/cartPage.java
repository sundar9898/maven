package sundarmaven.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import sundarmaven.abstractComponents.AbstractComponent;

public class cartPage extends AbstractComponent{
	
	  WebDriver driver;
	
	  public cartPage(WebDriver driver) {
		    
		 super(driver); 
		 this.driver=driver;
		 PageFactory.initElements(driver,this);
		 
	 }
	 
	   
	
		@FindBy(css=".cartSection h3")
		List<WebElement> Product;
		@FindBy(xpath="//li/button[@type='button']")
		WebElement nextpage;
		

		
		public  Boolean checkavailableproduct(String productname ) {
			
			Boolean match=Product.stream().anyMatch(l->l.getText().equalsIgnoreCase(productname));
			return match;
		}
		
		
		public checkoutPage gotonextcheckout(){
			nextpage.click();
			
			checkoutPage checkout=new checkoutPage(driver);
			return checkout;
		}
		
		
		
	

}
