package selenium.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGDemo2 {
	
	 public ChromeDriver driver ;
	
	@BeforeTest
	
	public void openurl() {
		
    String chromepath = System.getProperty("user.dir")+"\\Resources\\chromedriver.exe";
		
		System.setProperty("webdriver.chrome.driver", chromepath);
		
         driver = new ChromeDriver();
		driver.navigate().to("https://www.google.com/");	
	}
	
	@Test
	
	public void getcurrenturl() {
		
		driver.getCurrentUrl();
		
		System.out.println(driver.getCurrentUrl());
	}
	
	@Test
	
	public void gettitle() {
		
		driver.getTitle();
		System.out.println(driver.getTitle());
				
	}
	
	@AfterTest

	public void closeurl() {
		
		driver.quit();
		
		
	}

}
