package workingwithcheckboxandradiobutton;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBoxandRadioButton {
	
	ChromeDriver driver ;
	
	
	@BeforeTest
	
	public void OpenUrl() {
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	    driver.navigate().to("https://theautomationzone.blogspot.com/2020/06/simple-checkbox-and-radio-buttons.html");
	}
	
	@Test
	
	public void checkboxcase() throws InterruptedException {
		
		WebElement check_box = driver.findElement(By.id("myCheck"));
		check_box.click();
		
		Thread.sleep(3000);
		
		
		if(check_box.isSelected()) {
						
			WebElement message = driver.findElement(By.xpath("//p[text()='Checkbox is CHECKED!']"));
			
			String text_message = message.getText();
			
			//Assert.assertTrue(check_box.isSelected());
			
			assertEquals("Checkbox is CHECKED!", text_message);
			
		}
			
	}
	
	
	@Test
	
	public void checkradio_button() {
		
		WebElement radio_button = driver.findElement(By.id("gc"));
		radio_button.click();
		
		if(radio_button.isSelected()) {
			
			WebElement text = driver.findElement(By.xpath("//input[@id='result']"));
			
			Assert.assertTrue(true, "Your favorite browser is");
			
			System.out.println(text.getTagName());
		}
	}
	
	@AfterTest
	
	public void closeurl() {
		
		driver.close();
		
		
	}

}
