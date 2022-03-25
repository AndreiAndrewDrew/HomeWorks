package qa.homeWork2.tests;

import org.testng.annotations.Test;

public class DeletionGroupTests extends TestBase {

  @Test //inceput de test
  public void testGroupDeletion() {
    //Delete group
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().selectedGroup();
    app.getGroupHelper().deleteGroup();
    app.getGroupHelper().returnGroupPage();
  }

}




