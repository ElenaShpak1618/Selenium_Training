package pk_Selenium;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Yatra_Mouse_Hover {
  @Test
  public void MousHoverYatra() throws InterruptedException {
  WebDriverManager.chromedriver().setup();
  ChromeDriver driver = new ChromeDriver();
  driver.manage().window().maximize();
  driver.get("https;//www.yatra.com/");
  Thread.sleep(3000);
//How to find element on pop up window with mouse
  WebElement MyAccount = driver.findElement(By.xpath("//a[containce(text(),'My Account')]"));
  
  
  //////////////MOUSE!!!///////////
  //Command action exemple:drug and drop/double click/
  Actions action = new Actions(driver);
  action.moveToElement(MyAccount).perform();
  driver.findElement(By.id("signInBtn")).click();
  Thread.sleep(3000);
  driver.findElement(By.xpath("//p[text()='Welcome to Yarta!")).isDisplayed();
  driver.quit();
  
  
  }
  /*@BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {*/
	  
	  
  }


