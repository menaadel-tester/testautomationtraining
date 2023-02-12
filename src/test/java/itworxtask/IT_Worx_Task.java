package itworxtask;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IT_Worx_Task {
	

	ChromeDriver driver ;
	
	@BeforeTest
	
	public void open_url() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://demo.themeparrot.com/shopy/");
			
	}
	
	@Test
	
	public void open_bracelest_page() {
		
		WebElement catalog = driver.findElement(By.xpath("(//a[text()='Catalog'])[2]"));
		Actions action = new Actions(driver);
		action.moveToElement(catalog).perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement brace_link = driver.findElement(By.xpath("//li[@data-id='113']//a[1]"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		brace_link.click();
		WebElement categories = driver.findElement(By.tagName("h4"));
		
	    boolean title = categories.isDisplayed();
	     
	     assertEquals(title, true);
		
	}
	
	@Test(dependsOnMethods= {"open_bracelest_page"})
	
	public void search_fa() {
		
		WebElement search_box = driver.findElement(By.name("search"));
		search_box.sendKeys("fa");
		WebElement go_btn = driver.findElement(By.xpath("(//input[@value='Go'])[1]"));
		go_btn.click();
		
		WebElement fashion_bra = driver.findElement(By.xpath("//a[@title='Fashion Bracelet1']"));
		
		boolean image_bracelet = fashion_bra.isDisplayed();
		assertEquals(image_bracelet, true);
	}
	
	@Test(dependsOnMethods= {"search_fa"})
	
	public void add_product_to_cart() {
		
		WebElement add_cart = driver.findElement(By.xpath("(//button[@title='Add to cart'])[1]"));
		add_cart.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement cart = driver.findElement(By.xpath("//i[@class='fa fa-shopping-cart']"));
		cart.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement unit_price = driver.findElement(By.xpath("//span[@class='cart-item-value']"));
	     String unit1 = unit_price.getText();
		System.out.println(unit_price.getText());
		WebElement total_price = driver.findElement(By.xpath("(//th[@colspan='2']/following-sibling::td)[2]"));
		 String unit2 =total_price.getText();
		System.out.println(total_price.getText());
		
			
			assertEquals(unit2, unit1, "the same price");
		
		}
		
	
	
	
	@AfterTest
	public void close_url() {
		
		
		driver.quit();
		
		
	}
}
