package assertion;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assertion {
	
	
ChromeDriver driver ;
	
	@BeforeTest
	
	public void openurl() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.google.com/");
			
	}
	
	@Test
	
	public void testassertion() {
		
	  String title = driver.getTitle();
	  Assert.assertEquals(title, "Google");	
	  
	}
	@AfterTest
	
	public void closeurl() {
		
		driver.quit();
		
	}

}
