package workingwithjavascriptexecutor;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptTest {
	
ChromeDriver driver ;
	
	@BeforeTest
	
	public void open_url() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.google.com/");
		
	}
	
	@Test
	
	public void testjava_script() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver ;
		
		String title = (String) js.executeScript("return document.title");
		
		System.out.println(title);
		
		assertEquals(title, "Google");
		
		
		Long Link = (Long) js.executeScript("var Link = document.getElementsByTagName('A'); return Link.length");
		
		System.out.print(Link);
		
		assertEquals(Link, 18);
		
		
		
		
		
	}
	
	@AfterTest
	
	public void close_url() {
		
		driver.quit();
		
	}

}
