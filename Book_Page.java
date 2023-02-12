package nopecommercepages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Book_Page {

	WebDriver driver ;

	By Books_link = By.xpath("//a[@href='/books']");
	By Sort_By = By.id("products-orderby");
	
	public void click_books_link() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(Books_link).click();
	}
	
	public void Sort_by_Price() {
		
		WebElement sort = driver.findElement(Sort_By);
		Select prices = new Select(sort);
		prices.selectByVisibleText("Price: Low to High");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	public void add_to_cart() {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='button-2 product-box-add-to-cart-button'])[2]")));
       
        WebElement add_btn = driver.findElement(By.xpath("(//button[@class='button-2 product-box-add-to-cart-button'])[2]"));
        add_btn.click();
	}
	
	public boolean verifying_added() {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebElement shooping_confirm_message = driver.findElement(By.xpath("//p[text()='The product has been added to your ']"));
		
		boolean confirm_message = shooping_confirm_message.isDisplayed();
		
		return confirm_message;
	
		
	}

	
	public Book_Page(WebDriver driver) {
		
		this.driver = driver ;
	}
	
	
}
