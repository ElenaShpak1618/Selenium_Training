package pk_Selenium;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Weborder_Login_Using_Keyboard {
  WebDriver driver;
	
  @Test
  public void KeybourdAction() throws InterruptedException {
	  
	  driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester", Keys.TAB);
	  driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test", Keys.ENTER);
	  Assert.assertEquals(driver.findElement(By.xpath("//h1[normalize-space()='Web Orders']")).getText(),
	  "Web Orders");
	  Thread.sleep(2000);
	  
	  
	  
 }
 
  @BeforeTest
  public void beforeTest() {
	  
	  WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
      driver.manage().window().maximize();
      driver.get(("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx"));  
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
