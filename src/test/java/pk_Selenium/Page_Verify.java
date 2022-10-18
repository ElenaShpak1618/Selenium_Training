package pk_Selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Page_Verify {
	
	ChromeDriver driver;
	
	@BeforeTest
	public void Login_HRM() throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	
	driver.navigate().to("https://demo.spreecommerce.org/");
	driver.manage().window().maximize();
	
	driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
    driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
	driver.findElement(By.id("ctl00_MainContent_login_button")).click();
	   Thread.sleep(2000);
	   
	   
	
	   

     }
	
}
