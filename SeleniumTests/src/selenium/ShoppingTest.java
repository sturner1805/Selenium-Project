package selenium;
import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Desktop\\SeleniumProject\\SeleniumJars\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		driver = new ChromeDriver( options );
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
		jse.executeScript("scroll(0, 1000);");
		waitUntilElementPresent("/html/body/section[2]/div/div[2]/div[1]/div/div/div[2]/div[3]/form/button" , 15);
		products.clickOrderNow();
		

		for (String winHandle : driver.getWindowHandles()) { 
	        driver.switchTo().window(winHandle);        
	    }
		cart = new ShoppingCart(driver);
		String shoppingCartTitle = cart.getTitle();
		assertEquals(shoppingCartTitle, "Shopping Cart - PHPTRAVELS");
		assertNotNull(cart.getCheckout());
		cart.clickCheckout();
		driver.findElement(By.xpath("//*[@id=\"signupContainer\"]/div[1]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"inputLoginEmail\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"inputLoginEmail\"]")).sendKeys("sam1@email.com");
		driver.findElement(By.xpath("//*[@id=\"inputLoginPassword\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"inputLoginPassword\"]")).sendKeys("123abd<>?ABC");
		driver.findElement(By.xpath("//*[@id=\"btnCompleteOrder\"]")).click(); // claiming incorrect username/password.	
		
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


