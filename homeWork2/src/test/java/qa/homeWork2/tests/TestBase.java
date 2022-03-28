package qa.homeWork2.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import qa.homeWork2.appmanager.ApplicationManager;

public class TestBase {

  protected ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

  @BeforeClass(alwaysRun = true)
  public void setUp() {
    app.init();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() {
    app.stop();
  }

}
