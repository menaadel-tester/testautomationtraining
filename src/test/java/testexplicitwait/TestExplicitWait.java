package testexplicitwait;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class TestExplicitWait {
	
ChromeDriver driver ;

	
	@BeforeTest
	
	public void openurl() {
		
		ChromeDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.google.com/");
	}
	
	
	
	
	@Test
	public void testexplicitwait() {
		
	WebElement query_text = driver.findElement(By.name("q"));
	
	query_text.sendKeys("selenium WebDriver");
	query_text.submit();
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	
	wait.until(ExpectedConditions.titleContains("selenium"));
	
	assertTrue(driver.getTitle().toLowerCase().contains("selenium"));

	
	}
	
	
	@AfterTest
	
	public void closeurl() {
		
		driver.quit();
		
		
		
	}
	
	

}
