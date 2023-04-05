package sundarmaven.abstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import sundarmaven.pageobject.cartPage;

public class AbstractComponent {

	WebDriver driver;
	public AbstractComponent(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		
		 PageFactory.initElements(driver,this);
		
	}
	@FindBy(css="[routerlink*='cart']")
	WebElement cartbu;
	
	public void waitforelementtoappear(By byfind) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(byfind));	
		
	}
	public void waitforwebelementtoappear(WebElement byfind) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(byfind));	
		
	}
	
	
	public void waitforelementtodisappear(WebElement byfind) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(2));
		wait.until(ExpectedConditions.invisibilityOf(byfind));	
		
	}
	
	
	public cartPage gotocartPage() {
		
		cartbu.click();
		
		cartPage cartpage=new cartPage(driver);
		
		return cartpage;
	}
	

}
