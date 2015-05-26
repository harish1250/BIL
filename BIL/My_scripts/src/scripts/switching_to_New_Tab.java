package scripts;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class switching_to_New_Tab {
	@Test(groups = { "foo" })
	public void newwindow() throws InterruptedException{
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://knowledgebase-wiki.appspot.com");
		driver.findElement(By.xpath("//*[@id='mainPanel']/div[1]/div[1]/span[2]/a")).click();
		Thread.sleep(3000L);
		//String windowHandle = driver.getWindowHandle();	windowHandle holding parent window 
		//driver.switchTo().window(windowHandle);             Switching to new window
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		
		driver.findElement(By.xpath("//*[@id='HTML2']/div[1]/form/input[1]")).sendKeys("new tab");
		driver.quit();
	}
	
	@Test
	public void newtab() throws InterruptedException{
		WebDriver driver = new FirefoxDriver();
		//driver.manage().window().maximize();
		driver.manage().window().setSize(new Dimension(320, 480)); //resize the browser window to a certain window size
		driver.navigate().to("http://knowledgebase-wiki.appspot.com");
		driver.findElement(By.xpath("//*[@id='mainPanel']/div[1]/div[1]/span[2]/a")).click();
		Thread.sleep(3000L);
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		 
		//Switch to new window / tab
		driver.switchTo().window(tabs.get(1));
		driver.findElement(By.xpath("//*[@id='HTML2']/div[1]/form/input[1]")).sendKeys("new tab");

	
		
	}
	
	
	
	
	
	
}
