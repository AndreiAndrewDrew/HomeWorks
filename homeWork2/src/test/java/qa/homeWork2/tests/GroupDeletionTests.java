package qa.homeWork2.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import qa.homeWork2.model.GroupData;

public class GroupDeletionTests extends TestBase {

  @Test //inceput de test
  public void testGroupDeletion() {
    //Delete group
    app.getNavigationHelper().gotoGroupPage();
    int before = app.getGroupHelper().getGroupCount();
    if (! app.getGroupHelper().isThereAGroup()){

      app.getGroupHelper().createGroup(new GroupData("Addnewtest44", null, null));

    }
    app.getGroupHelper().selectedGroup();
    app.getGroupHelper().deleteGroup();
    app.getGroupHelper().returnGroupPage();
    int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after, before -1);
  }

}




