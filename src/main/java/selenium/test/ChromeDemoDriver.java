package selenium.test;

import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDemoDriver {

	public static void main(String[] args) {
		
		String chromepath = System.getProperty("user.dir")+"\\Resources\\chromedriver.exe";
		
		System.setProperty("webdriver.chrome.driver", chromepath);
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.quit();
		

	}

}
