package pk_Selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class Blaze_Demo {

	@Test
	public void selectFlight() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://blazedemo.com/");
		driver.manage().window().maximize();
		
		
		Select From = new Select(driver.findElement(By.xpath("//select[@name='fromPort']")));
		From.deselectByVisibleText("Boston");
		
		Select to = new Select(driver.findElement(By.xpath("//select[@name='toPort']")));
		to.selectByVisibleText("New York");
		Thread.sleep(2000);
		
		
		driver.findElement(By.xpath("//input[@type='submit'")).click();
		String actual = driver.findElement(By.xpath("//h3[text()='Flights from Boston to New York:']")).getText();
		System.out.println(actual);
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//h1[text()='Thank you for your purchase today!']")).getText(), 
				"Thank you for your purchase today!");
		
		
		
		
		
		
		
		
		
		

		
	}

}
