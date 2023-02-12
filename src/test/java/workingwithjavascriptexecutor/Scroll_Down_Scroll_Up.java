package workingwithjavascriptexecutor;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class Scroll_Down_Scroll_Up {
	
ChromeDriver driver ;

	
	@BeforeTest
	
	public void openurl() {
		
		ChromeDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.amazon.com/");
	}
	
	@Test
	
	public void scroll_down_up() throws InterruptedException {
		
		JavascriptExecutor js = (JavascriptExecutor) driver ;
		js.executeScript("scrollBy(0,5000)");
		Thread.sleep(3000);
		WebElement amazon_logo = driver.findElement(By.xpath("//div[@class='nav-logo-base nav-sprite']"));
		
		assertTrue(amazon_logo.isDisplayed());
		
		
	}
	
	@AfterTest
	
	public void close_url() {
		
		
		driver.quit();
		
	}
	

}
