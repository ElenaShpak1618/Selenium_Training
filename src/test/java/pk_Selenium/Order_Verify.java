package pk_Selenium;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Order_Verify {
	
	 ChromeDriver driver;
	 @Test (priority = 1)
	 public void ValidLogin() {
		// for login
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
		driver.findElement(By.id("ctl00_MainContent_login_button")).click();
		driver.findElement(By.linkText("View all orders")).isDisplayed();
		
	}

	  @Test (priority = 2)
	  public void CreateOrder() throws InterruptedException  {
		driver.findElement(By.linkText("Order")).click();
		Select selectProduct = new Select(driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct")));
		selectProduct.selectByVisibleText("ScreenSaver");
		


	
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys("8");
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtUnitPrice")).sendKeys("100");
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtDiscount")).sendKeys("20");
		driver.findElement(By.xpath("//input[@class='btn_dark']")).click();
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).sendKeys("Nick");
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2")).sendKeys("Add line1");
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3")).sendKeys("City");
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4")).sendKeys("State");
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).sendKeys("95835");
		driver.findElement(By.xpath("//input[@value='MasterCard']")).click();
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys("12345678904");
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1")).sendKeys("11/24");
		driver.findElement(By.linkText("Process")).click();
		
		
		String ActOutput = driver.findElement(By.tagName("strong")).getText();
		String ExpOutput = "New order has been successfully added.";
		Assert.assertEquals(ExpOutput, ActOutput);
		Thread.sleep(2000);
	}
		
		@Test (priority = 3)
		public void DeleteOrder() throws InterruptedException {
			driver.findElement(By.linkText("View all orders")).click();
			driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl02_OrderSelector")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("ctl00_MainContent_btnDelete")).click();
			
			boolean page_source = driver.getPageSource().contains("Nick");
			Assert.assertFalse(page_source);
			
	
		//String ActOutput = driver.findElement(By.tagName("")).getText();
		//String ExpOutput = "";
		//Assert.assertEquals(ExpOutput, ActOutput);
		//Thread.sleep(2000);
	}
		
		 
			
	    @BeforeTest
	    public void LaunchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");

}
	  /*@AfterTest
       public void afterTest() {
		// to close the browser
	  	driver.quit();
*/ 
	}