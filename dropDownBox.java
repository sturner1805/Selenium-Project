package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownBox {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://phptravels.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testDropDownBox() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.linkText("Order")).click();
    driver.findElement(By.xpath("//form/button")).click();
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    driver.findElement(By.id("customfield2")).clear();
    driver.findElement(By.id("customfield2")).sendKeys("12121212121");
    driver.findElement(By.id("inputNewPassword1")).clear();
    driver.findElement(By.id("inputNewPassword1")).sendKeys("JUnit#1");
    driver.findElement(By.id("inputCountry")).click();
    new Select(driver.findElement(By.id("inputCountry"))).selectByVisibleText("United Kingdom");
    driver.findElement(By.cssSelector("option[value=\"GB\"]")).click();
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
