package testfluentwait;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class Testfluentwait {
	
	
ChromeDriver driver ;
	
	@BeforeTest
	
	public void openurl() {
		
		ChromeDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://www.seleniumacademy.com/cookbook/AjaxDemo.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	
	@Test
	
	public void testexplicitwait() {
		
		WebElement link_page4 = driver.findElement(By.linkText("Page 4"));
		
		link_page4.click();
		
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
		        .withTimeout(Duration.ofSeconds(20))
		        .pollingEvery(Duration.ofSeconds(2))
		        .ignoring(NoSuchElementException.class);
		
		WebElement message = fluentWait.until(new Function <WebDriver, WebElement>()
				
				{
			
			     public WebElement apply(WebDriver d) {
			    	 
			    	 
			    	 return d.findElement(By.id("page4"));
			    	 
			     }
			
				});
		
		
		assertTrue(message.getText().contains("Nunc nibh tortor"));
				
				
		
	}
	
	@AfterTest
	
	public void closeurl() {
		
		driver.quit();
	}

}
