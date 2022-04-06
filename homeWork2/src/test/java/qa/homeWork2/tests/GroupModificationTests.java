package qa.homeWork2.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import qa.homeWork2.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class GroupModificationTests extends TestBase {

  @Test
  public void testGroupModification() {

    app.getNavigationHelper().gotoGroupPage();

    if (!app.getGroupHelper().isThereAGroup()) {

      app.getGroupHelper().createGroup(new GroupData("TestNewGroup", null, null));

    }
    //int before = app.getGroupHelper().getGroupCount();
    List<GroupData> beforeModification = app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectedGroup(beforeModification.size() - 1);
    app.getGroupHelper().initGroupModification();
    GroupData group = new GroupData(beforeModification.get
            (beforeModification.size() - 1).id()/*pastram id vechi de la grupa modificata*/
            , "TestModification2", "test2modificat", "test3modificat");
    app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnGroupPage();
    //int after = app.getGroupHelper().getGroupCount();
    List<GroupData> afterModification = app.getGroupHelper().getGroupList();
    Assert.assertEquals(afterModification.size(), beforeModification.size());//comparam marimea listelor


    beforeModification.remove(beforeModification.size() - 1);
    beforeModification.add(group);

    Comparator<? super GroupData> byId = Comparator.comparingInt(GroupData::id);
    beforeModification.sort(byId);
    afterModification.sort(byId);

    Assert.assertEquals(afterModification, beforeModification);

  }
}
