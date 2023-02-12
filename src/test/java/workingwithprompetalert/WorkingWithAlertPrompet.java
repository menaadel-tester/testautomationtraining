package workingwithprompetalert;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class WorkingWithAlertPrompet {
	
	ChromeDriver driver ;
	
	
	@BeforeTest
	
	public void OpenUrl() {
		
	 ChromeDriverManager.chromedriver().setup();
	 driver = new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.navigate().to("http://www.seleniumacademy.com/cookbook/Alerts.html");
			
	}
	
	@Test
	
	public void testprompetbox() throws InterruptedException {
		
		WebElement promptBtn = driver.findElement(By.id("prompt"));
		promptBtn.click();
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("MenaAdel");
		Thread.sleep(3000);
		alert.accept();
		Thread.sleep(2000);
		WebElement Message = driver.findElement(By.id("prompt_demo"));
		Assert.assertEquals("Hello MenaAdel! How are you today?", Message.getText());
		
	}
	
	@AfterTest
	
	public void closeurl() {
		
		driver.quit();
		
		
	}

}
