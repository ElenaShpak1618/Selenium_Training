package pk_Selenium;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Handle_All_Allert_Example {
	WebDriver driver;
	
  @Test(priority = 1)
  public void CLickOnJSAlert() throws InterruptedException {
	  
	    
	    driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
		String ExpAlertMsg = "I am a JS Alert";
		String ActAlertMsg = driver.switchTo().alert().getText();
		Assert.assertEquals(ExpAlertMsg, ActAlertMsg);
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath("//p[@id='result']")).getText(),
				"You successfully clicked an alert");
		
		
  }
  
   @Test(priority = 2)
   public void CLickForJSConfirm() throws InterruptedException {
	  
	   driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
	   driver.switchTo().alert().dismiss();
	   Assert.assertEquals(driver.findElement(By.xpath("//p[@id='result']")).getText(),
				"You clicked: Cancel");
	   
	   Thread.sleep(2000);
		
	  
   } 
   
   @Test(priority = 3)
   public void CLickForJSPromt()  {
	   
	   driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
	   driver.switchTo().alert().sendKeys("Selenium");
	   driver.switchTo().alert().accept();
	   Assert.assertEquals(driver.findElement(By.xpath("//p[@id='result']")).getText(),
				"You entered: Selenium");
	   
	   
		
  }
	  
	  
	   
	  
   @BeforeTest
   public void beforeTest() {
	   
	  WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
      driver.manage().window().maximize();
      driver.get(("https://the-internet.herokuapp.com/javascript_alerts"));  
	  
  }

   @AfterTest
   public void afterTest() {
	  driver.quit();
	  
  }

}
