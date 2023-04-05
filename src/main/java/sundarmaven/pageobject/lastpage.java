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

public class lastpage extends AbstractComponent{
	
	  WebDriver driver;
	
	  public lastpage(WebDriver driver) {
		    
		 super(driver); 
		 this.driver=driver;
		 PageFactory.initElements(driver,this);
		 
	 }
	 
	   @FindBy(css=".hero-primary")
		WebElement lasttext;
		
		
		
     public String valueCheck() {
    	 
    	 String confirmmessage=lasttext.getText();
    	 return confirmmessage;
    	 
     }
		
		
	

}
