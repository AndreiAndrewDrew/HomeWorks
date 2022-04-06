package qa.homeWork2.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import qa.homeWork2.model.GroupData;

import java.util.ArrayList;
import java.util.List;

public class GroupHelper extends HelperBase {

  public GroupHelper(WebDriver driver) {
    super(driver);

  }

  public void deleteSelectedGroup() {
    clickbuton(By.name("delete"));
  }

  public void selectedGroup(int index) {
    driver.findElements(By.name("selected[]")).get(index).click();
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
    returnGroupPage();
  }

  public void modify(int index, GroupData group) {
    selectedGroup(index);
    initGroupModification();
    fillGroupForm(group);
    submitGroupModification();
    returnGroupPage();
  }

  public void delete(int index) {
    selectedGroup(index);//selectat ultimul element din lista
    deleteSelectedGroup();
    returnGroupPage();
  }

  public List<GroupData> list() {
    List<GroupData> groups = new ArrayList<>();
    List<WebElement> elements = driver.findElements(By.cssSelector("span.group"));
    for (WebElement element : elements) {
      String name = element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      GroupData group = new GroupData(id, name, null, null);
      groups.add(group);
    }
    return groups;
  }
}

