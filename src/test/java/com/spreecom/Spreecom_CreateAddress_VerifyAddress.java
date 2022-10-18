package com.spreecom;
import org.testng.annotations.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;



public class Spreecom_CreateAddress_VerifyAddress extends TestData {
	
Spreecom_Login spreecom_login = new Spreecom_Login();
	
  @Test(priority = 2)
  public void CreateAddress() throws InterruptedException {
	  WebDriver driver;
	  driver = spreecom_login.driver;
	  
	  driver.findElement(By.linkText("Add new address")).click();
	  Thread.sleep(2000);
	  //Verify title
		String ExpTitle ="Spree Demo Site";
		String ActTitle = driver.getTitle();
		Assert.assertEquals(ExpTitle,ActTitle);
		
	  //Verify URL
		String ExpURL = "https://demo.spreecommerce.org/addresses/new";
		String ActURL = driver.getCurrentUrl();
		Assert.assertEquals(ExpURL,ActURL);
		Thread.sleep(2000);
	  driver.findElement(By.xpath("//input[@id='address_label']")).sendKeys("Home");
	  driver.findElement(By.xpath("//input[@id='address_firstname']")).sendKeys("Elena1");
	  driver.findElement(By.xpath("//input[@id='address_lastname']")).sendKeys("Shpak1");
	  driver.findElement(By.xpath("//input[@id='address_address1']")).sendKeys("Denver");
	  driver.findElement(By.xpath("//input[@id='address_city']")).sendKeys("San San");
	  driver.findElement(By.xpath("//select[@id='address_state_id']")).sendKeys("Califirnia");
	  driver.findElement(By.xpath("//input[@id='address_zipcode']")).sendKeys("95806");
	  driver.findElement(By.xpath("//input[@id='address_phone']")).sendKeys("12345567890");
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//input[@name='commit']")).click();
	  driver.findElement(By.xpath("//address[@class='mb-0 col-12']")).isDisplayed();
	  Assert.assertEquals(driver.findElement(By.xpath("//address[@class='mb-0 col-12']")).getText(), "Home\n"
		  		+ "Elena1 Shpak1\n"
		  		+ "Denver ,\n"
		  		+ "San San, CA 95806,\n"
		  		+ "United States");
	  Thread.sleep(2000);
	
	  
	  }
  
  
  @Test(priority = 3)
  
  public void UpdateAddress() throws InterruptedException {
	  spreecom_login.driver.findElement(By.xpath("//a[@class='ml-1 d-inline-block']//*[name()='svg']")).click();
	  spreecom_login.driver.findElement(By.xpath("//input[@id='address_label']")).clear();
	  spreecom_login.driver.findElement(By.xpath("//input[@id='address_label']")).sendKeys("Home");
	  spreecom_login.driver.findElement(By.xpath("//input[@id='address_firstname']")).clear();
	  spreecom_login.driver.findElement(By.xpath("//input[@id='address_firstname']")).sendKeys("Elena2");
	  spreecom_login.driver.findElement(By.xpath("//input[@id='address_lastname']")).clear();
	  spreecom_login.driver.findElement(By.xpath("//input[@id='address_lastname']")).sendKeys("Shpak1");
	  Thread.sleep(2000);
	  spreecom_login.driver.findElement(By.xpath("//input[@id='address_address1']")).sendKeys("San Antonio");
	  spreecom_login.driver.findElement(By.xpath("//input[@id='address_city']")).clear();
	  spreecom_login.driver.findElement(By.xpath("//input[@id='address_city']")).sendKeys("San Antonio");
	  spreecom_login.driver.findElement(By.xpath("//select[@id='address_state_id']")).sendKeys("Texas");
	  spreecom_login.driver.findElement(By.xpath("//input[@id='address_zipcode']")).clear();
	  spreecom_login.driver.findElement(By.xpath("//input[@id='address_zipcode']")).sendKeys("78015");
	  spreecom_login.driver.findElement(By.xpath("//input[@id='address_phone']")).clear();
	  spreecom_login.driver.findElement(By.xpath("//input[@id='address_phone']")).sendKeys("0987654321");
	  Thread.sleep(3000);
	  spreecom_login.driver.findElement(By.xpath("//input[@name='commit']")).click();
	  Assert.assertEquals(spreecom_login.driver.findElement(By.xpath("//span[normalize-space()='Updated successfully']")).getText(),"Updated successfully");
	  
  }
	  
	 
	  
   @Test(priority = 4)
	  
   public void DeliteAdress() throws InterruptedException {
	   spreecom_login.driver.findElement(By.xpath("//a[@aria-label='Remove Address']//*[name()='svg']")).click();
	   spreecom_login.driver.findElement(By.xpath("//a[@id='delete-address-popup-confirm']")).click();
	   spreecom_login.driver.findElement(By.xpath("//span[normalize-space()='Address has been successfully removed.']")).getText();
	   Thread.sleep(2000);
       Assert.assertEquals(spreecom_login.driver.findElement(By.xpath("//span[normalize-space()='Address has been successfully removed.']")).getText(),"Address has been successfully removed.");
   } 
   
  
	   
	@Test(priority = 5)
	
	public void MousNav() {
		

		  WebElement MyAccount = spreecom_login.driver.findElement(By.xpath("//a[@class='nav-link main-nav-bar-item main-nav-bar-category-button dropdown-toggle'][normalize-space()='Sportswear']"));
		  Actions action = new Actions(spreecom_login.driver);
		  action.moveToElement(MyAccount).perform();
		 // spreecom_login.driver.findElement("signInBtn");
		 // Thread.sleep(3000);
		 // spreecom_login.findElement(By.xpath("//p[text()='Welcome to Yarta!")).isDisplayed();
		
	}
	  
		  
		  
  @Test(priority = 1, dataProvider = "Create_Adress")
   public void launchBrowser (String name,String firstName, String lastName, 
   String address, String city, String state, int zipCode, String phone) throws InterruptedException { 
	  
	  
 //Dimension a = new Dimension(name, firstName, lastName, address, city, state, zipCode, phone);
	  
	  spreecom_login.launchBrowser();
	  spreecom_login.Login();
  }
	

  
   @AfterTest
   public void CloseBrowser() throws InterruptedException {
	  spreecom_login.Logout();
	  //spreecom_login.CloseBrowser();
	 
	 
     
  }
 
}
 
	 
  


