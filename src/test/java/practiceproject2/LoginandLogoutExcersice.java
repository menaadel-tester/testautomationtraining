package practiceproject2;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginandLogoutExcersice {
	
	ChromeDriver driver ;
	
	@BeforeTest
	
	public void openurl() throws InterruptedException {
		
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	Thread.sleep(2000);
	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	driver.navigate().to("https://www.saucedemo.com/");
		
		
		
	}
	
	@Test
	
	public void loginandlogout() throws InterruptedException {
		
		WebElement user_name = driver.findElement(By.id("user-name"));
		user_name.sendKeys("standard_user");
		
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("secret_sauce");
		
		WebElement button = driver.findElement(By.id("login-button"));
		button.click();
		Thread.sleep(2000);
		WebElement add_to_cart_1 = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
		add_to_cart_1.click();
		Thread.sleep(2000);
		WebElement add_to_cart_2 = driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
		add_to_cart_2.click();
		Thread.sleep(2000);
		WebElement cart = driver.findElement(By.className("shopping_cart_badge"));
		cart.click();
		WebElement remove_1 = driver.findElement(By.id("remove-sauce-labs-backpack"));
		remove_1.click();
		WebElement remove_2 = driver.findElement(By.id("remove-sauce-labs-bike-light"));
		remove_2.click();
		WebElement side_menu = driver.findElement(By.id("react-burger-menu-btn"));
		side_menu.click();
		WebElement log_out = driver.findElement(By.id("logout_sidebar_link"));
		log_out.click();
		
		String URL = driver.getCurrentUrl();
		
		assertEquals(URL, "https://www.saucedemo.com/");
		
		
	}
	
	
	@Test
	
	public void puchase_item() throws InterruptedException {
		WebElement user_name = driver.findElement(By.id("user-name"));
		user_name.sendKeys("standard_user");
		
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("secret_sauce");
		
		WebElement button = driver.findElement(By.id("login-button"));
		button.click();
		Thread.sleep(2000);
		 
		WebElement add_jacket = driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket"));
		add_jacket.click();
		
		WebElement cart = driver.findElement(By.className("shopping_cart_badge"));
		cart.click();
		
		WebElement check_out = driver.findElement(By.id("checkout"));
		check_out.click();
		Thread.sleep(2000);
		WebElement fn = driver.findElement(By.id("first-name"));
		fn.sendKeys("mena");
		WebElement ln = driver.findElement(By.id("last-name"));
		ln.sendKeys("Adel");
		WebElement postal_code = driver.findElement(By.id("postal-code"));
		postal_code.sendKeys("7111");
		WebElement cont_btn = driver.findElement(By.id("continue"));
		cont_btn.click();
		WebElement fin_btn = driver.findElement(By.id("finish"));
		fin_btn.click();
		
		WebElement complete_message = driver.findElement(By.xpath("//h2[text()='THANK YOU FOR YOUR ORDER']"));
		
		String Complete_Message = complete_message.getText();
		
		assertEquals(Complete_Message, "THANK YOU FOR YOUR ORDER");
		
	}
	
	
	@AfterTest
	
	
	public void  close_url() {
		
		driver.quit();
		
	}
	
	
	
	

}
