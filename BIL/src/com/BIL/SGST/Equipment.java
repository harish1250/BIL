package com.BIL.SGST;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Equipment {
	public WebDriver driver;	
	Actions builder;

	@Test
	public void Equipmen() throws Exception{
		driver = new FirefoxDriver();
		driver.get("http://192.168.1.190/SGST");
		driver.findElement(By.name("UserName")).clear();
		driver.findElement(By.name("UserName")).sendKeys("admin");
		driver.findElement(By.name("Password")).clear();
		driver.findElement(By.name("Password")).sendKeys("admin12");
		driver.findElement(By.id("loginbtn")).click();
		
		builder = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//*[@id='wrapper']/div[2]/ul/li[1]/a")); // Relative Xpath id
		builder.moveToElement(element).build().perform();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.findElement(By.xpath("//a[contains(text(),'Equipment')]")).click();
	    
	    driver.findElement(By.xpath("//*[@id='mai_content']/div/form/div/div[1]/a")).click();
	    driver.findElement(By.xpath("//*[@id='equipmentCode']")).sendKeys("E_Code");   

	    Select equipmentTypeid = new Select(driver.findElement(By.xpath("//*[@id='equipmentTypeid']")));		    
	    	   equipmentTypeid.selectByIndex(1);
	   
	    Select plantId = new Select(driver.findElement(By.xpath("//*[@id='plantId']")));		    
	    	   plantId.selectByIndex(1);
	    
	    driver.findElement(By.xpath("//*[@id='EquipmentsModel']")).sendKeys("Model");
	    driver.findElement(By.xpath("//*[@id='EquipmentSerial']")).sendKeys("Serial");
	    
	    
	    WebElement dateWidget = driver.findElement(By.xpath(".//*[@id='mai_content']/div/form/div[1]/div[6]/div[2]/div/div/span/span"));
	    dateWidget.click();
	    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	    
	    WebElement dateWidget1 = driver.findElement(By.xpath("html/body/div[4]/div/table/tbody"));
	    List<WebElement> columns=dateWidget1.findElements(By.tagName("td"));

	    for (WebElement cell: columns){
	       //Select 1 Date 
	       if (cell.getText().equals("1")){
	          cell.findElement(By.linkText("1")).click();
	          break;
	     }
	    }  
	    driver.findElement(By.xpath("//*[@id='equipmentDescription']")).sendKeys("Hahahahah");	    
	    Boolean A = driver.findElement(By.id("active")).isSelected();
	    System.out.println(A);	    
	    
	    //driver.findElement(By.xpath("//div[2]/div/input")).click();  
	}
}
