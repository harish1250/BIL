package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class gmail {
	
	WebDriver driver ;			

	@Test
	public void main(){
		
		driver.get("https://www.google.co.in/");
		driver.findElement(By.id("gbqfq")).sendKeys("hkhhk");
			
		}
	@BeforeClass
	public void setUp() {
		
		driver = new FirefoxDriver();						
	}
	
}
