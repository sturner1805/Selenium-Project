package manualSeleniumTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCart {

	private static WebDriver driver;
	
	@FindBy(xpath = "//*[@id=\"order-boxes\"]/div[2]/div[2]/form/button")
	private WebElement checkout;
	
	public ShoppingCart(WebDriver driver){
		ShoppingCart.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickCheckout(){
		checkout.submit();
	}
	
	public String getTitle(){
		return driver.getTitle();
	}
	
	public WebElement getCheckout(){
		return checkout;
	}
}
