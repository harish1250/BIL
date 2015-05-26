package scripts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class spicejet {
	

		  public WebDriver driver;
		  private String baseUrl;
		  
		  @BeforeClass
		  public void setUp() throws Exception {
		    driver = new FirefoxDriver();
		    baseUrl = "http://www.spicejet.com/";
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		    driver.manage().window().maximize();
		  }

		  @Test
		  public void testSpice() throws Exception {
		    driver.get(baseUrl);
		    driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		    driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).click();
		    driver.findElement(By.linkText("Hyderabad (HYD)")).click();
		    driver.findElement(By.xpath("(//a[contains(text(),'Delhi (DEL)')])[2]")).click();
		    //Click on textbox so that datepicker will come
		    driver.findElement(By.xpath("//*[@id='ctl00_mainContent_txt_Fromdate']")).click();
		    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		    
		   //Click on next so that we will be in next month
		    driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/div/a/span")).click();
		    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		    driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/div/a/span")).click();
		    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		    driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/div/a/span")).click();
		    
		    /*DatePicker is a table.So navigate to each cell 
		     * If a particular cell matches value 13 then select it
		     */
		    WebElement dateWidget = driver.findElement(By.id("ui-datepicker-div"));
		    List<WebElement> columns=dateWidget.findElements(By.tagName("td"));
		    
		    for (WebElement cell: columns){
		    //Select 13th Date 
		     if (cell.getText().equals("8")){
		     cell.findElement(By.linkText("8")).click();
		     break;
		     }
		    	
		    } 
	}

}