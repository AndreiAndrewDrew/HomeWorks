package qa.homeWork2.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import qa.homeWork2.model.GroupData;

import java.util.List;

public class GroupDeletionTests extends TestBase {

  @Test
  public void testGroupDeletion() {

    app.getNavigationHelper().gotoGroupPage();
    if (!app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("Addnewtest44", null, null));
    }

    List<GroupData> beforeDeletion = app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectedGroup(beforeDeletion.size() - 1);//selectat ultimul element din lista
    app.getGroupHelper().deleteGroup();
    app.getGroupHelper().returnGroupPage();

    List<GroupData> afterDeletion = app.getGroupHelper().getGroupList();

    Assert.assertEquals(afterDeletion.size(), beforeDeletion.size() - 1);

    beforeDeletion.remove(beforeDeletion.size() - 1);

    Assert.assertEquals(beforeDeletion,afterDeletion);
  }

}




