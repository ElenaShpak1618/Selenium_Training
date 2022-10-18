package pk_Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class Navigate_All_Spreecom {
	

	@Test
	public void NavigateToAllLinks() throws InterruptedException {
		
		String[] textArray = new String[] { "ALL", "SKIRT", "DRESSES", "SHIRTS AND BLOUSES", "SWEATERS", 
		"TOPS AND T-SHIRTS", "JACKETS AND COATS" };

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://demo.spreecommerce.org/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//button[@id='account-button']//*[name()='svg']")).click();
		driver.findElement(By.linkText("LOGIN")).click();
		Thread.sleep(3000); 
	    driver.findElement(By.xpath("//input[@id='spree_user_email']")).sendKeys("Elena@spree.com");
		driver.findElement(By.id("spree_user_password")).sendKeys("Elena123");
		driver.findElement(By.xpath("//input[@name='commit']")).click();
		Thread.sleep(3000);

		List<WebElement> linksize = driver.findElements(By.tagName("a"));

		int linksCount = linksize.size();
		System.out.println("Total no of links Available:" + linksCount);
		String[] links = new String[linksCount];
		System.out.println("List of links Available:");
		// print all the links from webpage
		for (int i = 0; i < linksCount; i++) {
			links[i] = linksize.get(i).getAttribute("href");
			//System.out.println(linksize.get(i).getAttribute("href"));
			System.out.println("Text is : " + linksize.get(i).getText());
			System.out.println("links[" + i + "]" + links[i]);
			Assert.assertNotNull(links[i]);

			for (int j = 0; j < textArray.length; j++) {
				if (linksize.get(i).getText().equals(textArray[j])) {
					System.out.println(linksize.get(i).getText() + "Matchs with " + textArray[j]);
					break;
				}
			}
		}
		// navigate to each Link on the webpage
		for (int i = 0; i < linksCount; i++) {
			driver.navigate().to(links[i]);
			System.out.println(driver.getTitle());
			System.out.println(driver.getCurrentUrl());
			//driver.navigate().back();
			
		}
		driver.close();
	}


}
