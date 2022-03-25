package qa.homeWork2.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import qa.homeWork2.model.GroupData;

public class GroupHelper {

  private WebDriver driver;

  public GroupHelper(WebDriver driver) {
    this.driver = driver;

  }

  public void deleteGroup() {
    driver.findElement(By.name("delete")).click();
  }

  public void selectedGroup() {
    driver.findElement(By.xpath("//div[@id='content']/form/span[4]/input")).click();
  }

  public void returnGroupPage() {
    driver.findElement(By.linkText("group page")).click();
  }

  public void submitGroupCreation() {
    driver.findElement(By.name("submit")).click();
  }

  public void fillGroupForm(GroupData groupData) {
    driver.findElement(By.name("group_name")).click();
    driver.findElement(By.name("group_name")).clear();
    driver.findElement(By.name("group_name")).sendKeys(groupData.name());
    driver.findElement(By.name("group_header")).click();
    driver.findElement(By.name("group_header")).clear();
    driver.findElement(By.name("group_header")).sendKeys(groupData.header());
    driver.findElement(By.name("group_footer")).click();
    driver.findElement(By.name("group_footer")).clear();
    driver.findElement(By.name("group_footer")).sendKeys(groupData.footer());
  }

  public void initGroupCreation() {
    driver.findElement(By.name("new")).click();
  }
}
