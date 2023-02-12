package workingwithtable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkingWithTable {
	
	
	ChromeDriver driver ;
	
	@BeforeTest
	
	public void openguru_url() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://money.rediff.com/indices");
	}
	
	@Test
	public void testtable() {
		
		WebElement webtable = driver.findElement(By.xpath("//table[@id='dataTable']"));
		List<WebElement> rows = webtable.findElements(By.tagName("tr"));
		int rowcount = rows.size();
		System.out.println(rowcount);
		
		for(int i=0;i<rowcount;i++) {
			
			List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));
			int columncount = columns.size();
			for(int j=0 ;  j<columncount; j++) {
				String cell_text = columns.get(j).getText();
				if(cell_text.equals("S&P BSE 500")) {
				System.out.println("The Previous close Value is " + columns.get(j).getText());
			}
				
			}
			
		}
			
	}
	
	@AfterTest
	
	public void close_url() {
		
		driver.close();
		
		
	}
	
	
	

}
