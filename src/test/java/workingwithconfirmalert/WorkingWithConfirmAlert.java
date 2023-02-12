package workingwithconfirmalert;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkingWithConfirmAlert {
	
	
ChromeDriver driver ;
	
	
	@BeforeTest
	
	public void OpenUrl() {
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	    driver.navigate().to("http://www.seleniumacademy.com/cookbook/Alerts.html");
	    
	}
	
	@Test
	
	public void testconfirmalert() throws InterruptedException {
		
		WebElement confirmBtn = driver.findElement(By.id("confirm"));
		confirmBtn.click();
		
		Thread.sleep(2000);
		
		Alert alert = driver.switchTo().alert();
		
		alert.accept();
		
		Thread.sleep(2000);
		
		WebElement Message = driver.findElement(By.id("demo"));
		Assert.assertEquals("You Accepted Alert!", Message.getText());
		
	}
	
	@Test
	
	public void testdismissconfirmalert() throws InterruptedException {
		
		WebElement confirmBtn = driver.findElement(By.id("confirm"));
		confirmBtn.click();
		
		Thread.sleep(2000);
		
		Alert alert = driver.switchTo().alert();
		
		alert.dismiss();
		
		Thread.sleep(2000);
		
		WebElement Message = driver.findElement(By.id("demo"));
		
		Assert.assertEquals("You Dismissed Alert!", Message.getText());
		
	}
	
	@AfterTest
	
	public void closeurl() {
		
		driver.quit();
	}

}
