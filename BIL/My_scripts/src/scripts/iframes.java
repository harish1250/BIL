package scripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class iframes {

	@Test
	public void main(){
		
		WebDriver driver = new FirefoxDriver();			
		List<WebElement> iframes = driver.findElements(By.tagName("iframe"));		
		System.out.println(iframes.size());
		
		for (int i = 0 ; i<= iframes.size() ;i++){
			
			driver.switchTo().frame(i);			
			System.out.println("Iframe:" + i + "Start********");			
			System.out.println(driver.getPageSource()); //Printing HTML code of Iframe			
			System.out.println("Iframe:" + i + "End********");			
			driver.switchTo().defaultContent();			
			
		}
	}
}
