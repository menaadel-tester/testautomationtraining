package basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenFireFoxDriver {

	public static void main(String[] args) {
		
      WebDriverManager.firefoxdriver().setup();
      WebDriver driver = new FirefoxDriver();
     
	}

}
