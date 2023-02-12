package findelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPageTest {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
	WebDriver driver = new ChromeDriver();
	
	driver.manage().window().maximize();
	driver.navigate().to("https://the-internet.herokuapp.com/login");
	
     WebElement username_field = driver.findElement(By.id("username"));
     username_field.sendKeys("tomsmith");
     
     WebElement password_field = driver.findElement(By.id("password"));
     password_field.sendKeys("SuperSecretPassword!");
     
     WebElement button = driver.findElement(By.className("radius"));
     
     button.click();
     
     System.out.println(driver.getTitle());
     
     Thread.sleep(2000);
     
     WebElement log_out = driver.findElement(By.xpath("//*[@id=\"content\"]/div/a"));
     
     log_out.click();
     
     Thread.sleep(1000);
     
     driver.quit();
     
    
		

	}

}
