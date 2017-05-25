package selenium;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrationTest {
	
	private static WebDriver driver;
	private static HomePage home;

	@Before
	public void beforeClass(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Desktop\\Selenium\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://phptravels.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test
	public void regTest(){
		home = new HomePage(driver);
		String homePageTitle = home.getTitle();
		assertEquals(homePageTitle, "PHPTRAVELS | PHP Hotels Script tours vacations and cars booking online application");
		assertNotNull(home.getPadlock());
		home.clickPadlock();
	}

}
