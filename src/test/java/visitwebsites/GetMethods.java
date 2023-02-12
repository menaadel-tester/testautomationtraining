package visitwebsites;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetMethods {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver =   new ChromeDriver();
		//driver.manage().window().maximize();
		driver.manage().window().fullscreen();
		driver.get("https://qacart.com/");
		driver.close();

	}

}
