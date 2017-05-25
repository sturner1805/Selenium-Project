package manualSeleniumTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
	
	private static WebDriver driver;
	
	@FindBy(xpath = "/html/body/section[2]/div/div[2]/div[1]/div/div/div[2]/div[3]/form/button")
	private WebElement mercuryOrder;
	
	public ProductsPage(WebDriver driver){
		ProductsPage.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOrderNow(){
		mercuryOrder.click();
	}
	
	public String getTitle(){
		return driver.getTitle();
	}
	
	public WebElement getMercuryOrder(){
		return mercuryOrder;
	}

}
