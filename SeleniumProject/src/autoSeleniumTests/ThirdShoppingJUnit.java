package autoSeleniumTests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ThirdShoppingJUnit {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	System.setProperty("webdriver.gecko.driver", "C:\\Users\\Administrator\\Desktop\\Selenium\\Selenium\\geckodriver.exe");
    driver = new FirefoxDriver();
    baseUrl = "http://phptravels.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testThirdShoppingJUnit() throws Exception {
    driver.get(baseUrl + "/demo/");
    driver.findElement(By.linkText("Order")).click();
    driver.findElement(By.xpath("//form/button")).click();
//    driver.switchTo().frame(1);
//    driver.findElement(By.xpath("/html/body/section[3]/div[1]/div/div/div[2]/div[2]/form/button")).click();
    driver.findElement(By.id("firstname")).click();
    driver.findElement(By.id("inputFirstName")).clear();
    driver.findElement(By.id("inputFirstName")).sendKeys("Sam");
    driver.findElement(By.id("inputLastName")).clear();
    driver.findElement(By.id("inputLastName")).sendKeys("Smith");
    driver.findElement(By.id("inputCompanyName")).clear();
    driver.findElement(By.id("inputCompanyName")).sendKeys("Goat");
    driver.findElement(By.id("inputEmail")).clear();
    driver.findElement(By.id("inputEmail")).sendKeys("sam@email.com");
    driver.findElement(By.id("inputPhone")).clear();
    driver.findElement(By.id("inputPhone")).sendKeys("12345678912");
    driver.findElement(By.id("inputAddress1")).clear();
    driver.findElement(By.id("inputAddress1")).sendKeys("1 road");
    driver.findElement(By.id("inputCity")).clear();
    driver.findElement(By.id("inputCity")).sendKeys("Big City");
    driver.findElement(By.id("stateinput")).clear();
    driver.findElement(By.id("stateinput")).sendKeys("Small County");
    driver.findElement(By.id("inputPostcode")).clear();
    driver.findElement(By.id("inputPostcode")).sendKeys("AB12 3CD");
    driver.findElement(By.id("inputCountry")).click();
    driver.findElement(By.cssSelector("option[value=\"AF\"]")).click();
    driver.findElement(By.id("customfield2")).click();
    driver.findElement(By.id("customfield2")).clear();
    driver.findElement(By.id("customfield2")).sendKeys("12121212121");
    driver.findElement(By.id("inputNewPassword1")).click();
    driver.findElement(By.id("inputNewPassword1")).clear();
    driver.findElement(By.id("inputNewPassword1")).sendKeys("junit");
    driver.findElement(By.id("inputNewPassword2")).click();
    driver.findElement(By.id("inputNewPassword2")).clear();
    driver.findElement(By.id("inputNewPassword2")).sendKeys("junit");
    driver.findElement(By.id("btnCompleteOrder")).click();
    driver.findElement(By.id("inputEmail")).click();
    driver.findElement(By.id("inputEmail")).clear();
    driver.findElement(By.id("inputEmail")).sendKeys("junit@email.com");
    driver.findElement(By.id("inputNewPassword1")).click();
    driver.findElement(By.id("inputNewPassword1")).clear();
    driver.findElement(By.id("inputNewPassword1")).sendKeys("JUnit#1");
    driver.findElement(By.id("inputNewPassword2")).click();
    driver.findElement(By.id("inputNewPassword2")).clear();
    driver.findElement(By.id("inputNewPassword2")).sendKeys("JUnit#1");
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
}
