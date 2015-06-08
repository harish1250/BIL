package Test;

import java.io.File;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class test {

	public WebDriver driver;

	// private static String url = "http://192.168.1.190/ems";
	// String Path = "D:\\Hari\\GIT\\GitHub\\BIL\\src\\Data_Repo\\EMS.xls";

	@BeforeClass
	public void setUp() throws Exception {

		System.setProperty("webdriver.chrome.driver",
				"D:\\Hari\\chrome_driver\\chromedriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("test-type");
		capabilities.setCapability("chrome.binary",
				"D:\\Hari\\chrome_driver\\chromedriver.exe");
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(capabilities);
		driver.get("http://192.168.1.190/ems");
		driver.findElement(By.id("txtUserName")).clear();
		driver.findElement(By.id("txtUserName")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).clear();
		driver.findElement(By.id("txtPassword")).sendKeys("admin");
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(500L);

		/* Home screen -- Navigate to new consultent */

		driver.switchTo().frame(driver.findElement(By.name("Contents")));
		driver.findElement(By.xpath("//*[@id='Menutable']/tbody/tr[3]/td/a"))
				.click();
		Thread.sleep(500L);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.name("main")));
		driver.findElement(By.xpath("//*[@id='lnkNewCons']")).click();
		Thread.sleep(500L);
	}

	@DataProvider(name = "DP1")
	public Object[][] createData1() throws Exception {

		Object[][] retObjArr = getTableArray(
				"D:\\Hari\\GIT\\GitHub\\BIL\\src\\Data_Repo\\EMS.xls", "gmail",
				"Start", "End");

		return (retObjArr);
	}

	@Test(dataProvider = "DP1")
	public void testDataProviderExample(String Fname, String Lname,
			String Mobileno, String EmailId, String NCPeriod, String Exp,
			String Rev_Exp, String state, String City, String Salary,
			String sal_period, String Sal_Type, String groups,
			String pre_location, String Skills, String Recruiter, String Rec_source)
			throws Exception {

		/* Enter Login page details */

		Thread.sleep(5000L);
		/* Enter personal employee details */

		driver.findElement(By.id("txtfname")).clear();
		driver.findElement(By.id("txtfname")).sendKeys(Fname);
		driver.findElement(By.id("txtlname")).clear();
		driver.findElement(By.id("txtlname")).sendKeys(Lname);
		driver.findElement(By.id("txtcell")).clear();
		driver.findElement(By.id("txtcell")).sendKeys(Mobileno);
		driver.findElement(By.id("txtemail1")).clear();
		driver.findElement(By.id("txtemail1")).sendKeys(EmailId);
		driver.findElement(By.id("txtNoticePeriod")).clear();
		driver.findElement(By.id("txtNoticePeriod")).sendKeys(NCPeriod);

		Select Emp_exp = new Select(driver.findElement(By.id("ddlExperience")));
		Emp_exp.selectByVisibleText(Exp);

		Select Relevent_EXP = new Select(driver.findElement(By
				.id("ddlRelExperience")));
		Relevent_EXP.selectByVisibleText(Rev_Exp);

		Select State = new Select(driver.findElement(By.id("ddlState")));
		State.selectByVisibleText(state);

		driver.findElement(By.id("txtCity")).clear();
		driver.findElement(By.id("txtCity")).sendKeys(City);

		driver.findElement(By.id("txtsalary")).clear();
		driver.findElement(By.id("txtsalary")).sendKeys(Salary);

		Select salry_period = new Select(driver.findElement(By.id("ddlPeriod")));
		salry_period.selectByVisibleText(sal_period);

		Select Salary_Type = new Select(driver.findElement(By
				.id("ddlSalaryType")));
		Salary_Type.selectByVisibleText(Sal_Type);

		/* Marketing Details */
		
		/* Marketing Details */
		Select group = new Select(driver.findElement(By.id("ddlGroup")));
		group.selectByVisibleText(groups);

		driver.findElement(By.id("txtprelocation")).clear();
		driver.findElement(By.id("txtprelocation")).sendKeys(pre_location);
		
		driver.findElement(By.id("txtSkills")).clear();
		driver.findElement(By.id("txtSkills")).sendKeys(Skills);

		Select Rec = new Select(driver.findElement(By.id("ddlRecruiter")));
		Rec.selectByVisibleText(Recruiter);

		Thread.sleep(500L);//
		
		Select Rec_src = new Select(driver.findElement(By
				.cssSelector("#ddlRecuSource")));
		Rec_src.selectByVisibleText(Rec_source);
		


		Thread.sleep(500L);
		//driver.findElement(By.id("btnSubmit")).click();
	}

	@AfterClass
	public void tearDown() {
		// driver.close();
		// selenium.stop();
	}

	public String[][] getTableArray(String xlFilePath, String sheetName,
			String tableStartName, String tableEndName) throws Exception {

		String[][] tabArray = null;

		Workbook workbook = Workbook.getWorkbook(new File(xlFilePath));
		Sheet sheet = workbook.getSheet(sheetName);
		int startRow, startCol, endRow, endCol, ci, cj;
		Cell tableStart = sheet.findCell(tableStartName);
		startRow = tableStart.getRow();
		startCol = tableStart.getColumn();

		// Cell tableEnd = sheet.findCell(tableEndName, startCol + 1,
		// startRow + 1, 100, 100, false);

		Cell tableEnd = sheet.findCell(tableEndName, startCol + 1,
				startRow + 1, 100, 64000, false);

		endRow = tableEnd.getRow();
		endCol = tableEnd.getColumn();
		tabArray = new String[endRow - startRow - 1][endCol - startCol - 1];
		ci = 0;

		for (int i = startRow + 1; i < endRow; i++, ci++) {
			cj = 0;
			for (int j = startCol + 1; j < endCol; j++, cj++) {
				tabArray[ci][cj] = sheet.getCell(j, i).getContents();
			}
		}

		return (tabArray);
	}

}
