package scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class pdfdown {
        public WebDriver driver=null;
@BeforeMethod
        private void openBrowser(){
        try{
        FirefoxProfile fxProfile = new FirefoxProfile();
        fxProfile.setPreference("browser.download.folderList",2);
        fxProfile.setPreference("browser.download.manager.showWhenStarting",false);
        fxProfile.setPreference("browser.download.dir","G:/pdf");
        fxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk","application/pdf");
        fxProfile.setPreference("browser.download.manager.showWhenStarting", false);
        fxProfile.setPreference("browser.download.manager.focusWhenStarting", false);
        fxProfile.setPreference("browser.helperApps.alwaysAsk.force", false);
        fxProfile.setPreference("browser.download.manager.alertOnEXEOpen", false);
        fxProfile.setPreference("browser.download.manager.closeWhenDone", false);
        fxProfile.setPreference("browser.download.manager.showAlertOnComplete", false);
        fxProfile.setPreference("browser.download.manager.useWindow", false);
        fxProfile.setPreference("browser.download.manager.showWhenStarting",false);
        fxProfile.setPreference("services.sync.prefs.sync.browser.download.manager.showWhenStarting", false);
        fxProfile.setPreference( "pdfjs.disabled", true );
        driver = new FirefoxDriver(fxProfile);
        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.cs.drexel.edu/~spiros/teaching/SE320/slides/selenium.pdf");
        Thread.sleep(2000);
        }catch(Throwable t){
        System.err.println("There is an issue in launching the application ,please check "+t); 
        }        }
       
@Test
        public void PDFDOWNLOAD() throws InterruptedException{
        Thread.sleep(1000);
        driver.switchTo().frame(driver.findElement(By.className("toolbar")));
        driver.findElement(By.id("download")).click();
        Thread.sleep(5000);        } 
@BeforeTest        
        public void beforeTest() {  }
@AfterTest
        public void afterTest() {
        }

}

