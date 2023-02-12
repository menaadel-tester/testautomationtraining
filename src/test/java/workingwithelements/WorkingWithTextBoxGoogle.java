package workingwithelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkingWithTextBoxGoogle {
	
	ChromeDriver driver ;
	 public String search_text ;
	@BeforeTest
	
	public void openurl() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		
	}
		
		
		@Test
		
		public void typeinsearchtxt() {
		
		 WebElement search_txt = driver.findElement(By.name("q"));
		search_txt.sendKeys("Selenium Web Driver");
		search_txt.submit();
		driver.navigate().back();
		
		}
		
		
		
		@Test
		
		public void addanothertext() {
			
			 WebElement search_txt = driver.findElement(By.name("q"));
				search_txt.sendKeys("Selenium Web Driver");
				search_txt.submit();
			
			
			
			
		}
		
		
		
		
		
	
		
		@AfterTest
		
		public void closescreen() {
			
			driver.quit();
		}
			
			
	
		


		
	}
	

