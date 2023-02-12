package guruproject;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginWithValidUserNameAndPassword {
	
	
	ChromeDriver driver;
	
	@BeforeTest
	
	public void openurl() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://www.demo.guru99.com/V4/");	
	}
	
	@Test
	
	public void loginwithvalidusernameandpassword() throws InterruptedException {
		
		WebElement un = driver.findElement(By.name("uid"));
		
		un.sendKeys("mngr464486");
		
		WebElement pass = driver.findElement(By.name("password"));
		
		pass.sendKeys("mUvagUg");
		
		WebElement btn = driver.findElement(By.name("btnLogin"));
		
		btn.click();
		
		Thread.sleep(3000);
		
		WebElement guru_bank = driver.findElement(By.xpath("//h2[text()='Guru99 Bank']"));
		
		boolean title = guru_bank.isDisplayed();
		
		assertEquals(true, title);
		
		Thread.sleep(2000);	
	}
	
	/*@Test(dependsOnMethods={"loginwithvalidusernameandpassword"})
		
		
public void add_new_customer() throws InterruptedException {
		
		WebElement new_customer_link = driver.findElement(By.xpath("//a[text()='New Customer']"));
		new_customer_link.click();
		Thread.sleep(5000);
		WebElement customer_name = driver.findElement(By.xpath("//table[@class='layout']//table/tbody[1]/tr[4]/td[2]/input[1]"));
		customer_name.sendKeys("Mena Makeen");
		WebElement rad_btn = driver.findElement(By.name("rad1"));
		rad_btn.click();
		WebElement date_of_birth = driver.findElement(By.id("dob"));
		date_of_birth.sendKeys("05/25/1987");
		WebElement address = driver.findElement(By.name("addr"));
		address.sendKeys("17 abdel hakeem Reda Street");
		
	
		
	}
	
	*/
	
	
	
	@AfterTest
	
	public void close_url() {
		
		driver.quit();
	}
	

}
