package parallel_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class Parallelexecution {

	 public WebDriver driver ;

	 @BeforeTest
	 @Parameters({ "BROWSER" })
	 public void setup(String BROWSER) {
		 
		 

		 System.out.println("Browser: " + BROWSER);
		 if (BROWSER.equals("FF")) {
			 System.out.println("Firefox Browser is selected");
			 driver = new FirefoxDriver();	
			   
	
		 } else if (BROWSER.equals("CH")) {
			 System.out.println("Google chrome Browser is selected");
			 System.setProperty("webdriver.chrome.driver","G:\\chromedriver.exe");
			 driver = new ChromeDriver();
			
	  }
	 
			driver.get("https://www.google.co.in/");
			driver.findElement(By.xpath(""));
	 
	 }
}
