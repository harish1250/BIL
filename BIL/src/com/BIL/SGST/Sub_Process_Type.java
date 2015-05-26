package com.BIL.SGST;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Sub_Process_Type extends login{

	
	@Test
	public void Sub_ProcessType() throws InterruptedException, IOException{		
		
		builder = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//*[@id='wrapper']/div[2]/ul/li[1]/a")); // Relative Xpath id
		builder.moveToElement(element).build().perform();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.findElement(By.xpath("//a[contains(text(),'Subprocess Type')]")).click();	    
	    driver.findElement(By.xpath("//*[@id='mai_content']/div/div/div[2]/a")).click();
	    driver.findElement(By.id("SUBPROCESSCODE")).clear();
	    driver.findElement(By.id("SUBPROCESSCODE")).sendKeys("");
	    
	    Select Process = new Select(driver.findElement(By.xpath("//*[@id='PROCESSTYPEID']")));		    
 	   		   Process.selectByVisibleText("SMT");
 	   		   
 	    driver.findElement(By.id("SUBPROCESSDESCRIPTION")).clear();
 	    driver.findElement(By.id("SUBPROCESSDESCRIPTION")).sendKeys("ggjhgjgjgjhg");
 	   
		driver.findElement(By.xpath("//div[2]/div/input")).click();
	}
}
