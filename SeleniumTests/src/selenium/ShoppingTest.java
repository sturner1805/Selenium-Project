package selenium;
import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingTest {
	
	private static WebDriver driver;
	HomePage home;
	ProductsPage products;
	ShoppingCart cart;
	RegistrationPage form;
	private StringBuffer verificationErrors = new StringBuffer();
	
	@Before
	public void beforeClass(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Desktop\\Selenium-Project\\SeleniumJars\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://phptravels.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	
	@Test
	public void shoppingTest() {
		home = new HomePage(driver);
		String homePageTitle = home.getTitle();
		assertEquals(homePageTitle, "PHPTRAVELS | PHP Hotels Script tours vacations and cars booking online application");
		assertNotNull(home.getOrderBtn());
		home.clickOrderBtn();
		
		products = new ProductsPage(driver);
		String productsPageTitle = products.getTitle();
		assertEquals(productsPageTitle, "PHPTRAVELS | Order");
		assertNotNull(products.getMercuryOrder());
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0, 550);");
		waitUntilElementPresent("/html/body/section[2]/div/div[2]/div[1]/div/div/div[2]/div[3]/form/button" , 15);
		products.clickOrderNow();
		

		for (String winHandle : driver.getWindowHandles()) { 
	        driver.switchTo().window(winHandle);        
	    }
		cart = new ShoppingCart(driver);
		String shoppingCartTitle = cart.getTitle();
		assertEquals(shoppingCartTitle, "Shopping Cart - PHPTRAVELS");
		assertNotNull(cart.getCheckout());
		waitUntilElementPresent("//*[@id=\"order-boxes\"]/div[2]/div[2]/form/button" , 15);
		cart.clickCheckout();
		
		form = new RegistrationPage(driver);
		String regTitle = form.getTitle();
		assertEquals(regTitle, "Shopping Cart - PHPTRAVELS");
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
		form.getPaymentMethod().click();
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


