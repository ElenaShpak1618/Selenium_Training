package com.spreecom;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;



public class Spreecom_Login_Navigation_Command {
	WebDriver driver;
  @Test(priority = 1)
  public void Login() throws InterruptedException {
	    driver.findElement(By.xpath("//button[@id='account-button']//*[name()='svg']")).click();
	   
		driver.findElement(By.linkText("LOGIN")).click();
		Thread.sleep(2000);
		
		
		 //Navigation//Go back to home page
		   driver.navigate().back();
		   String PrepageTitle = driver.getTitle();
		   String HomePageTitle = "Homepage (English) - Spree Demo Site";
		   Assert.assertEquals(PrepageTitle,HomePageTitle );
		  //Navigate back to Forward page
		   driver.navigate().forward();
		   
		   String LoginActPageTitle = driver.getTitle();
		   String LoginExpPageIitle = "Login - Spree Demo Site";
		   Assert.assertEquals(LoginActPageTitle,LoginExpPageIitle );
		   
		   
		driver.findElement(By.xpath("//input[@id='spree_user_email']")).sendKeys("Elena@spree.com");
		driver.findElement(By.id("spree_user_password")).sendKeys("Elena123");
		driver.findElement(By.xpath("//input[@name='commit']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='alert alert-success mb-0']")).isDisplayed();
		driver.findElement(By.xpath("//h3[@class='text-uppercase spree-mb-large spree-mt-large spree-header']")).isDisplayed();
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath("//h3[@class='text-uppercase spree-mb-large spree-mt-large spree-header']")).getText(), "MY ACCOUNT");;
	    
	   
	   
	    
  }
  
  
  @Test(priority = 2)
  public void Logout() throws InterruptedException {
	   driver.findElement(By.xpath("//button[@id='account-button']//*[name()='svg']")).click();
	   driver.findElement(By.linkText("LOGOUT")).click();
	   driver.findElement(By.xpath("//h3[normalize-space()='Log in to continue']")).isDisplayed();
	   Thread.sleep(2000);
	   Assert.assertEquals(driver.findElement(By.xpath("//h3[normalize-space()='Log in to continue']")).getText(), "LOG IN TO CONTINUE");
	   Thread.sleep(2000);
	   driver.findElement(By.xpath("//span[normalize-space()='Signed out successfully.']")).isDisplayed();
	   Assert.assertEquals(driver.findElement(By.xpath("//span[normalize-space()='Signed out successfully.']")).getText(), "Signed out successfully.");
	 
	 
	   
	   
 }
  
  
  @BeforeTest
  public void launchBrowser() { 
	  WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
      driver.navigate().to("https://demo.spreecommerce.org/");
      driver.manage().window().maximize();
      driver.get(("https://demo.spreecommerce.org/"));
      
  }
  
  
  @AfterTest
  public void CloseBrowser() {
	 driver.quit();
  }

}
