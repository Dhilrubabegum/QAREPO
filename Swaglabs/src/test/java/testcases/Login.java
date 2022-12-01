package testcases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Login {
	public WebDriver driver;
	@BeforeMethod
	public void launch() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\dbegum01\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");	//Tc_SL_001
		
		
	}
	@Test(dataProvider = "login")
	public void Tc_SL_004to009(String username, String pass) {

		
		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(pass);
		driver.findElement(By.id("login-button")).click();
		WebElement e=driver.findElement(By.xpath("//div[@class='error-message-container error']"));
		String error=e.getText();
		System.out.println(error);
	}
	@DataProvider(name = "login")
	public String[][] getdata() {
		String[][] data = new String[6][2];
	
		data[0][0] = "standard_user"; 	// Tc_SL_004
		data[0][1] = "secretsauce";

		data[1][0] = "standarduser"; 	// Tc_SL_005
		data[1][1] = "secret_sauce";	

		data[2][0] = "standarduser";	 // Tc_SL_006
		data[2][1] = "secretsauce";

		data[3][0] = "";				 // Tc_SL_007
		data[3][1] = "";

		data[4][0] = "standard_user";	 // Tc_SL_008
		data[4][1] = "";

		data[5][0] = ""; 				// Tc_SL_009
		data[5][1] = "secretsauce";

		return data;
	}

	@AfterMethod
	public void quit() {
		driver.quit();					//Tc_SL_002
	}
	}

