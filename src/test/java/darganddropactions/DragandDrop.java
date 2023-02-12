package darganddropactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragandDrop {
	
	
	ChromeDriver driver ;
	
	@BeforeTest
	
	public void openguru_url() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://www.seleniumacademy.com/cookbook/DragDropDemo.html");
		
		
	}
	
	@Test
	
	public void testdraganddrop() throws Exception {
		
		WebElement Source = driver.findElement(By.id("draggable"));
		WebElement Target = driver.findElement(By.id("droppable"));
		Actions builder = new Actions(driver);
		
		builder.dragAndDrop(Source, Target).perform();
		Thread.sleep(3000);
		Assert.assertEquals("Dropped!", Target.getText());
		
		
	}
	
	@AfterTest
	
	public void closeurl() {
		
		driver.quit();
		
		
	}
	


}
