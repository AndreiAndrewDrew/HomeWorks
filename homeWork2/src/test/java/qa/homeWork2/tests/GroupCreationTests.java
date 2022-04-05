package qa.homeWork2.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import qa.homeWork2.model.GroupData;

import java.util.List;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    //Create new group
    app.getNavigationHelper().gotoGroupPage();
    //int before = app.getGroupHelper().getGroupCount();
    List<GroupData> beforeCreation = app.getGroupHelper().getGroupList();
    app.getGroupHelper().createGroup(new GroupData("Addnewtest44", null, null));
    //int after = app.getGroupHelper().getGroupCount();
    List<GroupData> afterCreation = app.getGroupHelper().getGroupList();
    Assert.assertEquals(afterCreation.size(), beforeCreation.size() + 1);
  }
}

