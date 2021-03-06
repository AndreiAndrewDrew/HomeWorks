package qa.mantis.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class ApplicationManager {

  private final Properties properties;

  protected WebDriver driver;

  private final StringBuffer verificationErrors = new StringBuffer();


  private final String browser;


  public ApplicationManager(String browser) {
    this.browser = browser;
    properties = new Properties();
  }

  public void init() throws IOException {
    String target = System.getProperty("target", "local");
    properties.load(new FileReader(new File(String
            .format("src/test/resources/%s.properties", target))));

    //cream conditie de alegere a browserului
    switch (browser) {
      case BrowserType.FIREFOX -> driver = new FirefoxDriver();
      case BrowserType.CHROME -> driver = new ChromeDriver();
      case BrowserType.EDGE -> driver = new EdgeDriver();
    }
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.get(properties.getProperty("web.baseUrl"));
  }

  public void stop() {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
}
