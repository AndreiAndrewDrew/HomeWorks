package qa.homeWork2.tests;

import org.testng.annotations.Test;
import qa.homeWork2.model.GroupData;

public class GroupDeletionTests extends TestBase {

  @Test //inceput de test
  public void testGroupDeletion() {
    //Delete group
    app.getNavigationHelper().gotoGroupPage();
    if (! app.getGroupHelper().isThereAGroup()){

      app.getGroupHelper().createGroup(new GroupData("Addnewtest44", null, null));

    }
    app.getGroupHelper().selectedGroup();
    app.getGroupHelper().deleteGroup();
    app.getGroupHelper().returnGroupPage();
  }

}




