package autoSeleniumTests;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenJUnitShopping {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Desktop\\Selenium\\Selenium\\chromedriver.exe");
    driver = new ChromeDriver();
    baseUrl = "http://phptravels.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testGenJUnitShopping() throws Exception {
    driver.get(baseUrl + "/demo/");
    driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/span")).click();
//    driver.findElement(By.xpath("(//a[contains(text(),'Integrations')])[3]")).click();
//    driver.findElement(By.xpath("//div[2]/div/div/div[2]/div[3]/form/button")).click();
    waitUntilElementPresent("/html/body/section[2]/div/div[2]/div[2]/div/div/div[2]/div[3]/form/button", 10);
    driver.findElement(By.xpath("/html/body/section[2]/div/div[2]/div[2]/div/div/div[2]/div[3]/form/button")).click();
    
//    String formWindow = driver.getWindowHandle();
//    driver.switchTo().window(formWindow);
//    driver.switchTo().defaultContent();
//    Actions action = new Actions (driver);
    //driver.switchTo().frame(0);
    //driver.switchTo().defaultContent();
   // driver.switchTo().frame(1);
//    
   // driver.findElement(By.id("firstname")).click(); 
//     driver.getWindowHandle();
     
    driver.findElement(By.id("firstname")).clear();
    driver.findElement(By.id("firstname")).sendKeys("Sam");
    driver.findElement(By.id("inputLastName")).clear();
    driver.findElement(By.id("inputLastName")).sendKeys("Smith");
    driver.findElement(By.id("inputCompanyName")).clear();
    driver.findElement(By.id("inputCompanyName")).sendKeys("Goat");
    driver.findElement(By.id("inputEmail")).clear();
    driver.findElement(By.id("inputEmail")).sendKeys("sam@email.com");
    driver.findElement(By.id("inputPhone")).clear();
    driver.findElement(By.id("inputPhone")).sendKeys("12345678912");
    driver.findElement(By.id("inputAddress1")).clear();
    driver.findElement(By.id("inputAddress1")).sendKeys("1");
    driver.findElement(By.id("inputAddress1")).click();
    driver.findElement(By.id("inputAddress1")).clear();
    driver.findElement(By.id("inputAddress1")).sendKeys("1 road");
    driver.findElement(By.id("inputCity")).clear();
    driver.findElement(By.id("inputCity")).sendKeys("Big City");
    driver.findElement(By.id("stateinput")).clear();
    driver.findElement(By.id("stateinput")).sendKeys("Small County");
    driver.findElement(By.id("inputPostcode")).clear();
    driver.findElement(By.id("inputPostcode")).sendKeys("AB12 3CD");
    driver.findElement(By.id("inputCountry")).click();
    new Select(driver.findElement(By.id("inputCountry"))).selectByVisibleText("Zimbabwe");
    driver.findElement(By.cssSelector("option[value=\"ZW\"]")).click();
    driver.findElement(By.cssSelector("body")).click();
    driver.findElement(By.id("customfield1")).click();
    new Select(driver.findElement(By.id("customfield1"))).selectByVisibleText("Friend");
    driver.findElement(By.cssSelector("option[value=\"Friend\"]")).click();
    driver.findElement(By.id("customfield2")).click();
    driver.findElement(By.id("customfield2")).clear();
    driver.findElement(By.id("customfield2")).sendKeys("12121212121");
    driver.findElement(By.id("inputNewPassword1")).click();
    driver.findElement(By.id("inputNewPassword1")).clear();
    driver.findElement(By.id("inputNewPassword1")).sendKeys("abC123@@@");
    driver.findElement(By.id("inputNewPassword2")).click();
    driver.findElement(By.id("inputNewPassword2")).clear();
    driver.findElement(By.id("inputNewPassword2")).sendKeys("abC123@@@");
    driver.findElement(By.id("btnCompleteOrder")).click();
    driver.findElement(By.linkText("Print")).click();
    driver.findElement(By.linkText("« Back to Client Area")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
  
  private void waitUntilElementPresent(String e, int timeout){
	  WebDriverWait wait = new WebDriverWait(driver, timeout);
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(e)));
  }
}
