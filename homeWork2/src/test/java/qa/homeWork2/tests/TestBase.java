package qa.homeWork2.tests;

import org.openqa.selenium.remote.BrowserType;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import qa.homeWork2.appmanager.ApplicationManager;

public class TestBase {

  protected ApplicationManager app = new ApplicationManager(BrowserType.FIREFOX);

  @BeforeMethod
  public void setUp() throws Exception {
    app.init();
  }

  @AfterMethod
  public void tearDown() {
    app.stop();
  }
}
