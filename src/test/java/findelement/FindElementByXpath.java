package findelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindElementByXpath {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver =  new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/login");
		WebElement Username = driver.findElement(By.xpath("//*[@id=\"username\"]"));
		WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		WebElement loginbtn =  driver.findElement(By.xpath("//*[@id=\"login\"]/button"));
		
		System.out.println(Username.getTagName());
		System.out.println(password.getTagName());
		System.out.println(loginbtn.getTagName());
		driver.quit();
		

	}

}
