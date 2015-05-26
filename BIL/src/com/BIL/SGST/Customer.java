package com.BIL.SGST;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Customer extends login{
	
	@Test
	public void create_Customer(){		
		
		builder = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//*[@id='wrapper']/div[2]/ul/li[1]/a")); // Relative Xpath id
		builder.moveToElement(element).build().perform();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.findElement(By.xpath("//a[contains(text(),'Customer')]")).click();
	    
	    driver.findElement(By.xpath("//*[@id='mai_content']/div/div/form/div[1]/a")).click();		// click on '+' button

	    driver.findElement(By.xpath("//*[@id='customerCode']")).clear();
	    driver.findElement(By.xpath("//*[@id='customerCode']")).sendKeys("C001234");
	    
	    driver.findElement(By.xpath("//*[@id='CustomerName']")).clear();
	    driver.findElement(By.xpath("//*[@id='CustomerName']")).sendKeys("AQUAMALL WATER SOLUTIONS LTDBHIMTAL");
	    
	    driver.findElement(By.xpath("//*[@id='customerAddress']")).clear();
	    driver.findElement(By.xpath("//*[@id='customerAddress']")).sendKeys("hyd");
	    
	    driver.findElement(By.xpath("//*[@id='City']")).clear();
	    driver.findElement(By.xpath("//*[@id='City']")).sendKeys("hyd");
	    
	   Select Country = new Select(driver.findElement(By.xpath("//*[@id='Country']")));		    
	    	   Country.selectByVisibleText("India");
 	   		   
 	   	Select state = new Select(driver.findElement(By.xpath("//*[@id='State']")));		    
 	   		   state.selectByVisibleText("Andhra Pradesh");
	    
	    driver.findElement(By.xpath("//*[@id='Pin']")).clear();
	    driver.findElement(By.xpath("//*[@id='Pin']")).sendKeys("510002");
	    
	    driver.findElement(By.xpath("//*[@id='Phone']")).clear();
	    driver.findElement(By.xpath("//*[@id='Phone']")).sendKeys("9999999999");
	    
	    driver.findElement(By.xpath("//*[@id='Email']")).clear();
	    driver.findElement(By.xpath("//*[@id='Email']")).sendKeys("hari@gmail.com");   

	    driver.findElement(By.xpath("//form/div[2]/div/input")).click(); 
	    
	}
}
