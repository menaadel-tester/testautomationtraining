package automationpdfpractiseFromLinkedin;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class TakeScreenShotInTheSameProject {
	
ChromeDriver driver ;

	
	@BeforeTest
	
	public void openurl() {
		
		ChromeDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://www.tutorialsninja.com/demo/");
	}
	
	@Test
	
	public void takescreenshot() throws Exception {
		
		File search = driver.findElement(By.name("search")).getScreenshotAs(OutputType.FILE);
		
		//FileHandler.copy(search,new File(System.getProperty("user.dir") + "\\Screenshots.png"));
		FileHandler.copy(search,new File("\\F:\\Maven\\Screenshots.jpg"));
		
		
	}
	
	
	@AfterTest
	
	public void closeurl() {
		
	
		driver.quit();
	}

}
