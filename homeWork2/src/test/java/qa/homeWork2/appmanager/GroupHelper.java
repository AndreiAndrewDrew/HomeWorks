package qa.homeWork2.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import qa.homeWork2.model.GroupData;
import qa.homeWork2.model.Groups;

import java.util.List;

public class GroupHelper extends HelperBase {

  public GroupHelper(WebDriver driver) {
    super(driver);
  }

  public void deleteSelectedGroups() {
    clickbuton(By.name("delete"));
  }

  private void selectedGroupById(int id) {
    driver.findElement(By.cssSelector("input[value='" + id + "']")).click();
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

  public void create(GroupData group) {
    initGroupCreation();
    fillGroupForm(group);
    submitGroupCreation();
    groupsCache= null;
    returnGroupPage();
  }

  public void modify(GroupData group) {
    selectedGroupById(group.id());
    initGroupModification();
    fillGroupForm(group);
    submitGroupModification();
    groupsCache= null;
    returnGroupPage();
  }

  public void delete(GroupData group) {
    selectedGroupById(group.id());
    deleteSelectedGroups();
    groupsCache= null;
    returnGroupPage();
  }

  private Groups groupsCache = null;

  public Groups all() {
    if (groupsCache!=null) {
      return new Groups(groupsCache);
    }

    groupsCache = new Groups();
    List<WebElement> elements = driver.findElements(By.cssSelector("span.group"));
    for (WebElement element : elements) {
      String name = element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      groupsCache.add(new GroupData().withId(id).withName(name));
    }
    return new Groups(groupsCache);
  }
}

