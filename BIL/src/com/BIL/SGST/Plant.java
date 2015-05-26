package com.BIL.SGST;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Plant extends login{

	@Test
	public void create_Plant() throws InterruptedException, IOException{		
		
		builder = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//*[@id='wrapper']/div[2]/ul/li[1]/a")); // Relative Xpath id
		builder.moveToElement(element).build().perform();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.findElement(By.xpath("//a[contains(text(),'Plant')]")).click();	    
	    driver.findElement(By.xpath("//*[@id='mai_content']/div/div/div[2]/a")).click();
	    driver.findElement(By.id("plantCode")).clear();
	    driver.findElement(By.id("plantCode")).sendKeys("");
	    driver.findElement(By.id("plantDescription")).clear();
	    driver.findElement(By.id("plantDescription")).sendKeys("");
	    driver.findElement(By.xpath("//div[@id='mai_content']/div/form/div[2]/div/input")).click();

	}
}
