package workingwithelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkingWithTextBoxAndButton {
	
	ChromeDriver driver ;
	
	@BeforeTest
	
	public void openurl() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/login");
		
	}
	
	@Test
	
	public void loginscreen() {
		
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("tomsmith");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("SuperSecretPassword!");
		WebElement login_button = driver.findElement(By.tagName("button"));
		login_button.click();
		
		WebElement successnotification = driver.findElement(By.id("flash"));
		
		System.out.println(successnotification.getText());
		
		Assert.assertTrue(successnotification.getText().contains("secure area!"));
		
		
		
	}
	
	@AfterTest
	
	public void closescreen() {
		
	  driver.quit();
	}

}
