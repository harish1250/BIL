package Test;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class test {
	Actions builder;
	WebDriver driver ;
	
	@BeforeTest
	public void t() throws InterruptedException{
	System.setProperty("webdriver.ie.driver", "D:\\Hari\\IEDriverServer.exe");

	InternetExplorerDriver driver =new InternetExplorerDriver();
	driver.get("http://192.168.1.190/SGST/"); 
	
	driver.findElement(By.name("UserName")).clear();
	driver.findElement(By.name("UserName")).sendKeys("admin");
	
	driver.findElement(By.name("Password")).clear(); 							 
	driver.findElement(By.name("Password")).sendKeys("admin12");
	Thread.sleep(300L);
	driver.findElement(By.id("loginbtn")).click();
	
	Thread.sleep(300L);
	}
	@Test
	public void create_Part_Management() throws InterruptedException, IOException{		
		
		builder = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//*[@id='wrapper']/div[2]/ul/li[3]/a")); // Relative Xpath id
		builder.moveToElement(element).build().perform();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.findElement(By.xpath("//a[contains(text(),'Setup Sheet Management')]")).click();	    
	    driver.findElement(By.xpath("//*[@id='mai_content']/div/div[1]/div[2]/a")).click();		// click on '+' button
	
	    Select Process = new Select(driver.findElement(By.xpath("//*[@id='PROCESSTYPE']")));		    
 	           Process.selectByVisibleText("SMT");
 	           
 	    driver.findElement(By.id("SETUPSHEETCODE")).sendKeys("Test");
 	    
 	    
 	   WebElement dateWidget = driver.findElement(By.xpath("//span/span"));
	   dateWidget.click();
	    
	    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	    WebElement dateWidget1 = driver.findElement(By.xpath("html/body/div[4]/div/table/tbody"));
	    List<WebElement> columns=dateWidget1.findElements(By.tagName("td"));

	    for (WebElement cell: columns){
	       //Select 1 Date 
	       if (cell.getText().equals("12")){
	          cell.findElement(By.linkText("12")).click();
	          break;
	     }
	    }  
 	    
	  driver.findElement(By.id("mysearch1")).click();
	  
	   for (String winHandle : driver.getWindowHandles()) {
		    driver.switchTo().window(winHandle); 
			}// switch focus of WebDriver to the next found window handle (that's your newly opened window)
	   
	   
	   driver.findElement(By.id("ITEMCODE")).clear();
	   driver.findElement(By.id("ITEMCODE")).sendKeys("fmicro");
	   driver.findElement(By.id("Productsearch")).click();
	   driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);  
	   driver.findElement(By.xpath("//a[contains(text(),'FMICROWBWORSPOWERLED')]")).click();
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	}


}
