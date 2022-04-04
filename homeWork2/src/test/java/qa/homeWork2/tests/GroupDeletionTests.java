package qa.homeWork2.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import qa.homeWork2.model.GroupData;

import java.util.List;

public class GroupDeletionTests extends TestBase {

  @Test //inceput de test
  public void testGroupDeletion() {
    //Delete group
    app.getNavigationHelper().gotoGroupPage();

    if (!app.getGroupHelper().isThereAGroup()) {

      app.getGroupHelper().createGroup(new GroupData("Addnewtest44", null, null));

    }
    //int before = app.getGroupHelper().getGroupCount();
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectedGroup(before.size() - 1);
    app.getGroupHelper().deleteGroup();
    app.getGroupHelper().returnGroupPage();
    //int after = app.getGroupHelper().getGroupCount();
    List<GroupData> after = app.getGroupHelper().getGroupList();

    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size() - 1);
    /*for (int i = 0; i < after.size(); i++) {
      Assert.assertEquals(before.get(i),after.get(i));
    }*/
    Assert.assertEquals(before,after);
  }

}




