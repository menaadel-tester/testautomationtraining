package com.automatio.page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home_Page {
	
	
	WebDriver driver ;
	
	By login_link = By.xpath("//div[@class='tBJ dyH iFc sAJ xnr tg7 H2s'][text()='Log in']");
	By Email = By.id("email");
	By Pass = By.id("password");
    By Login_btn = By.xpath("//button[contains(@class,'red SignupButton')]//div[1]");
    By Sign_up_btn = By.xpath("//button[@type='button'][text()='Not on Pinterest yet? Sign up']");
    By home_img = By.xpath("//span[@class='tBJ dyH iFc sAJ xnr tg7 H2s']");
    
    
    
    
    public void open_login_screen() {
    	
    	driver.findElement(login_link).click();
    }
    
    
    
    public void type_email(String emailId) {
    	
    	driver.findElement(Email).sendKeys(emailId);
    	
    	
    }
    
    public void type_password(String passwordId) {
    	
    	driver.findElement(Pass).sendKeys(passwordId);
    }
    
    public void click_on_login_button() {
    	
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	
    	driver.findElement(Login_btn).click();
    	
    }
    
    public boolean verifying_login_Success() {
    	
    	boolean image = driver.findElement(home_img).isDisplayed();
    	return image ;
    }
    
    public Home_Page(WebDriver driver) {
    	
    	this.driver = driver ;
    	
    	
    }







	
	}
    
    


