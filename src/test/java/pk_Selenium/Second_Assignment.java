package pk_Selenium;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Second_Assignment {
	
	public class Simple_Alert {
		
		ChromeDriver driver;
		
		@SuppressWarnings("deprecation")
		@BeforeTest
		public void launchBrowser() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.navigate().to("https://courses.letskodeit.com/practice");
		driver.manage().window().maximize();
		driver.get("https://courses.letskodeit.com/practice");
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		
		}
		
		@Test(priority = 1)
		public void hideButton() throws InterruptedException {
		driver.findElement(By.id("hide-textbox")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("show-textbox")).click();
		Thread.sleep(2000);
		
	 // Assert.assertEquals(driver.findElement(By.id("displayed-text")).getText(),"Hide/Show Example");
		  
		driver.quit();
		
		}


	}
}
