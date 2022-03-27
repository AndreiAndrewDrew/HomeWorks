package qa.homeWork2.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperBase {

  protected WebDriver driver;

  public HelperBase(WebDriver driver) {
    this.driver = driver;
  }

  protected void clickbuton(By locator) {
    driver.findElement(locator).click();
  }

  protected void type(By locator, String text) {
    clickbuton(locator);
    if (text != null) {
      driver.findElement(locator).clear();
      driver.findElement(locator).sendKeys(text);
    }

  }
}

