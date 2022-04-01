package qa.homeWork2.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import qa.homeWork2.model.GroupData;

public class GroupHelper extends HelperBase {

  public GroupHelper(WebDriver driver) {
    super(driver);

  }

  public void deleteGroup() {
    clickbuton(By.name("delete"));
  }

  public void selectedGroup() {
    clickbuton(By.name("selected[]"));
  }

  public void returnGroupPage() {
    clickbuton(By.linkText("group page"));
  }

  public void submitGroupCreation() {
    clickbuton(By.name("submit"));
  }

  public void fillGroupForm(GroupData groupData) {
    type(By.name("group_name"), groupData.name());
    type(By.name("group_header"), groupData.header());
    type(By.name("group_footer"), groupData.footer());
  }

  public void initGroupCreation() {
    clickbuton(By.name("new"));
  }

  public void initGroupModification() {
    clickbuton(By.name("edit"));
  }

  public void submitGroupModification() {
    clickbuton(By.name("update"));
  }

  public void createGroup(GroupData group) {
    initGroupCreation();
    fillGroupForm(group);
    submitGroupCreation();
    returnGroupPage();
  }

  public boolean isThereAGroup() {
    return isElementPresent(By.name("selected[]"));

  }

  public int getGroupCount() {
    return driver.findElements(By.name("selected[]")).size();
  }
}

