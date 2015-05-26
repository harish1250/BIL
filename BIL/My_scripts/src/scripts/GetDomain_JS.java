package scripts;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;


public class GetDomain_JS {

public static void main(String[] args) {
    WebDriver driver=new FirefoxDriver();
    driver.get("https://www.google.co.in");
    driver.manage().window().maximize();

    System.out.println(driver.getCurrentUrl());

    JavascriptExecutor js=(JavascriptExecutor) driver;

    String domain_name=(String) js.executeScript("return document.domain");

            System.out.println(domain_name);

}
}