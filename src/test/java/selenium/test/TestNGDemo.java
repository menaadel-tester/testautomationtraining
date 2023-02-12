package selenium.test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGDemo {
	
	
	@BeforeTest
	
	public void openurl() {
		
		
		System.out.println("the browser will open here");
	}
	
	@Test
	
	public void loginuser() {
		
		System.out.println("the user login Successfully");
	}
	
	@Test
	
	public void userbuythings() {
		
		System.out.println("the user can buy things from web site");
	}
	
	@AfterTest
	
	public void closeurl() {
		
		
		System.out.println("the user logout and close the browser");
		
		
	}
		
		

	
	

}
