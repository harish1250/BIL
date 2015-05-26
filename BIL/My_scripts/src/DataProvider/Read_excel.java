package DataProvider;

import java.io.File;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Read_excel {
	// Create webdriver interface reference as fields of test class
				WebDriver driver;
				String Path = "D:\\Hari\\BIL.WS\\Hari\\src\\Data_Repo\\Read.xls";
				String BaseUrl ="https://foursquare.com/";
				// Call class method setup, and instanciate webdriver interface reference with FirefoxDriver
				@BeforeClass
				public void setUp() {
					System.setProperty("webdriver.chrome.driver","D:\\Hari\\chrome_driver\\chromedriver.exe");
					driver = new ChromeDriver();						
				}

				// Call class method tearDown, and close firefox driver instance
				@AfterClass
				public void tearDown() {
					//driver.quit();
				}
				
				@DataProvider(name = "data-provider", parallel = false)
				public Object[][] data() throws Exception {
					Object[][] retObjArr=getTableArray(Path,"Sheet1", "Start", "End");
			        return(retObjArr);
				}
				
				public String[][] getTableArray(String xlFilePath, String sheetName, String tableStartName, String tableEndName) throws Exception{
			        String[][] tabArray=null;
			        
			            Workbook workbook = Workbook.getWorkbook(new File(xlFilePath));
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

				// Call the test method
				@Test(dataProvider="data-provider")
			
					  public final void test(String Mail,String mobile,String FName,String LName,String Date,String Month,String Year ) 
							  throws InterruptedException {
							driver.get(BaseUrl+"signup");
							driver.manage().window().maximize();
						    driver.findElement(By.id("inputEmail")).clear();
						    driver.findElement(By.id("inputEmail")).sendKeys(Mail);
						    driver.findElement(By.id("inputPassword")).clear();
						    driver.findElement(By.id("inputPassword")).sendKeys(mobile);
						    driver.findElement(By.id("inputFirstName")).clear();
						    driver.findElement(By.id("inputFirstName")).sendKeys(FName);
						    driver.findElement(By.id("inputLastName")).clear();
						    driver.findElement(By.id("inputLastName")).sendKeys(LName);
						    driver.findElement(By.id("inputBirthDate")).clear();
						    driver.findElement(By.id("inputBirthDate")).sendKeys(Date);
						    driver.findElement(By.name("birthMonth")).clear();
						    driver.findElement(By.name("birthMonth")).sendKeys(Month);
						    driver.findElement(By.name("birthYear")).clear();
						    driver.findElement(By.name("birthYear")).sendKeys(Year);
						    driver.findElement(By.id("inputMale")).click();
						  }


}
