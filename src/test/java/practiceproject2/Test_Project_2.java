package practiceproject2;

import static org.testng.Assert.assertEquals;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_Project_2 {
	
	
	ChromeDriver driver ;
	
	@BeforeTest
	
	public void open_url() {
		
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.navigate().to("https://www.saucedemo.com/");
		
	}
	
	@Test(priority=2)
	
	public void login_with_correct_password() throws InterruptedException {
		
		WebElement user_name = driver.findElement(By.id("user-name"));
		user_name.sendKeys("standard_user");
		
		WebElement password = driver.findElement(By.id("password"));
	    password.sendKeys("secret_sauce");
	    
	    Thread.sleep(2000);
	    
	    WebElement btn = driver.findElement(By.id("login-button"));
	   btn.click();
	    
	     String url = driver.getTitle();
	     System.out.println(url);
	    
	    assertEquals("Swag Labs",url );
	    
		
		
	}
	
	@Test
	
	public void login_with_invalid_password() throws InterruptedException {
		
		WebElement user_name = driver.findElement(By.id("user-name"));
		user_name.sendKeys("standard_user");
		WebElement password = driver.findElement(By.id("password"));
	    password.sendKeys("123456789");
	    
	    WebElement btn = driver.findElement(By.id("login-button"));
	    btn.click();
	    
	 WebElement Error = driver.findElement(By.xpath("//h3[@data-test='error']"));
	 
	 String message = Error.getText();
	 System.out.println(message);
	 user_name.clear();
	 password.clear();
	 Thread.sleep(5000);
	 
	    
	   assertEquals("Epic sadface: Username and password do not match any user in this service", message);	
	}
	
	@Test
	
	public void invalidloginwith_invalid_username_and_correctpassword() throws InterruptedException {
		
		WebElement user_name = driver.findElement(By.id("user-name"));
		user_name.sendKeys("mena");
		WebElement password = driver.findElement(By.id("password"));
	    password.sendKeys("secret_sauce");
	    
	    WebElement btn = driver.findElement(By.id("login-button"));
	    btn.click();
	    
	    user_name.clear();
	    password.clear();
	    Thread.sleep(5000);
	    
	}
	
	@AfterTest
	
	public void close_url() {
		
		driver.close();
		
		
	}

}
