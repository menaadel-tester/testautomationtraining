package findelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Findelement {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		 WebElement text_field = driver.findElement(By.name("q"));
		 text_field.sendKeys("automation step by step");
		 text_field.submit();
		 
	      System.out.println(driver.getTitle());
		 driver.quit();

	}

}
