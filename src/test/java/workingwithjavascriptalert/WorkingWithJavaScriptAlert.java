package workingwithjavascriptalert;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkingWithJavaScriptAlert {
	
	
ChromeDriver driver ;
	
	
	@BeforeTest
	
	public void OpenUrl() {
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	    driver.navigate().to("http://www.seleniumacademy.com/cookbook/Alerts.html");
	    
	}
	
	@Test
	
	public void testAlert() throws InterruptedException {
		
		WebElement alertbtn = driver.findElement(By.id("simple"));
		alertbtn.click();
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		String alert_text = alert.getText();
		alert.accept();
		Assert.assertEquals("Hello! I am an alert box!", alert_text);
		
		
		
	}
	
	@AfterTest
	
	public void closeurl() {
		
		driver.quit();
		
		
	}
	
	
	

}
