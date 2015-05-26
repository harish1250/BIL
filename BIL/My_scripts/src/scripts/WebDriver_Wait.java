package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class WebDriver_Wait {
	Actions builder;
	@Test

	public void hover() throws InterruptedException{
		
		System.setProperty("webdriver.ie.driver","G:\\IEDriverServer.exe");
		 
		 WebDriver driver = new InternetExplorerDriver();
		//driver.manage().window().maximize();
		driver.navigate().to("http://techlearn.in/");
	
		
		builder = new Actions(driver);
		
		WebElement element = driver.findElement(By.xpath("//*[@id='menu-328-1']")); // Relative Xpath id
		builder.moveToElement(element).build().perform();
		Thread.sleep(3000L);

		WebDriverWait wait = new WebDriverWait(driver, 3000L);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Sikuli')]"))).click();;
		

}}
