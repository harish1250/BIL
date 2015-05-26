package Test;


import java.io.File;
import java.util.concurrent.TimeUnit;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class linkedin {	

	WebDriver driver;
	String Path = "D:\\Hari\\BIL.WS\\Hari\\src\\Data_Repo\\Read.xls";
	//Selenium seleniumDriver;

	Actions builder;

	@BeforeClass

	public void setUp() throws Exception {

	//driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver","D:\\Hari\\chrome_driver\\chromedriver.exe");
		driver = new ChromeDriver();
		builder = new Actions(driver);

	//seleniumDriver = new WebDriverBackedSelenium(driver, "http://www.linkedin.com");

	}
	@AfterClass

	public void exit() throws Exception {

	//driver.quit();

	//seleniumDriver = new WebDriverBackedSelenium(driver, "http://www.linkedin.com");
	}
	
	@BeforeTest
	@DataProvider(name = "data-provider", parallel = false)
	public Object[][] data() throws Exception {
		Object[][] retObjArr=getTableArray(Path,"Sheet1", "Start", "End");
        return(retObjArr);
	}
	
	public String[][] getTableArray(String xlFilePath, String sheetName, String tableStartName, String tableEndName) throws Exception{
        String[][] tabArray=null;
        
            Workbook workbook = Workbook.getWorkbook(new
            		File(xlFilePath));
            Sheet sheet = workbook.getSheet(sheetName); 
            int startRow,startCol, endRow, endCol,ci,cj;
            /*********************Reading Cell Data*********************************/
            Cell tableStart=sheet.findCell(tableStartName);
            
            startRow=tableStart.getRow();
            startCol=tableStart.getColumn();

            Cell tableEnd= sheet.findCell(tableEndName, startCol+1,startRow+1, 100, 100,  false);                

            endRow=tableEnd.getRow();
            endCol=tableEnd.getColumn();
            tabArray=new String[endRow-startRow-1][endCol-startCol-1];
            ci=0;

            for (int i=startRow+1;i<endRow;i++,ci++){
                cj=0;
                for (int j=startCol+1;j<endCol;j++,cj++){
                    tabArray[ci][cj]=sheet.getCell(j,i).getContents();
                }
            }
        

        return(tabArray);
    }
	@Test(dataProvider="data-provider")
	
	public void pageload(String Mail,String pwd,String clicksignin) throws InterruptedException{

	driver.get("http://www.linkedin.com");    
	driver.findElement(By.id("session_key-login")).sendKeys(Mail);
	driver.findElement(By.id("session_password-login")).sendKeys(pwd);
	Thread.sleep(300L);
	driver.findElement(By.id(clicksignin)).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
//Actions builder = new Actions(driver);
	WebElement element = driver.findElement(By.xpath("//*[@id='top-header']/div/div[2]/ul/li[4]/a")); // Relative Xpath id
	builder.moveToElement(element).build().perform();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.findElement(By.xpath("//a[contains(text(),'Sign Out')]")).click();
    
 
  
	  
}
}   



