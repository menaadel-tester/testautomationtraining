package workingwithframe;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkingWithFrames {
	
	ChromeDriver driver ;
	
	@BeforeTest
	
	public void open_url() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://cookbook.seleniumacademy.com/Frames.html");
		
	}
	
	@Test
	
	public void testframewithIDOrName() {
		
		driver.switchTo().frame("left"); // locate iframe by ID
		WebElement paragraph = driver.findElement(By.tagName("p"));
		
		String Paragraph_txt = paragraph.getText();
		assertEquals(Paragraph_txt, "This is Left Frame");
		driver.switchTo().defaultContent();
		driver.switchTo().frame("right"); // locate iframe by Name 
		WebElement paragraph_2 = driver.findElement(By.tagName("P"));
		String paragraph_txt2 = paragraph_2.getText();
		assertEquals(paragraph_txt2, "This is Right Frame");
		driver.switchTo().defaultContent();
		driver.switchTo().frame(1);
		WebElement paragraph_txt3 = driver.findElement(By.tagName("p"));
		
		String Paragraph_txt3 = paragraph_txt3.getText();
		assertEquals(Paragraph_txt3, "This Frame doesn't have id or name");
		driver.switchTo().defaultContent();
		
	}
	
	@AfterTest
	
	public void close_url() {
		
		
		
		driver.close();
		
		
	}

}
