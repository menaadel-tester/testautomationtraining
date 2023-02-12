package visitwebsites;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowSize {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver =   new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://qacart.com/");
		Dimension iphoneXR  = new Dimension(414,896);
		
		driver.manage().window().setSize(iphoneXR);
		
		driver.quit();

	}

}
