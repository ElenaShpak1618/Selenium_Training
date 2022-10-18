package com.spreecom;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;



public class Web_Order_CreateOrder extends TestData {
	
	  ChromeDriver driver;
	  
	  @Test(priority = 1)
		public void createWebOrder() throws InterruptedException { 	  
		
	   driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
	   driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
	   driver.findElement(By.id("ctl00_MainContent_login_button")).click();
	   Thread.sleep(2000);
	 
 	  // driver.findElement(By.linkText("Order")).click();
	      Thread.sleep(2000);
					
	  
		
  }
		    
	 /* @Test(priority = 2)//, dataProvider = "Input_Data")
	  public void createOrder()/*(String qua, String price, String name, String street, String city, String state, 
			String zip, String card, String date) throws InterruptedException*/ {

      
    	 /*   Select selectProduct = new Select(driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct")));
    			  selectProduct.selectByVisibleText("ScreenSaver");
    			//  Thread.sleep(2000);
    	  
    	 // driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).clear();	  
		  driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys();//qua);
		  driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtUnitPrice")).clear();
		  driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtUnitPrice")).sendKeys();//price);
		  driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).clear();
		  driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).sendKeys();//name);
		  driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2")).clear();
		  driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2")).sendKeys();//street);
		  driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3")).clear();
		  driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3")).sendKeys();//city);
		  driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4")).clear();
		  driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4")).sendKeys();//state);
		  driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).clear();
		  driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).sendKeys();//zip);
		  
		  driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).clear(); 
		  driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys();//card);
		  driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1")).clear();
		  driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1")).sendKeys();//date);
		  driver.findElement(By.linkText("Process")).click();
		   */
		   
	}   
 
  @BeforeTest
  
	  public void LaunchBrowser() {
			
		   WebDriverManager.chromedriver().setup();
		   driver = new ChromeDriver();
		   driver.manage().window().maximize();
		   driver.get("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");
		   
  
			
	}

 // @AfterTest
 // public void afterTest() {
	 // driver.quit();
  //}

}
