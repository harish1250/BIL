package scripts;

import static scripts.Log.loggerINFO;
import static scripts.Log.loggerWARN;
import static scripts.Log.loggerERROR;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
 
public class LogRecord {

	WebDriver driver;
	Actions builder;

	@BeforeClass
	public void setUp() throws Exception {

			driver = new FirefoxDriver();
			builder = new Actions(driver);

			//seleniumDriver = new WebDriverBackedSelenium(driver, "http://www.linkedin.com");
	}
  
	public LogRecord() {
     Log.createLog(this.getClass().getName());
   }
 
 
 @Test
   public  void data() {
			   
    driver.get("http://www.linkedin.com");  										 loggerINFO("Welcome to linkedin Home page");
    driver.findElement(By.id("session_key-login")).sendKeys("hari.allvy@gmail.com"); loggerINFO("Entering username and password");  
 	driver.findElement(By.id("session_password-login")).sendKeys("07g31a1250"); 	 loggerWARN("Check for caps lock");//Log a WARNING message

 	try {
		Thread.sleep(300L);
	 	driver.findElement(By.id("signin")).click(); loggerINFO("Succesfully Loggedin");
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		loggerERROR(e.getMessage());
		e.printStackTrace();
	}
		 	
 	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 	  
 	//Actions builder = new Actions(driver);
 	WebElement element = driver.findElement(By.xpath("//*[@id='top-header']/div/div[2]/ul/li[4]/a")); // Relative Xpath id
 	builder.moveToElement(element).build().perform();
 	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
 
    driver.findElement(By.xpath("//a[contains(text(),'Sign Out')]")).click(); loggerINFO("Succesfully logged out");
     
		   }
   }

