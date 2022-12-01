package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class ChkoutwithoutProduct {
	public WebDriver driver;
@Test
	public void Tc_SL_045() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\dbegum01\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("checkout")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("first-name")).sendKeys("xyz");
		driver.findElement(By.id("last-name")).sendKeys("abc");
		driver.findElement(By.id("postal-code")).sendKeys("12345");
		Thread.sleep(2000);
		driver.findElement(By.id("continue")).click();
		Thread.sleep(2000);
		String element="Your cart is empty";
	
           if(element().isDisplayed())
               return;
               else
               {
              return;
             }
       
}
private WebElement element() {
	// TODO Auto-generated method stub
	return null;
}

@AfterMethod
public void quit() {
	driver.quit();
}
	}
