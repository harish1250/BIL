package scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ownxpath {

	WebDriver driver;
	 @BeforeTest
	 public void start(){
	 //System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");  
	 driver = new FirefoxDriver();
	 }
	 
	 @Test
	 public void test(){
		 
		 driver.get("http://allvy.com/");
		 

		 
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
//.//*[@id='container']/header/div/div[2]/div[2]/ul/li[6]/a
		
		driver.findElement(By.xpath("//div[4]/div/a")).click();
	
		 //	driver.findElement(By.cssSelector("")).click();

	 }
	 
}
