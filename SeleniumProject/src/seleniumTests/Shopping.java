package seleniumTests;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Shopping {
	
	private static WebDriver driver;
	
	@BeforeClass
	public void beforeClass(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Desktop\\Selenium\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
	driver.get("http://phptravels.com/");
	}
	
	
	@Test
	public void testLoad() {
		assertNotNull(driver.findElement(By.id("main-menu")));
	}
	
	@Before
	public void navToProductPage(){
		WebElement orderBtn = driver.findElement(By.id("main-menu"));
		orderBtn.click();
	}
	
	@Test
	public void testOrderLoad(){
		assertNotNull(driver.findElement(By.xpath("/html/body/section[2]/div/div[2]/div[1]/div/div/div[1]")));
	}

}
