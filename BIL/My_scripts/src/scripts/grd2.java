package scripts;

import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class grd2 {
 
 
 public static void main(String []args) throws Exception{
  
  
  // Use DesiredCapabilities class to specify browser

   DesiredCapabilities capability=DesiredCapabilities.firefox();
  
  // now create a object of RemoteWebdriver class and specify the node address and port here localhost will be replaced by remote machine ip address 

 
   WebDriver driver=new RemoteWebDriver(new URL("http://192.168.0.80:5555/wd/hub"), capability);
   
  driver.get("http://www.facebook.com");
  
  driver.manage().window().maximize();
  
  
  
 }

}
