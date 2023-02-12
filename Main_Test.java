package nopecommercetests;



import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import nopecommercepages.Book_Page;
import nopecommercepages.Cart_Page;
import nopecommercepages.Login_Page;
import nopecommercepages.Register_Page;

public class Main_Test {
	
	
	ChromeDriver driver ;
	
	@BeforeTest
	
	public void open_url() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://demo.nopcommerce.com/");
		
		
	}
	
	@Test
	
	public void register_screen() {
		
		Register_Page register_page = new Register_Page(driver);
		register_page.open_register_page();
		register_page.select_gender();
		register_page.input_first_name("Mena");
		register_page.input_last_name("Makeen");
		register_page.input_email("upworkforever2020@gmail.com");
		register_page.input_company("Trufla");
		register_page.input_password("M@m0102273135");
		register_page.input_confirm_password("M@m0102273135");
		register_page.click_register_btn();
		Assert.assertTrue(register_page.verifying_register_message());
		
	}
	
	@Test(dependsOnMethods= {"register_screen"})
	
	public void login_screen() {
		
		Login_Page loginpage = new Login_Page(driver);
		loginpage.open_login_screen();
		loginpage.Enter_email("upworkforever2020@gmail.com");
		loginpage.Enter_password("M@m0102273135");
		loginpage.click_login_btn();
		Assert.assertTrue(loginpage.verifying_login_page());
		
	}
	
	@Test(dependsOnMethods= {"login_screen"})
	
	public void add_book_to_cart() {
		
		Book_Page book_page = new Book_Page(driver);
		book_page.click_books_link();
		book_page.Sort_by_Price();
		book_page.add_to_cart();
		Assert.assertTrue(book_page.verifying_added());
	}
	
	
	@Test(dependsOnMethods= {"add_book_to_cart"})
	
	public void check_out_order() {
		
		Cart_Page cartpage= new Cart_Page(driver);
		cartpage.click_on_shopping_cart();
		cartpage.click_on_checkout();
		Assert.assertTrue(cartpage.Verified_Check_out());
		
		
	}
	
	@AfterTest
	
	public void close_url() {
		
		driver.quit();
		
	}

}
