package com.BIL.SGST;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;

import LoG_Class.Log;
import static LoG_Class.Log.loggerERROR;
import static LoG_Class.Log.loggerINFO;
import static LoG_Class.Log.loggerWARN;


public class login {
	
	public WebDriver driver;
	Actions builder;
	String expectedTitle = "Product Traceability System";	
	private static Logger L = Logger.getLogger(login.class.getName());

	@BeforeTest
	public void loadURL() throws IOException {
		Log.createLog(this.getClass().getName());
		DOMConfigurator.configure("log4j.xml");
		
		File file = new File("D:\\Hari\\BIL.WS\\BIL\\src\\Config_files\\test.properties");
		FileInputStream fileInput = new FileInputStream(file);
		Properties properties = new Properties();
		properties.load(fileInput);
		String url = properties.getProperty("Url"); 	

		ProfilesIni profile = new ProfilesIni(); 									loggerINFO("Firefox profile created");
		FirefoxProfile myprofile = profile.getProfile("Hari");						loggerINFO("Profile Access ");
 
		driver = new FirefoxDriver(myprofile);										L.info("New driver instantiated");
		driver.get(url); 															loggerINFO("Welcome to Product Traceability System");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);			L.info("Implicit wait applied on the driver for 10 seconds");
		
		
		//Assert.assertEquals( driver.getTitle(), expectedTitle);

		if (driver.getTitle().equals(expectedTitle))
		{ 
		try {
			
		System.out.println("Tests passed"); 			
			
		driver.findElement(By.name("UserName")).clear();
		driver.findElement(By.name("UserName")).sendKeys("admin");
		
		driver.findElement(By.name("Password")).clear(); 							 loggerWARN("Check for caps lock");
		driver.findElement(By.name("Password")).sendKeys("admin12");		
				
		
		 	driver.findElement(By.id("loginbtn")).click(); loggerINFO("Succesfully Loggedin");
			Thread.sleep(300L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			loggerERROR(e.getMessage());
			e.printStackTrace();
		}
		//Assert.assertEquals(expectedTitle, actualTitle);
		
		}
		
	else{
		System.out.println("Wrong Page Opened"); 
	}	

}
	


	/*@AfterTest
	 public void teardown(){		
		//driver.close();
		driver.quit();
	}
	*/
	}
