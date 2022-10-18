package pk_Selenium;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Wenorder_Createorder_Verifyorded {
	
	ChromeDriver driver;
	@Test //(priority = 1)
	public void ValidLogin() {
		// for login
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
		driver.findElement(By.id("ctl00_MainContent_login_button")).click();
		driver.findElement(By.linkText("View all orders")).isDisplayed();
		
		
	}
	@DataProvider(name = "Customer_Name")
	public Object[][] getName() {
		// Multidimensional Object
		// 3X3 or 4X3 or 4X5
		return new Object[][] {

				{"Abhi"},
				{"Farid"},
				{"Vandana"},
				{"Kawal"},
				{"Elena"}
				};
	}

	@Test//(priority = 2)
	public void CreateOrder() throws InterruptedException {
		// to place the web order
		driver.findElement(By.linkText("Order")).click();
		// to select value from the dropdown
		//Select selectProduct = new Select(driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct")));
		//selectProduct.selectByVisibleText("ScreenSaver");
		Thread.sleep(3000);
		
		
		//selectProduct.value/text/index(from [0])
	
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys("5");
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtUnitPrice")).sendKeys("100");
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtDiscount")).sendKeys("10");
		driver.findElement(By.xpath("//input[@class='btn_dark']")).click();
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).sendKeys("Dixit");
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2")).sendKeys("Add line1");
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3")).sendKeys("CityName");
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4")).sendKeys("StateName");
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).sendKeys("098765");
		driver.findElement(By.xpath("//input[@value='MasterCard']")).click();
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys("1234123412341234");
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1")).sendKeys("09/25");
		driver.findElement(By.linkText("Process")).click();
		Thread.sleep(3000);
		// Verify that order is placed/confirmed
		String ActOutput = driver.findElement(By.tagName("strong")).getText();
		String ExpOutput = "New order has been successfully added.";
		Assert.assertEquals(ExpOutput, ActOutput);

		// Verify the current url
		String ActUrl = driver.getCurrentUrl();
		String ExpUrl = "http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Process.aspx";
		Assert.assertEquals(ExpUrl, ActUrl);

		// Verify the title of the page
		String ActTitle = driver.getTitle();
		String ExpTitle = "Web Orders";
		Assert.assertEquals(ExpTitle, ActTitle);
		
		// Go to View All Order and Verify the Added user
		driver.findElement(By.linkText("View all orders")).click();
		String ActOutputname = driver.findElement(By.xpath("//td[text()='Dixit']")).getText();
		String ExpOutputname = "Dixit";
		Assert.assertEquals(ActOutputname, ExpOutputname);
	}
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
		// to close the browser
		driver.quit();

	}
}	
	