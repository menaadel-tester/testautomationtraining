package automationpdfpractiseFromLinkedin;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetText {
	
	
	ChromeDriver driver ;
	
	@BeforeTest
	
	public void open_url() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.google.com.eg/");
		
		
	}
	
	@Test
	
	public void check_gmail() {
		
		WebElement gmail_link = driver.findElement(By.linkText("Gmail"));
		
		String type_link = gmail_link.getText();// to print something & this is String 
		boolean type_link_is_Exist = gmail_link.isEnabled();// to make Sure The Element is Exist in The Web Page & it is boolean Data type
		System.out.println(type_link);
		System.out.println(type_link_is_Exist);
		
	}
	
	@Test
	
	public void takescreen_shot() throws IOException {
		
		File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		Files.copy(f,new File("F:\\Selenium ScreenShot\\file.jpg"));
		
		
	}
	
	
	
	
	
	
	@AfterTest
	
	public void close_url() {
		
		driver.quit();
		
	}
	
	
	

}
