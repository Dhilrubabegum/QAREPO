package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ChkoutFail {
	public WebDriver driver;

	@BeforeMethod

	public void Login() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\dbegum01\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		Thread.sleep(2000);
}
	@DataProvider(name = "checkout")
	public String[][]getdata() {
		String[][]data=new String[4][3];
		data[0][0]="12345";		//Tc_SL_050
		data[0][1]="abc";
		data[0][2]="12345";
		
		data[1][0]="xyz";		//Tc_SL_051
		data[1][1]="12345";
		data[1][2]="12345";
		
		data[2][0]="1234";		//Tc_SL_052
		data[2][1]="12345";
		data[2][2]="12345";
		
		data[3][0]="xyz";		//Tc_SL_053
		data[3][1]="abc";
		data[3][2]="12345678";
		
		
	
		return data;
	}
	@Test(dataProvider = "checkout")
	public  void Tc_SL_050to053(String firstname, String lastname, String postalcode) throws InterruptedException{
		driver.findElement(By.id("checkout")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("first-name")).sendKeys(firstname);
		driver.findElement(By.id("last-name")).sendKeys(lastname);
		driver.findElement(By.id("postal-code")).sendKeys(postalcode);
		Thread.sleep(2000);
		driver.findElement(By.id("continue")).click();
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-one.html");
		
	}
@AfterMethod
public void quit() {
	driver.quit();
}




}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
