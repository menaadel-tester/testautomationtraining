package nopecommercepages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Cart_Page {
	
	WebDriver driver ;
	
	
	public void click_on_shopping_cart() {
		
		WebElement close_btn = driver.findElement(By.xpath("//span[@title='Close']"));
		close_btn.click();
		WebElement shopping_cart = driver.findElement(By.xpath("//span[text()='Shopping cart']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(shopping_cart).perform();
		WebElement Go_to_cart = driver.findElement(By.xpath("//button[text()='Go to cart']"));
		Go_to_cart.click();
	}
	
	public void click_on_checkout() {
		
	  WebElement terms_services = driver.findElement(By.id("termsofservice"));
	  terms_services.click();
	  WebElement checkout_btn = driver.findElement(By.id("checkout"));
	  checkout_btn.click();
	}
	
	public boolean Verified_Check_out() {
		
		WebElement check_out_title = driver.findElement(By.tagName("h1"));
		
		boolean check_out_title_message = check_out_title.isDisplayed();
		
		return check_out_title_message ;
	}
	
	public Cart_Page(WebDriver driver) {
		
		this.driver = driver ;
	}

}


