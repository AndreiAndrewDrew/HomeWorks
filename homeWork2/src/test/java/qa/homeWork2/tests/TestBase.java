package qa.homeWork2.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import qa.homeWork2.appmanager.ApplicationManager;

public class TestBase {

  protected final ApplicationManager app = new ApplicationManager();

  @BeforeClass(alwaysRun = true)
  public void setUp() {
    app.init();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() {
    app.stop();
  }

}
