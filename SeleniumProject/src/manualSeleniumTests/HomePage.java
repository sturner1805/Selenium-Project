package manualSeleniumTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//*[@id=\"main-menu\"]/ul/li[2]/span/span/a") //*[@id="main-menu"]/ul/li[2]/span/span/a
	private WebElement orderBtn;
	
	

	public HomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOrderBtn(){
		driver.get(orderBtn.getAttribute("href"));
	}
	
	public String getTitle(){
		return driver.getTitle();
	}
	
	public WebElement getOrderBtn() {
		return orderBtn;
	}
}
