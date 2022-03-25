package qa.homeWork2.tests;

import org.testng.annotations.Test;

public class DeletionGroupTests extends TestBase {

  @Test //inceput de test
  public void testGroupDeletion() {
    //Delete group
    app.gotoGroupPage();
    app.selectedGroup();
    app.deleteGroup();
    app.returnGroupPage();
  }

}




