package com.BIL.SGST;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Equipment_Type extends login {
		
	
	@Test
	public void EquipmentType(){		
		
		builder = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//*[@id='wrapper']/div[2]/ul/li[1]/a")); // Relative Xpath id
		builder.moveToElement(element).build().perform();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.findElement(By.xpath("//a[contains(text(),'Equipment Type')]")).click();
	    
	    driver.findElement(By.xpath("//*[@id='mai_content']/div/div/div[2]/a")).click();		// click on '+' button
	    
	    driver.findElement(By.xpath("//*[@id='equipmentType']")).clear();
	    driver.findElement(By.xpath("//*[@id='equipmentType']")).sendKeys("Test");
	    
	    driver.findElement(By.xpath("//*[@id='equipmentDescription']")).clear();
	    driver.findElement(By.xpath("//*[@id='equipmentDescription']")).sendKeys("Test Description");
	    
	    driver.findElement(By.xpath("//div[2]/div/input")).click(); 
	    
	}
}
