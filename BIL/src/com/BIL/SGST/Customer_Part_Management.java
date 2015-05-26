package com.BIL.SGST;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Customer_Part_Management extends login{

	@Test
	public void create_Part_Management() throws InterruptedException, IOException{		
		
		builder = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//*[@id='wrapper']/div[2]/ul/li[1]/a")); // Relative Xpath id
		builder.moveToElement(element).build().perform();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.findElement(By.xpath("//a[contains(text(),'Customer Part Management')]")).click();	    
	    driver.findElement(By.xpath("//*[@id='mai_content']/div/div/form/div[1]/a")).click();		// click on '+' button
	    
		    Select Process = new Select(driver.findElement(By.xpath("//*[@id='Process']")));		    
		    	   Process.selectByVisibleText("PCB");
	 		   
	 	    Select customerId = new Select(driver.findElement(By.xpath("//*[@id='customerId']")));		    
	 	   		   customerId.selectByVisibleText("Data Test Info Ltd");
	 	   		  
	 	    Select plant = new Select(driver.findElement(By.xpath("//*[@id='plant']")));		    
	 	           plant.selectByVisibleText("SGS TEKNIKS MFG PVT LTD-MANESAR");
 	   		  
 	   	driver.findElement(By.xpath("//*[@id='PartNumber']")).sendKeys("98745");
 	   	driver.findElement(By.xpath("//*[@id='Description']")).sendKeys("fgbdbvc"); 	   	
 	    driver.findElement(By.xpath(".//*[@id='mysearch1']")).click();
 	   	
	 	    for (String winHandle : driver.getWindowHandles()) {
	 		    driver.switchTo().window(winHandle); 
	 			}// switch focus of WebDriver to the next found window handle (that's your newly opened window)
 	   
 	    driver.findElement(By.name("shortDescription")).clear();
 	    driver.findElement(By.name("shortDescription")).sendKeys("fmicro"); 	   
 	    driver.findElement(By.id("mysearch")).click();
 	    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);  
 	    driver.findElement(By.xpath("//a[contains(text(),'FMICROWBWORSPOWERLED')]")).click();
 	    driver.findElement(By.id("Revision")).clear();
 	    driver.findElement(By.id("Revision")).sendKeys("Test");
 	    driver.findElement(By.id("StartNumber")).clear();
 	    driver.findElement(By.id("StartNumber")).sendKeys("10");
 	    driver.findElement(By.id("Length")).clear();
	    driver.findElement(By.id("Length")).sendKeys("2");
 	    driver.findElement(By.id("Prefix")).clear();
 	    driver.findElement(By.id("Prefix")).sendKeys("HT");
 	    driver.findElement(By.id("Suffix")).clear();
	    driver.findElement(By.id("Suffix")).sendKeys("H");
 	  
		    Select F2 = new Select(driver.findElement(By.xpath("//*[@id='F2']")));		    
		  		 F2.selectByVisibleText("FG Item Code");
		  		 
		    Select F3 = new Select(driver.findElement(By.xpath("//*[@id='F3']")));		    
		  		 F3.selectByVisibleText("Customer Part No");
		  		 
		    Select F4 = new Select(driver.findElement(By.xpath("//*[@id='F4']")));		    
		  		 F4.selectByVisibleText("Plant");
		   		 
		    Select F5 = new Select(driver.findElement(By.xpath("//*[@id='F5']")));		    
		  		 F5.selectByVisibleText("Quantity");
		  		 
		    Select F6 = new Select(driver.findElement(By.xpath("//*[@id='F6']")));		    
		  		 F6.selectByVisibleText("DateCode");
	  		   		 
	    driver.findElement(By.xpath("//a[contains(text(),'Julian\n days')]")).click();
	
	    Thread.sleep(100L);
	  
	    driver.findElement(By.xpath("//*[@id='FileUpload1']")).click();		 
	    Runtime.getRuntime().exec("D:\\Hari\\BIL.WS\\BIL\\src\\Auto_IT\\Rpmfile.exe");		   
		   
	    driver.findElement(By.xpath("//div[@id='mai_content']/div/form/div[12]/div/input")).click(); 
 
	}
}
