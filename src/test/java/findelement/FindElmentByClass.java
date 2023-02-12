package findelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindElmentByClass {

	public static void main(String[] args) {
		
		   WebDriverManager.chromedriver().setup();
		    WebDriver driver = new ChromeDriver();
		    driver.manage().window().maximize();
		    driver.get("https://the-internet.herokuapp.com/login");
		    WebElement loginbtn = driver.findElement(By.className("radius"));
		    System.out.println(loginbtn.getTagName());
		    System.out.println(loginbtn.getText());
		    

	}

}
