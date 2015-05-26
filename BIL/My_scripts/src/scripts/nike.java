package scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class nike {

	WebDriver driver;
	
	@Test
	public void data() throws Exception{
		
		//driver = new FirefoxDriver();
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("intl.accept_languages",".eg");
		driver = new FirefoxDriver(profile); 
		driver.get("https://www.google.co.in");

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebElement w = driver.findElement(By.id("gb_70"));
		String s= w.getAttribute("class");
		System.out.println(s);
		Actions act = new Actions(driver);
		act.moveToElement(w).perform();
		act.contextClick().perform();
		
	
		//w.clear();
	/*	WebDriverWait wait = new WebDriverWait(driver, 10);
 
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("someid")));
		
		WebElement myDynamicElement = (new WebDriverWait(driver, 10))
				  .until(ExpectedConditions.presenceOfElementLocated(By.id("myDynamicElement")));*/
	}
}
