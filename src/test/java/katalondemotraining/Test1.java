package katalondemotraining;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test1 {
	
	
	ChromeDriver driver ;
	
	@BeforeTest
	
	public void open_url() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://katalon-demo-cura.herokuapp.com/");
	
	}
	
	@Test
	
	public void login() throws InterruptedException {
		
		WebElement btn = driver.findElement(By.id("btn-make-appointment"));
		btn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement un = driver.findElement(By.id("txt-username"));
		un.sendKeys("John Doe");
		WebElement pass = driver.findElement(By.id("txt-password"));
		pass.sendKeys("ThisIsNotAPassword");
		WebElement login_btn = driver.findElement(By.id("btn-login"));
		login_btn.click();
		Thread.sleep(5000);
		WebElement title = driver.findElement(By.tagName("h2"));
		
		String  title_msg = title.getText();
		assertEquals(title_msg, "Make Appointment");
		
	}
	
	@Test(dependsOnMethods= {"login"})
	
	
	public void make_appointement() throws InterruptedException {
		
		WebElement facility = driver.findElement(By.id("combo_facility"));
		
		Select hong_kong = new Select(facility);
		hong_kong.selectByValue("Hongkong CURA Healthcare Center");
		Thread.sleep(5000);
		
		WebElement check_box = driver.findElement(By.id("chk_hospotal_readmission"));
		check_box.click();
		Thread.sleep(5000);
		
		WebElement health_program = driver.findElement(By.id("radio_program_medicaid"));
		health_program.click();
		Thread.sleep(5000);
		
		WebElement visit = driver.findElement(By.id("txt_visit_date"));
		visit.sendKeys("25/01/2023");
		Thread.sleep(5000);
		WebElement txt_comment = driver.findElement(By.id("txt_comment"));
		txt_comment.sendKeys("Confirm The appointment please via mail");
		Thread.sleep(5000);
		WebElement book_appointment = driver.findElement(By.id("btn-book-appointment"));
		book_appointment.click();
		WebElement confirm_title = driver.findElement(By.tagName("h2"));
		
		String Confirm_message = confirm_title.getText();
		assertEquals(Confirm_message, "Appointment Confirmation", "Success");
		
	}
	
     
	@Test(dependsOnMethods= {"make_appointement"})
	
	public void log_out() throws InterruptedException {
		
		WebElement home_page = driver.findElement(By.xpath("//a[text()='Go to Homepage']"));
		home_page.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(5000);
		WebElement box = driver.findElement(By.id("menu-toggle"));
		box.click();
		Thread.sleep(5000);
		WebElement log_out = driver.findElement(By.xpath("//a[text()='Logout']"));
		log_out.click();
		WebElement title = driver.findElement(By.tagName("h1"));
		boolean message = title.isDisplayed();
	    assertTrue(message, "success");
	}
	

	@AfterTest
	
	public void close_url() {
		
		driver.close();
	}
}
