package OST_TEST.OstTestPost;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import junit.framework.TestCase;





public class AppTest 
    extends TestCase
{
	public static WebDriver driver;
	public static String login ="stalin_i@tut.by";
	public static String pass = "Aa123456";
	
	@BeforeClass
	public void startDriver() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");	
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
	}
	@AfterClass
	public void stopDriver() {
		 driver.quit();
	}
	
	@Test(priority=1)
	public void openSource(){	
		try {
		driver.get("http://tut.by");
		Thread.sleep(2000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(priority=2)
	public void loginSource(){	
		try {
			driver.findElement(By.xpath("//div[@class='b-auth-i']//a")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='login']")).sendKeys(login);
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pass);
			driver.findElement(By.xpath("//input[@class='button auth__enter']")).submit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
	}
	
	@Test(priority=3)
	public void goToPOst(){	
		try {
		driver.findElement(By.xpath("//ul[@class='b-topbar-i']//a[contains(text(), 'Почта')]")).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(priority=4)
	public void howManyLetters(){	
		try {
			String numOfLetters = driver.findElement(By.xpath("//div[@data-params='fid=1']//span[@class='b-folders__folder__counters__total']")).getText();
			System.out.println(numOfLetters); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
