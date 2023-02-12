package workingwithdropdownlist;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkingWithDropDownList {
	
	
	ChromeDriver driver ;
	
	@BeforeTest
	
	public void openurl() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://the-internet.herokuapp.com/dropdown");
			
	}
	
	@Test
	
	public void testdropdownlist() throws Exception {
		
		WebElement options = driver.findElement(By.id("dropdown"));
		
		Select select_options = new Select(options);
	    select_options.selectByValue("2");
	    Thread.sleep(2000);
		
	}
	
	
	@AfterTest
	
	public void closeurl() {
		
		driver.quit();
		
		
	}

}
