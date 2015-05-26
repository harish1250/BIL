/************************************Steps to config Grid

1.Run on machine A.

	java -jar selenium-server-standalone-2.44.0.jar -role hub -port 4444

	To verify server started safly Check : http://localhost:4444/grid/console

2.go to http://192.168.0.15:4444/grid/console on machine B.

		Note:192.168.0.15 ip address of machine A where server had started

3.Copy selenium-server-standalone-2.44.0.jar on machine B.

4.Go to the path where selenium-server-standalone-2.44.0.jar has placed and run this
		
		java -jar selenium-server-standalone-2.44.0.jar -role webdriver -hub http://192.168.0.15:4444/grid/register -port 5566

		Note:192.168.0.15 ip address of machine A where server had started

5.In this case, the platform is “Windows7” and the browserName is “crome”.We need to give the following for chrome drive:

		java -jar selenium-server-standalone-2.44.0.jar -role webdriver -hub http://localhost:4444/grid/register -browser browserName="chrome",version=ANY,platform=VISTA,maxInstances=5 -D webdriver.chrome.driver=c:/chromedriver.exe

		Note:c:/chromedriver.exe path where chrome drve placed on local drive*/



package scripts;

import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Grid {
	WebDriver driver;
	String baseurl ,nodeurl;
	@SuppressWarnings("static-access")
	@BeforeTest

	public void setUp() throws Exception {
		
		baseurl = "https://www.google.co.in";
		nodeurl = "http://192.168.0.120:5566/wd/hub";  //IP address of machine B 
		
		 DesiredCapabilities cap = new DesiredCapabilities().firefox();
		 cap.setBrowserName("firefox");
		 cap.setPlatform (Platform.WINDOWS);		
		 cap.setPlatform(org.openqa.selenium.Platform.WINDOWS);
		 
		 driver = new RemoteWebDriver(new URL(nodeurl),cap);
		
	}
	
	@Test
	public void base(){
		driver.get(baseurl);
	}
}
