package scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class verifytext {

	WebDriver driver = new FirefoxDriver();
	
	@Test
	public void test(){
		
		driver.get("https://www.google.co.in/");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		String source = driver.getPageSource();
		String text = "HArinth";
		
		if(source.contains(text)){
			
			System.out.println(text + "Present");
		}else{
			System.out.println(text + "\t" + "noooooo");
		}

	}
	
}
