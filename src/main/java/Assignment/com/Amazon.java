package Assignment.com;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

		
public class Amazon {
			WebDriver driver;
			SoftAssert soft = new SoftAssert();

			@BeforeMethod
			public void Logintoapp() throws InterruptedException {

				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				
				driver.get("https://www.amazon.in/");
				driver.manage().window().maximize();

			}
			
			@Test
			public void checkAccesibility() {
				driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone");
//				driver.findElement(By.xpath(
//						"(//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal'])[1]"))
//						.click();
				driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
				ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
				driver.switchTo().window(tabs.get(1));

				String price = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
				System.out.println("Price of the element is " +price);
				driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
				driver.findElement(By.xpath("//span[@id='attach-sidesheet-checkout-button']")).click();
				driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys("8329337746");
				driver.findElement(By.xpath("//input[@id='continue']")).click();
				driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys("abc");
				driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
			
			}

			@AfterMethod
			public void logout() {
				driver.quit();
			}

}

	
