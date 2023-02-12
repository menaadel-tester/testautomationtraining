package vostiatask;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Quality_Part_AjaxData {
	

	ChromeDriver driver ;
	
	@BeforeTest
	
	public void open_url() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://www.uitestingplayground.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	@Test
	
	public void text_display() {
		
		WebElement ajax_data = driver.findElement(By.linkText("AJAX Data"));
		ajax_data.click();
		
		WebElement trigger_btn = driver.findElement(By.id("ajaxButton"));
		trigger_btn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		WebElement message = driver.findElement(By.xpath("//p[text()='Data loaded with AJAX get request.']"));
		
		boolean Message = message.isDisplayed();
		assertEquals(Message, true);
		
	}
	
	@Test(dependsOnMethods= {"text_display"})
	
	public void shadow_dom() throws InterruptedException {
		
		driver.navigate().back();
		
		WebElement shadow_dom = driver.findElement(By.xpath("//a[text()='Shadow DOM']"));
		shadow_dom.click();
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement setting_btn = driver.findElement(By.cssSelector("#buttonGenerate"));
		setting_btn.click();
		Thread.sleep(3000);
		WebElement copy_btn = driver.findElement(By.cssSelector("#buttonCopy"));
		copy_btn.click();
	}
	
	
	@Test
	
	public void dynamic_id() {
		
		
	}
	
	
	
	
	
	
	
	@AfterTest
	
	public void close_url() {
		
		driver.quit();
	}
	

}
