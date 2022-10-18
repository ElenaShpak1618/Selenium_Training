package com.spreecom;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class HDFC_Netbanking {
	WebDriver driver;
	
	
  @Test
  public void Verify_Password_field() throws InterruptedException {
	  driver.findElement(By.xpath("//input[@name='fldLoginUserId']")).click();
	  driver.findElement(By.xpath("//input[@name='fldLoginUserId']")).sendKeys("1000");
	  driver.findElement(By.linkText("CONTINUE")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//span[normalize-space()='Password/ IPIN']")).isDisplayed();
	  Thread.sleep(2000);
	  
	  
	  
	  
	  
  }
  
  
  
  
  
  @BeforeTest
  public void beforeTest() {
		  WebDriverManager.chromedriver().setup();
	      ChromeDriver driver = new ChromeDriver();
	      driver.manage().window().maximize();
	      driver.get(("https://netbanking.hdfcbank.com/netbanking/"));
	      
	  }
	  
  

  @AfterTest
  public void afterTest() {
	driver.quit(); 
	  
  }

}
