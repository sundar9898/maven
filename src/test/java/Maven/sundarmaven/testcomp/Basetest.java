package Maven.sundarmaven.testcomp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import sundarmaven.pageobject.LandingPage;

public class Basetest {
	
   public	WebDriver driver;
	public LandingPage landingpage;

	public  void InitializeDriver() throws IOException {
	
		Properties prop=new Properties();
		FileInputStream ins=new FileInputStream("C:\\Users\\sattu\\eclipse-workspace\\sundarmaven\\src\\main\\java\\sundarmaven\\resourse\\GlobalData.properties");
		prop.load(ins);
		String browsername=System.getProperty("browser")!=null ? System.getProperty("browser"):prop.getProperty("browser");
		if(browsername.contains("chrome") )
		{
		 ChromeOptions options=new ChromeOptions();
		 
		 if(browsername.contains("headless")){
			 options.addArguments("headless");
		 }	     WebDriverManager.chromedriver().setup();
	     
	     driver=new ChromeDriver(options);
	     driver.manage().window().setSize(new Dimension(1400,900));
	    
	    
		}
		else if(browsername.equalsIgnoreCase("firefox") )
		{
	     WebDriverManager.chromedriver().setup();
	     driver=new ChromeDriver();
	     
		}
		else if (browsername.equalsIgnoreCase("edge")) 
		{
	     WebDriverManager.edgedriver().setup();
	     driver=new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
public List<HashMap<String, String>> getJasondata(String Filepath) throws IOException {
		
		//read jason to string
		String jasonContent =FileUtils.readFileToString(new File(System.getProperty("user.dir")+"//src//test//java//Maven//sundarmaven//data//PurchaseOrder.json"),StandardCharsets.UTF_8);
        //string to HashMap jackson databind
		
		ObjectMapper mapper=new ObjectMapper();
		List<HashMap<String,String>> data=mapper.readValue(jasonContent,new TypeReference<List<HashMap<String,String>>>(){});
		
		return data;

	}
public String getscreenshot(String testcasename, WebDriver driver ) throws IOException {
	
	
	 TakesScreenshot ts=(TakesScreenshot)driver;
	 
	File source=ts.getScreenshotAs(OutputType.FILE);
	File trg= new File(System.getProperty("user.dir")+"//report//"+testcasename+".png");
	FileUtils.copyFile(source, trg);
	
	return System.getProperty("user.dir")+"//report//"+testcasename+".png";
	
	
	
}
 
	
	@BeforeMethod(alwaysRun=true)
	public  LandingPage LaunchApplication() throws IOException {
		
		InitializeDriver();
		landingpage=new LandingPage(driver);
		landingpage.Goto();
		return landingpage;
	}
	
	@AfterMethod(alwaysRun=true)

	public void teardown() {
		
		driver.close();
	}
	

}
