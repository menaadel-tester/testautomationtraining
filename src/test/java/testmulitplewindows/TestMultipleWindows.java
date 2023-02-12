package testmulitplewindows;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class TestMultipleWindows {
	
	ChromeDriver driver ;
	
	@BeforeTest
	
	public void openurl() {
		
		ChromeDriverManager.chromedriver().setup();
		driver =  new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://www.seleniumacademy.com/cookbook/Config.html");
		
	}
	
	
	@Test(priority = 1)
	
	public void testwindowname() {
		
		//store window handle from window parent 
		
		String currentwindowid = driver.getWindowHandle();
		
		 WebElement visit_us_button = driver.findElement(By.id("visitbutton"));
		 visit_us_button.click();
		 
		for (String i : driver.getWindowHandles())
		{
			String title = driver.switchTo().window(i).getTitle();
			
			if(title.equals("Visit Us")) {
				
				assertEquals("Visit Us", driver.getTitle());
				
				System.out.println(driver.getTitle());
				driver.close();

				break;
			}
		}
		
		driver.switchTo().window(currentwindowid);
		
	}
	
	@Test(priority = 2)
	
	public void testhelpwindow() {
		
		String WindowId = driver.getWindowHandle();
		
		WebElement help_button = driver.findElement(By.id("helpbutton"));
		help_button.click();
		
		driver.switchTo().window("HelpWindow");
		
		assertEquals("Help", driver.getTitle());
		
		System.out.println(driver.getTitle());
		driver.close();
		driver.switchTo().window(WindowId);
	}
	
	
	
	
	@AfterTest
	
	public void closeurl() {
		
		driver.quit();
	}

}


