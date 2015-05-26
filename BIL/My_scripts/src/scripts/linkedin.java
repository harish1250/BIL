package scripts;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class linkedin {	

	WebDriver driver;

	//Selenium seleniumDriver;

	Actions builder;

	@BeforeClass

	public void setUp() throws Exception {

	//driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver","D:\\Hari\\chrome_driver\\chromedriver.exe");
		driver = new ChromeDriver();
		builder = new Actions(driver);

	//seleniumDriver = new WebDriverBackedSelenium(driver, "http://www.linkedin.com");

	}
	@AfterClass

	public void exit() throws Exception {

	//driver.quit();

	//seleniumDriver = new WebDriverBackedSelenium(driver, "http://www.linkedin.com");

	}
	@Test public void pageload() throws InterruptedException, AWTException{

	driver.get("http://www.linkedin.com");

    
	driver.findElement(By.id("session_key-login")).sendKeys("hari.allvy@gmail.com");
	driver.findElement(By.id("session_password-login")).sendKeys("07g31a1250");
	Thread.sleep(300L);
	//driver.findElement(By.id("signin")).click();
	 // Create object of Robot class
	  Robot r=new Robot();
	 
	   // Press Enter
	   r.keyPress(KeyEvent.VK_ENTER);
	 
	   // Release Enter
	   r.keyRelease(KeyEvent.VK_ENTER);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
//Actions builder = new Actions(driver);
	WebElement element = driver.findElement(By.xpath("//*[@id='top-header']/div/div[2]/ul/li[4]/a")); // Relative Xpath id
	builder.moveToElement(element).build().perform();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.findElement(By.xpath("//a[contains(text(),'Sign Out')]")).click();
    
 
  
	  
}
}   



