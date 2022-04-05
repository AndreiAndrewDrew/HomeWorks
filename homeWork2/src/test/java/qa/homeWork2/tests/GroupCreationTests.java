package qa.homeWork2.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import qa.homeWork2.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    //Create new group
    app.getNavigationHelper().gotoGroupPage();
    //int before = app.getGroupHelper().getGroupCount();
    List<GroupData> beforeCreation = app.getGroupHelper().getGroupList();
    GroupData group = new GroupData("TestNewGroup2", null, null);
    app.getGroupHelper().createGroup(group);
    //int after = app.getGroupHelper().getGroupCount();
    List<GroupData> afterCreation = app.getGroupHelper().getGroupList();
    Assert.assertEquals(afterCreation.size(), beforeCreation.size() + 1);

    group.setId(afterCreation.stream().max(Comparator.comparingInt(GroupData::id)).get().id());
    beforeCreation.add(group);
    Assert.assertEquals(new HashSet<Object>(afterCreation), new HashSet<Object>(beforeCreation));

  }
}

