package orange_hr_project;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login_Test {
	
	 ChromeDriver driver ;

	
	@BeforeTest
	
	public void open_url() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
	}
	
	@Test
	
	public void login_test() {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement username = driver.findElement(By.name("username"));
		username.sendKeys("Admin");
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("admin123");
		WebElement login_btn = driver.findElement(By.xpath("//button[@type='submit']"));
		login_btn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement img = driver.findElement(By.xpath("//img[@alt='client brand banner']"));
		
		boolean image = img.isDisplayed();
		assertEquals(image, true);	
	}
	
	@Test(enabled=false)
	
	public void log_out() {
		
		WebElement logout_menu = driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']"));
		logout_menu.click();
		WebElement logout_link = driver.findElement(By.xpath("//a[text()='Logout']"));
		logout_link.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement image = driver.findElement(By.tagName("h5"));
		String img = image.getText();
		System.out.println(img);
		assertEquals(img, "Login");
	}
	
	@Test(dependsOnMethods= {"login_test"})
	
	public void add_employee() {
		
		WebElement pim = driver.findElement(By.xpath("//a[@href='/web/index.php/pim/viewPimModule']"));
		pim.click();
		WebElement add_employee = driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']"));
		add_employee.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement fn = driver.findElement(By.name("firstName"));
		fn.sendKeys("Sayed");
		WebElement mn = driver.findElement(By.name("middleName"));
		mn.sendKeys("Adel");
		WebElement ln = driver.findElement(By.name("lastName"));
		ln.sendKeys("Sayed");
		WebElement att_btn = driver.findElement(By.xpath("//button[@class='oxd-icon-button employee-image-action']"));
		att_btn.click();
		String filepath = "F:\\Screenshots.jpg";
		att_btn.sendKeys(filepath);
		
		WebElement save_btn = driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']"));
		save_btn.click();
		
		
	}
	

	@AfterTest
	
	public void close_url() {
		
		driver.quit();
		
	}
	
}
