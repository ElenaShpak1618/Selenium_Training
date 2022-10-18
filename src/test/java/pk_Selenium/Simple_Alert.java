package pk_Selenium;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

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
	public void alertButton() throws InterruptedException {
	driver.findElement(By.id("alertbtn")).click();
	Thread.sleep(2000);
	String ExpAlertMsg = "Hello , share this practice page and share your knowledge";
	String ActAlertMsg = driver.switchTo().alert().getText();
	Assert.assertEquals(ExpAlertMsg, ActAlertMsg);
    Thread.sleep(2000);
    driver.switchTo().alert().accept();
	
	}
	
	@Test(priority = 2) 
	public void nameAlert() throws InterruptedException {
   
	driver.findElement(By.id("name")).sendKeys("Elena");
	driver.findElement(By.id("confirmbtn")).click();
	Thread.sleep(2000);
    String ExpAlertMsg = "Hello Elena, Are you sure you want to confirm?";
	String ActAlertMsg = driver.switchTo().alert().getText();
	Assert.assertEquals(ExpAlertMsg, ActAlertMsg);
    Thread.sleep(2000);
    driver.switchTo().alert().dismiss();
    
    }
	
	@Test(priority = 3) 
	public void lastAlert() throws InterruptedException {
   
	driver.findElement(By.id("confirmbtn")).click();
	String ExpAlertMsg = "Hello , Are you sure you want to confirm?";
	String ActAlertMsg = driver.switchTo().alert().getText();
	Assert.assertEquals(ExpAlertMsg, ActAlertMsg);
    Thread.sleep(2000);
    driver.switchTo().alert().accept();
    
	}
    
     @AfterTest
    public void closeBrowser() {
		driver.quit();
		
    }
     
   }
	

