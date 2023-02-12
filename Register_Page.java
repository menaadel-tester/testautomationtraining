package nopecommercepages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Register_Page {
	
	
	WebDriver driver ;
	
	By register_link = By.linkText("Register");
	By gender_male = By.id("gender-male");
	By first_name = By.id("FirstName");
	By last_name = By.id("LastName");
	By email = By.id("Email");
	By company = By.id("Company");
	By password = By.id("Password");
	By confirm_password = By.id("ConfirmPassword");
	By register_btn = By.id("register-button");
	By register_message = By.xpath("//div[text()='Your registration completed']");
	
	
	public void open_register_page() {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(register_link).click();
	}
	
	public void select_gender() {
		
		driver.findElement(gender_male).click();
	}
	
	public void input_first_name(String firstname) {
		
		driver.findElement(first_name).sendKeys(firstname);
	}
	
	public void input_last_name(String lastname) {
		
		driver.findElement(last_name).sendKeys(lastname);
	}
	
	public void input_email(String mail) {
		
		driver.findElement(email).sendKeys(mail);
	}
	
	public void input_company(String companyname) {
		
		driver.findElement(company).sendKeys(companyname);
	}
	
	public void input_password(String pass) {
		
		driver.findElement(password).sendKeys(pass);
	}
	
	public void input_confirm_password(String confirmpass) {
		
		driver.findElement(confirm_password).sendKeys(confirmpass);
	}
	
	public void click_register_btn() {
		
		driver.findElement(register_btn).click();
	}
	
	public boolean verifying_register_message() {
		
		boolean message = driver.findElement(register_message).isDisplayed();
		
		return message ;
	}
	
	public Register_Page(WebDriver driver) {
		
		this.driver = driver ;
	}

}
