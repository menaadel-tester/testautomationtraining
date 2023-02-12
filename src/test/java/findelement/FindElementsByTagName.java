package findelement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindElementsByTagName {

	public static void main(String[] args) {

    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.get("https://the-internet.herokuapp.com/tables");
    WebElement table = driver.findElement(By.id("table1"));
    List<WebElement> rows = table.findElements(By.tagName("tr"));
    System.out.println(rows.size());
    System.out.println(rows.get(3).getText());
    driver.quit();
    
    

	}

}
