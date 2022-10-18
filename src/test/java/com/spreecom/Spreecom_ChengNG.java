package com.spreecom;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class Spreecom_ChengNG {
	WebDriver driver;
 /* @Test
  public void Login() throws InterruptedException {
	  driver.findElement(By.linkText("Add new address")).click();
	  driver.findElement(By.xpath("//input[@id='address_label']")).sendKeys("Home");
	  driver.findElement(By.xpath("//input[@id='address_firstname']")).sendKeys("Elena1");
	  driver.findElement(By.xpath("//input[@id='address_lastname']")).sendKeys("Shpak1");
	  driver.findElement(By.xpath("//input[@id='address_address1']")).sendKeys("Denver");
	  driver.findElement(By.xpath("//input[@id='address_city']")).sendKeys("San San");
	  driver.findElement(By.xpath("//select[@id='address_state_id']")).sendKeys("Califirnia");
	  driver.findElement(By.xpath("//input[@id='address_zipcode']")).sendKeys("95806");
	  driver.findElement(By.xpath("//input[@id='address_phone']")).sendKeys("12345567890");
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//input[@name='commit']")).click();
	  driver.findElement(By.xpath("//address[@class='mb-0 col-12']")).isDisplayed();
	  String ActValue = driver.findElement(By.xpath("//address[@class='mb-0 col-12']")).getText();
	  
	  String ExpValue = "Home\n"
	  		+ "Elena1 Shpak1\n"
	  		+ "Denver ,\n"
	  		+ "San San, CA 95806,\n"
	  		+ "United States";
	  Assert.assertEquals(ActValue,ExpValue);
}*/
  @Test
  
  public void Change() throws InterruptedException {
	  driver.findElement(By.xpath("//a[@class='ml-1 d-inline-block']//*[name()='svg']")).click();
	  driver.findElement(By.linkText("Add new address")).click();
	  driver.findElement(By.xpath("//input[@id='address_label']")).sendKeys("Home");
	  driver.findElement(By.xpath("//input[@id='address_firstname']")).sendKeys("Elena1");
	  driver.findElement(By.xpath("//input[@id='address_lastname']")).sendKeys("Shpak1");
	  driver.findElement(By.xpath("//input[@id='address_address1']")).sendKeys("LA");
	  driver.findElement(By.xpath("//input[@id='address_city']")).sendKeys("San San");
	  driver.findElement(By.xpath("//select[@id='address_state_id']")).sendKeys("California");
	  driver.findElement(By.xpath("//input[@id='address_zipcode']")).sendKeys("95806");
	  driver.findElement(By.xpath("//input[@id='address_phone']")).sendKeys("12345567890");
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//input[@name='commit']")).click();
	 
	  
  }
  
  
  @BeforeTest
  public void launchBrowser() throws InterruptedException { 
	  WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
      driver.manage().window().maximize();
      driver.get(("https://demo.spreecommerce.org/"));
      driver.findElement(By.xpath("//button[@id='account-button']//*[name()='svg']")).click();
	  driver.findElement(By.linkText("LOGIN")).click();
		Thread.sleep(3000);
	  driver.findElement(By.xpath("//input[@id='spree_user_email']")).sendKeys("Elena@spree.com");
	  driver.findElement(By.id("spree_user_password")).sendKeys("Elena123");
	  driver.findElement(By.xpath("//input[@name='commit']")).click();
		Thread.sleep(3000);
	  
	
      
  }
  
  
 /* @AfterTest
  public void CloseBrowser() throws InterruptedException {
	  driver.findElement(By.xpath("//button[@id='account-button']//*[name()='svg']")).click();
	  driver.findElement(By.linkText("LOGOUT")).click();
	  Thread.sleep(3000); 
	 // driver.quit();
  }*/
}