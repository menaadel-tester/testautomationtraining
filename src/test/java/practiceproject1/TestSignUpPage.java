package practiceproject1;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestSignUpPage {
	
	ChromeDriver driver;
	
	@BeforeTest
	
	public void openurl() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://itera-qa.azurewebsites.net/home/automation");
		
		
	}
	
	@Test(priority=1)
	
	public void registersignup() throws InterruptedException {
		
		WebElement fname = driver.findElement(By.id("name"));
		
		fname.sendKeys("Mena adel");
		
		WebElement  phone = driver.findElement(By.id("phone"));
		
		phone.sendKeys("01200088785");
		
		WebElement email = driver.findElement(By.id("email"));
		
		email.sendKeys("menadl285@gmail.com");
		
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("M@m0102273135");
		
		WebElement address = driver.findElement(By.id("address"));
		address.sendKeys("17 abdel hakeem Reda Street");
		
		Thread.sleep(2000);
		
		WebElement btn = driver.findElement(By.name("submit"));
		
		btn.click();
		
		Thread.sleep(2000);
		


	}
	
	
	@Test(priority=2)
	
	public void test_gender() throws InterruptedException {
		
		WebElement m = driver.findElement(By.id("male"));
		
		m.click();
		
		Thread.sleep(2000);
	}
	
	@Test(priority=3)
	
	public void test_weekend() throws InterruptedException {
		
		WebElement mo = driver.findElement(By.id("monday"));
		
		mo.click();
		
		Thread.sleep(2000);
	}
	
	
	@Test(priority=4)
	
	public void test_country() throws InterruptedException {
		
		WebElement drop_down = driver.findElement(By.className("custom-select"));
		
		Select select_option = new Select(drop_down);
		
		select_option.selectByValue("10");
		
		Thread.sleep(2000);
		
	}
	
	@Test(priority=5)
	
	public void test_experience() throws InterruptedException {
		
		WebElement y = driver.findElement(By.xpath("//label[text()='4 years']"));
		y.click();
		
		Thread.sleep(3000);
	
	}
	
	@Test(priority=6)
	
	public void auto_tool() throws InterruptedException {
		
		WebElement tool = driver.findElement(By.xpath("//label[@for='testng']"));
		
		tool.click();
		
		Thread.sleep(3000);
	}
	
	
	
	@Test(priority=7)
	
	public void test_upload_file() throws InterruptedException{
		
	String file_path = "F:\\mena.jpg";
	
	WebElement browse = driver.findElement(By.id("inputGroupFile02"));
	
	browse.sendKeys(file_path);
	
	Thread.sleep(3000);
	
	
	}
	
	
	
	
	
	@AfterTest
	
	public void closeurl() {
		
		driver.quit();
		
		
	}
	
	

}
