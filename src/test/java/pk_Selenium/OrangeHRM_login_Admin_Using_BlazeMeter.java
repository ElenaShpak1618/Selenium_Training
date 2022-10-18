package pk_Selenium;

import static org.testng.Assert.fail;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM_login_Admin_Using_BlazeMeter {
	
	
	public class OrangHrmLogin {
		  private WebDriver driver;
		  private String baseUrl;
		  private boolean acceptNextAlert = true;
		  private StringBuffer verificationErrors = new StringBuffer();

		  @BeforeClass(alwaysRun = true)
		  public void setUp() throws Exception {
			WebDriverManager.chromedriver().setup();
		    driver = new ChromeDriver();
		    baseUrl = "https://www.blazedemo.com/";
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  }

		  @Test
		  public void testOrangHrmLogin() throws Exception {
		    // Label: Test
		    // ERROR: Caught exception [ERROR: Unsupported command [resizeWindow | 1536,475 | ]]
		    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		    driver.findElement(By.name("username")).click();
		    driver.findElement(By.name("username")).clear();
		    driver.findElement(By.name("username")).sendKeys("Admin");
		    driver.findElement(By.name("password")).click();
		    driver.findElement(By.name("password")).clear();
		    driver.findElement(By.name("password")).sendKeys("admin123");
		    driver.findElement(By.cssSelector("button.oxd-button.oxd-button--medium.oxd-button--main.orangehrm-login-button")).click();
		    driver.findElement(By.linkText("Admin")).click();
		    driver.findElement(By.cssSelector("div.orangehrm-header-container > button.oxd-button.oxd-button--medium.oxd-button--secondary")).click();
		  }

		  @AfterClass(alwaysRun = true)
		  public void tearDown() throws Exception {
		    driver.quit();
//		    String verificationErrorString = verificationErrors.toString();
//		    if (!"".equals(verificationErrorString)) {
//		      fail(verificationErrorString);
//		    }
		  }
		  
	}
}

//		  private boolean isElementPresent(By by) {
//		    try {
//		      driver.findElement(by);
//		      return true;
//		    } catch (NoSuchElementException e) {
//		      return false;
//		    }
//		    
//		  }
//		  
//	}}
		  
//
//		  private boolean isAlertPresent() {
//		    try {
//		      driver.switchTo().alert();
//		      return true;
//		    } catch (NoAlertPresentException e) {
//		      return false;
//		    }
//		  }
//
//		  private String closeAlertAndGetItsText() {
//		    try {
//		      Alert alert = driver.switchTo().alert();
//		      String alertText = alert.getText();
//		      if (acceptNextAlert) {
//		        alert.accept();
//		      } else {
//		        alert.dismiss();
//		      }
//		      return alertText;
//		    } finally {
//		      acceptNextAlert = true;
//		    }
//		  }
//		}
//
//
//}

