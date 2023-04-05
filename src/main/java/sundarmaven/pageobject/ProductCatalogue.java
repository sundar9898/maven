package sundarmaven.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import sundarmaven.abstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent{
	
	  WebDriver driver;
	
	  public ProductCatalogue(WebDriver driver) {
		    
		 super(driver); 
		 this.driver=driver;
		 PageFactory.initElements(driver,this);
		 
	 }
	 
	 
		//WebElement Email=driver.findElement(By.id("userEmail"));
	  //List<WebElement> Product=driver.findElements(By.cssSelector(".mb-3"));
	  
		@FindBy(css=".mb-3")
		List<WebElement> Product;
		@FindBy(css="[routerlink*='cart']")
		WebElement cartbu;
		
		By ProductsBy = By.cssSelector(".mb-3");
		By addtocart=By.cssSelector(".card-body button:last-of-type");
		
		public  List<WebElement> getproductlist() {
			
			
			waitforelementtoappear(ProductsBy);
			return Product;
			
		}
		
		public WebElement  getProductbyname(String productname)
		{
			WebElement prod1=getproductlist().stream().filter(prod->prod.findElement(By.cssSelector("b")).getText().equals(productname)).findFirst().orElse(null);
		    return prod1;	
		}
		
		public void clicladdtocart(String productname) {
			
			WebElement prod1=getProductbyname(productname);
			prod1.findElement(addtocart).click();
			waitforelementtoappear(By.cssSelector("#toast-container"));
			waitforelementtodisappear(driver.findElement(By.cssSelector(".ng-animating")));
			
		}
		
		
		
	

}
