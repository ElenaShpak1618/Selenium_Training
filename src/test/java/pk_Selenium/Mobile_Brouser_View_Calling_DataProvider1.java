package pk_Selenium;
import org.openqa.selenium.Dimension;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;



public class   Mobile_Brouser_View_Calling_DataProvider1 extends Test_Data  {
	
	WebDriver driver;
	
  
  @Test(dataProvider="Mobile_Devices")
  public void LaunchBrowser(int heigt, int width) {
	  WebDriverManager.chromedriver().setup();
	 
	  
	  //ChromeOptions iPhoneOption = new ChromeOptions();
	  
	  driver = new ChromeDriver();
	  //Iphone Pro
	   Dimension d = new Dimension(heigt, width);
	   
	  
	  //driver.manage().window().maximize();
	  driver.manage().window().setSize(d);
	  driver.get("https://demo.spreecommerce.org/t.categories/women");
	  
 }

  @AfterTest
  public void afterTest() {
	  driver.quit();
	  
  }

}
