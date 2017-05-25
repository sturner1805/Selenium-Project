package selenium;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationTest {
	
	private static WebDriver driver;
	private static HomePage home;
	private static LoginPage login;
	private StringBuffer verificationErrors = new StringBuffer();
	private static RegistrationPage form;

	@Before
	public void beforeClass(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sam\\Desktop\\SeleniumProject\\SeleniumTests\\SeleniumJars\\chromedriver.exe");
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
		
		for (String winHandle : driver.getWindowHandles()) { 
	        driver.switchTo().window(winHandle);        
	    }
		login = new LoginPage(driver);
		String LoginPageTitle = login.getTitle();
		assertEquals(LoginPageTitle, "Client Area - PHPTRAVELS");
		assertNotNull(login.getAccountBtn());
		login.clickAccountBtn();
		assertNotNull(login.getRegBtn());
		login.clickRegBtn();
		
		form = new RegistrationPage(driver);
		String regTitle = form.getTitle();
		assertEquals(regTitle, "Register - PHPTRAVELS");
		form.enterDetails("Sam", form.getFirstName());
		form.enterDetails("Turner", form.getLastName());
		form.enterDetails("QA", form.getCompName());
		form.enterDetails("sam1@email.com", form.getEmail());
		form.enterDetails("12345678912", form.getPhone());
		form.enterDetails("1 Road", form.getAddress1());
		form.enterDetails("Village", form.getAddress2());
		form.enterDetails("City", form.getCity());
		form.enterDetails("County", form.getState());
		form.enterDetails("ab12 3cd", form.getPostcode());
		form.getCountry().findElement(By.cssSelector("option[value=\"GB\"]")).click();
		form.getHowFound().findElement(By.cssSelector("option[value=\"Friend\"]")).click();
		form.enterDetails("12121212121", form.getMobile());
		form.enterDetails("123abd<>?ABC", form.getPassword());
		form.enterDetails("123abd<>?ABC", form.getConfirmPassword());
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
    }
  }
	
	private void waitUntilElementPresent(String e, int timeout){
		  WebDriverWait wait = new WebDriverWait(driver, timeout);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(e)));
	}

}
