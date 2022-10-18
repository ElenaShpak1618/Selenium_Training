package pk_Selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class EnterText_PressButton_Exemple {
	ChromeDriver driver;
	
	@Test
	
	public void PressEnterKey() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.co.in/");
		driver.findElement(By.name("q")).sendKeys("Selenium",Keys.ENTER);
		String ReturnText=driver.findElement(By.xpath("//span[text()='Selenium']")).getText();
		Assert.assertEquals("Selenium", ReturnText);
		driver.quit();
		
		
		
		}

}
