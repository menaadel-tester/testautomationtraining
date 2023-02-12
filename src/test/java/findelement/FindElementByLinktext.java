package findelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindElementByLinktext {
	
	 ChromeDriver driver ;
	
	
	@BeforeTest
	
	public void openurl() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/login");	
	}
	
	@Test
	public void findelementbylinktext() {
		
	 WebElement linktext = 	driver.findElement(By.linkText("Elemental Selenium"));
	 
	 System.out.println(linktext.getAttribute("href"));
		
		
	}
	
	@AfterTest
	
	public void closeurl() {
		
		driver.close();
		
	}

	
}
