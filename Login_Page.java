package nopecommercepages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login_Page {
	
	WebDriver driver ;
	
	By login_link = By.linkText("Log in");
	By email = By.id("Email");
	By password = By.id("Password");
	By login_btn = By.xpath("//button[@class='button-1 login-button']");
	By Myaccount = By.linkText("My account");
	
	public void open_login_screen() {
		
		driver.findElement(login_link).click();
	}
	
	public void Enter_email(String Email) {
		
		driver.findElement(email).sendKeys(Email);
	}
	
	public void Enter_password(String pass) {
		
		driver.findElement(password).sendKeys(pass);
	}
	
	public void click_login_btn() {
		
		driver.findElement(login_btn).click();
	}
	
	public boolean verifying_login_page() {
		
		boolean myaccount = driver.findElement(Myaccount).isDisplayed();
		
		return myaccount ;
			
	}
	
	public Login_Page(WebDriver driver) {
		
		this.driver = driver ;
	}

}
