package doubleclick;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DoubleClickWithActions {
	
ChromeDriver driver ;
	
	
	@BeforeTest
	
	public void OpenUrl() {
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	    driver.navigate().to("http://www.seleniumacademy.com/cookbook/DoubleClickDemo.html");
	}
	
	@Test
	
	public void testdoubleclick() throws InterruptedException {
		
		WebElement message = driver.findElement(By.id("message"));
		System.out.println(message.getCssValue("background-color")); // to print color before the double click 
		Actions builder = new Actions(driver);
		builder.doubleClick(message).perform();
		System.out.println(message.getCssValue("background-color")); // to print color after the double click 
		Thread.sleep(3000);
		Assert.assertEquals("rgba(255, 255, 0, 1)", message.getCssValue("background-color"));
	}
	
	@AfterTest
	
	public void closeurl() {
		
		driver.quit();
		
		
	}
	

}
