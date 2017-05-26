package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
	
	private static WebDriver driver;
	
	@FindBy(xpath = "//*[@id=\"main-body\"]/div[1]/div[1]/div/h1")
	private WebElement header;
	
	@FindBy(xpath = "//*[@id=\"Secondary_Navbar-Account\"]/a")
	private WebElement helloSam;
	
	@FindBy(xpath = "//*[@id=\"Secondary_Navbar-Account-Logout\"]/a")
	private WebElement logoutBtn;
	
	public AccountPage(WebDriver driver){
		AccountPage.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickHelloSam(){
		helloSam.click();
	}
	
	public void clickLogout(){
		logoutBtn.click();
	}
	
	public String getTitle(){
		return driver.getTitle();
	}
	
	public WebElement getHeader(){
		return header;
	}
	
	public WebElement getHelloSam(){
		return helloSam;
	}
	
	public WebElement getLogout(){
		return logoutBtn;
	}
	

}
