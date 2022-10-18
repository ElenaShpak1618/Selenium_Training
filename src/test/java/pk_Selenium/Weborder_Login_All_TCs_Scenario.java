package pk_Selenium;

import org.testng.annotations.Test;

import com.spreecom.TestData;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Weborder_Login_All_TCs_Scenario extends TestData{
 
	  ChromeDriver driver;

		@Test(priority = 1, dataProvider = "Weborder_Login_Scenario")
		public void ValidLogin(String uname, String password, String ExpResult) {
			// for login
			driver.findElement(By.id("ctl00_MainContent_username")).clear();
			driver.findElement(By.id("ctl00_MainContent_username")).sendKeys(uname);
			driver.findElement(By.id("ctl00_MainContent_password")).clear();
			driver.findElement(By.id("ctl00_MainContent_password")).sendKeys(password);
			driver.findElement(By.id("ctl00_MainContent_login_button")).click();
			if (ExpResult.equalsIgnoreCase("List of All Orders")) {
				String ActResult = driver.findElement(By.xpath("//h2[normalize-space()='List of All Orders']")).getText();
				Assert.assertEquals(ActResult, ExpResult);
				driver.findElement(By.linkText("Logout")).click();
			} else 
			{
				String ActResult = driver.findElement(By.id("ctl00_MainContent_status")).getText();
				Assert.assertEquals(ActResult, ExpResult);
			}

		}
		
		/*@Test(priority = 2, dataProvider = "Weborder_Create_Order")
		public void ValidCreate(int quan, int price, ) {
			// for create Order
			
			driver.findElement(By.linkText("Order")).click();
			driver.findElement(By.xpath("//option[@value='MyMoney']")).click();
			driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys("500");
			driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtUnitPrice")).sendKeys("10")
			
		
			}*/
  
 
	  @BeforeTest
		public void LaunchBrowser() {
			// to launch browser
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }
  }


