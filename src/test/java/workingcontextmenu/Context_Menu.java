package workingcontextmenu;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class Context_Menu {
	
	
ChromeDriver driver ;

	
	@BeforeTest
	
	public void openurl() {
		
		ChromeDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://swisnl.github.io/jQuery-contextMenu/demo.html");
	}
	
	@Test
	
	public void test_context_menu() throws InterruptedException {
		
		WebElement right_click = driver.findElement(By.xpath("//span[text()='right click me']"));
		WebElement edit = driver.findElement(By.xpath("//li[@class='context-menu-item context-menu-icon context-menu-icon-edit']"));
		Actions actions = new Actions(driver);
		actions.contextClick(right_click).moveToElement(edit).click().perform();
		
		Thread.sleep(3000);
		
	   // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
	try {    
		
	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	   
	   wait.until(ExpectedConditions.alertIsPresent());
	    
	    Alert alert =  driver.switchTo().alert();
	    assertEquals("clicked: edit", alert.getText());
	    alert.accept();
	    
	 
	}catch(Exception e) {
		
		
	}
		
		
	}
	
	@AfterTest
	
	public void close_url() {
		
		
		driver.quit();
	}
	

}
