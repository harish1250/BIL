package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class mousehover {
	
	Actions builder;

@Test

public void hover() throws InterruptedException{
	WebDriver driver = new FirefoxDriver();
	//driver.manage().window().maximize();
	driver.navigate().to("http://techlearn.in/");
	Thread.sleep(3000L);
	
	builder = new Actions(driver);
		
	WebElement element = driver.findElement(By.xpath("//*[@id='menu-328-1']")); // Relative Xpath id
	builder.moveToElement(element).build().perform();
	Thread.sleep(2000L);
    driver.findElement(By.xpath("//a[contains(text(),'Sikuli')]")).click();

}
}
