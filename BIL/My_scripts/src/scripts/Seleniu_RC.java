package scripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;

@SuppressWarnings("deprecation")
public class Seleniu_RC {
   
    Selenium selenium;
   
    @BeforeClass
    public void startSelenium(){
        selenium = new DefaultSelenium("localhost", 8080, "*firefox", "http://www.google.com");
        selenium.start();
        selenium.windowMaximize();
    }
   
    @Test
    public void testGoogleSearch(){    
        selenium.open("/");
        selenium.type("id=lst-ib", "selenium");
        selenium.click("name=btnK");
        selenium.click("link=Selenium - Web Browser Automation");
        selenium.waitForPageToLoad("30000");
    }
   
    @AfterClass
    public void stopSelenium(){    
        selenium.stop();
    }
}