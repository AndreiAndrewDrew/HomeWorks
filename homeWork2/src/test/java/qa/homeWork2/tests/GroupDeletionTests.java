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
    List<GroupData> beforeDeletion = app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectedGroup(beforeDeletion.size() - 1);//selectat ultimul element din lista
    app.getGroupHelper().deleteGroup();
    app.getGroupHelper().returnGroupPage();
    //int after = app.getGroupHelper().getGroupCount();
    List<GroupData> afterDeletion = app.getGroupHelper().getGroupList();

    Assert.assertEquals(afterDeletion.size(), beforeDeletion.size() - 1);

    beforeDeletion.remove(beforeDeletion.size() - 1);
    Assert.assertEquals(beforeDeletion,afterDeletion);
  }

}




