package sundarmaven.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import sundarmaven.abstractComponents.AbstractComponent;

public class checkoutPage extends AbstractComponent{
	
	  WebDriver driver;
	
	  public checkoutPage(WebDriver driver) {
		    
		 super(driver); 
		 this.driver=driver;
		 PageFactory.initElements(driver,this);
		   
	 }
	 
	   @FindBy(css="[placeholder='Select Country']")
		WebElement country;
		@FindBy(css=".ta-results")
		WebElement waitele;
		@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
		WebElement select;
		@FindBy(css=".action__submit")
		WebElement submit;
		
		
     public void checkouttheproduct(String countryname) {
    	 
    	 Actions a=new Actions(driver);
 		a.sendKeys(country,countryname).build().perform();
 		waitforelementtoappear(By.cssSelector(".ta-results"));
 		select.click();
    	 
    	 
     }


	public lastpage submitorder() {
		submit.click();
		lastpage latpage=new lastpage(driver);
		return latpage;
		
	}
		
		
	

}
