package sundarmaven.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sundarmaven.abstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {
	
	  WebDriver driver;
	  
	
	  public LandingPage(WebDriver driver) {
		    
		  super(driver);
		 this.driver=driver;
		
		 PageFactory.initElements(driver,this);
		 
	 }
	 
	 
		//WebElement Email=driver.findElement(By.id("userEmail"));
		
		@FindBy(id="userEmail")
		WebElement useremail;
		@FindBy(id="userPassword")
		WebElement userPassword;
		@FindBy(id="login")
		WebElement Login;
		@FindBy(css="[class*='flyInOut']")
		WebElement errormessage;
		
		
		public ProductCatalogue landing(String email,String pass) {
			
			useremail.sendKeys(email);
			userPassword.sendKeys(pass);
			Login.click();
			ProductCatalogue productCat=new ProductCatalogue(driver);
			return productCat;
			
		}
		public String geterrortext() {
			
			waitforwebelementtoappear(errormessage);
			
			String errotext=errormessage.getText();
			return errotext;
			
		}
		
		public void Goto() {
			
			driver.get("https://rahulshettyacademy.com/client");
		}
	

}
