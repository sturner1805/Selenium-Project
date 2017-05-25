package manualSeleniumTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Registration {
	
	private static WebDriver driver;
	
	@FindBy(xpath = "//*[@id=\"inputFirstName\"]")
	private WebElement firstName;
	
	@FindBy(xpath = "//*[@id=\"inputLastName\"]")
	private WebElement lastName;
	
	@FindBy(xpath = "//*[@id=\"inputCompanyName\"]")
	private WebElement compName;
	
	@FindBy(xpath = "//*[@id=\"inputEmail\"]")
	private WebElement email;
	
	@FindBy(xpath = "//*[@id=\"inputPhone\"]")
	private WebElement phone;
	
	@FindBy(xpath = "//*[@id=\"inputAddress1\"]")
	private WebElement address1;
	
	@FindBy(xpath = "//*[@id=\"inputAddress2\"]")
	private WebElement address2;

	@FindBy(xpath = "//*[@id=\"inputCity\"]")
	private WebElement city;

	@FindBy(xpath = "//*[@id=\"stateinput\"]")
	private WebElement state;

	@FindBy(xpath = "//*[@id=\"inputPostcode\"]")
	private WebElement postcode;

	@FindBy(xpath = "//*[@id=\"inputCountry\"]")
	private WebElement country;

	public Registration(WebDriver driver){
		Registration.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterDetails(String x , WebElement e){
		e.clear();
		e.sendKeys(x);
	}
	
	public String getTitle(){
		return driver.getTitle();
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getCompName() {
		return compName;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPhone() {
		return phone;
	}

	public WebElement getAddress1() {
		return address1;
	}

	public WebElement getAddress2() {
		return address2;
	}

	public WebElement getCity() {
		return city;
	}

	public WebElement getState() {
		return state;
	}

	public WebElement getPostcode() {
		return postcode;
	}

	public WebElement getCountry() {
		return country;
	}

	
	
	
	
}
