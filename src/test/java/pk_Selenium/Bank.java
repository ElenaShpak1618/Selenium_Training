package pk_Selenium;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Bank {
	WebDriver driver;
	
	
  @Test
  public void f() throws InterruptedException {
	  //Go inside of the frame
	  driver.switchTo().frame("login_page");
    //  driver.findElement(By.xpath("//input[@name='fldLoginUserId']")).click();
	  driver.findElement(By.xpath("//input[@name='fldLoginUserId']")).sendKeys("1000");
	  driver.findElement(By.linkText("CONTINUE")).click();
	  Thread.sleep(2000);
	//  driver.findElement(By.xpath("//span[normalize-space()='Password/ IPIN']")).click();
	  String ExpText = driver.findElement(By.xpath("//span[normalize-space()='Password/ IPIN']")).getText();
	  
	  String ActText = "Password/ IPIN";
	  Assert.assertEquals(ActText, ExpText);	  
	  Thread.sleep(2000);
	  //It will take you out of the frame
	  driver.switchTo().defaultContent();
	  
	}
  
  
  
  
  
  @BeforeTest
  public void beforeTest() {
		  WebDriverManager.chromedriver().setup();
	      driver = new ChromeDriver();
	      driver.get(("https://netbanking.hdfcbank.com/netbanking/"));
	      driver.manage().window().maximize();
	      
	  }
	  
  

  @AfterTest
  public void afterTest() {
	driver.quit(); 
	  
  }

}
