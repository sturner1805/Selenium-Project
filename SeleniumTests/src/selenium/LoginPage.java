package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	private static WebDriver driver;
	
	@FindBy(xpath = "//*[@id=\"Secondary_Navbar-Account\"]/a")
	private WebElement accountBtn;
	
	@FindBy(xpath = "//*[@id=\"Secondary_Navbar-Account-Login\"]/a")
	private WebElement loginBtn;
	
	@FindBy(xpath = "//*[@id=\"Secondary_Navbar-Account-Register\"]/a")
	private WebElement regBtn;
	
	@FindBy(xpath = "//*[@id=\"inputEmail\"]")
	private WebElement email;
	
	@FindBy(xpath = "//*[@id=\"inputPassword\"]")
	private WebElement password;
	
	@FindBy(xpath ="//*[@id=\"login\"]")
	private WebElement submitBtn;
	
	public LoginPage(WebDriver driver){
		LoginPage.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterDetails(String x , WebElement e){
		e.clear();
		e.sendKeys(x);
	}
	
	public void clickAccountBtn(){
		accountBtn.click();
	}
	
	public void clickLoginBtn(){
		loginBtn.click();
	}
	
	public void clickRegBtn(){
		regBtn.click();
	}
	
	public void clickSubmit(){
		submitBtn.click();
	}
	
	public String getTitle(){
		return driver.getTitle();
	}
	
	public WebElement getAccountBtn(){
		return accountBtn;
	}
	
	public WebElement getLoginBtn(){
		return loginBtn;
	}
	
	public WebElement getRegBtn(){
		return regBtn;
	}
	
	public WebElement getEmail(){
		return email;
	}
	
	public WebElement getPassword(){
		return password;
	}
	
	public WebElement getSubmit(){
		return submitBtn;
	}

}
