package pk_Selenium;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class HDFC_Netbanking_Handle_Alert_Window {
	
	
	    WebDriver driver;


	//ChromeDriver driver;
		@Test
		public void Blank_CustomerID() throws InterruptedException {
			driver.switchTo().frame("login_page");
			driver.findElement(By.xpath("//a[contains(text(),'CONTINUE')]")).click();
			
			String ExpAlertMsg="Customer ID  cannot be left blank.";
			String ActAlertMsg=driver.switchTo().alert().getText();
			Assert.assertEquals(ExpAlertMsg, ActAlertMsg);
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			Thread.sleep(3000);
  }
		
  @BeforeTest
  public void beforeTest() {// to launch browser
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");
	  
  }
  
  @AfterTest
	public void CloseBrowser() {
		driver.quit();

    }
}
