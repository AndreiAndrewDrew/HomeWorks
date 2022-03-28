package qa.homeWork2.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

  public NavigationHelper(WebDriver driver) {

    super(driver);
  }

  public void gotoGroupPage() {
    clickbuton(By.linkText("groups"));
  }

  public void gotoHomePage() {
    clickbuton(By.linkText("home"));
  }


}
