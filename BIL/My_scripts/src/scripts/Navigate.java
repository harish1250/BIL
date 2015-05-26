package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Navigate {

	@Test
	public void naviga() throws InterruptedException{
		WebDriver driver = new FirefoxDriver();
		//driver.get("http://aksahu.blogspot.in/");
		driver.navigate().to("http://techlearn.in/");
		driver.findElement(By.xpath("//*[@id='menu-329-1']/a")).click();
		Thread.sleep(3000L);
		driver.navigate().back();
		Thread.sleep(3000L);
		driver.navigate().forward();
		
	}
}
