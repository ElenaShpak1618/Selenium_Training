package pk_Selenium;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;

public class Sportwear_Lesson {
	WebDriver driver;
	
  @Test
  public void Verify() throws InterruptedException {
	    driver.switchTo().frame("login_page");
		driver.findElement(By.xpath("//input[@name='fldLoginUserId']")).sendKeys("1000");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//a[normalize-space()='CONTINUE']")).click();

		String ExpText = driver.findElement(By.xpath(("//span[normalize-space()='Password/ IPIN']"))).getText();

		String ActText = "Password/ IPIN";
		// String = driver.getCurrentUrl();
		Assert.assertEquals(ActText, ExpText);
		Thread.sleep(2000);
		//It will take you out of the frame
		driver.switchTo().defaultContent();

  
   }
  @BeforeTest

	  public void lunchBrowser() {
		ChromeOptions option = new ChromeOptions();
		option.setHeadless(true);
		driver = new ChromeDriver(option);
			driver.get("");
			driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
	
	//driver.quit();
  }

}
