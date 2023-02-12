package testimplicitwait;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class TestImplicitWait {
	
	ChromeDriver driver ;
	
	@BeforeTest
	
	public void openurl() {
		
		ChromeDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://www.seleniumacademy.com/cookbook/AjaxDemo.html");
	}
	
	@Test
	
	public void testimplicitwait() {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		
	 WebElement link = driver.findElement(By.linkText("Page 4"));
	 link.click();
	 
	 WebElement Message = driver.findElement(By.id("page4"));
	 
	 assertTrue(Message.getText().contains("pulvinar rhoncus quis"));
		
	}
	
	@AfterTest
	
	public void closeurl() {
		
		driver.close();
		
	}

}
