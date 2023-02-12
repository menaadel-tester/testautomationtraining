package com.automation.test;


import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.automatio.page.Home_Page;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Main_Class {
	
	
	ChromeDriver driver ;
	
	
	@BeforeTest
	
	public void open_url() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.pinterest.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
	}
	
	@Test
	
	public void verifying_login() {
		
	Home_Page home_page = new Home_Page(driver);
	home_page.open_login_screen();
	home_page.type_email("upworkforever2020@gmail.com");
	home_page.type_password("M@m0102273135");
	home_page.click_on_login_button();
	Assert.assertTrue(home_page.verifying_login_Success());
		
	}
	
	@AfterTest
	
	public void close_url() {
		
		driver.quit();
		
		
	}

}
