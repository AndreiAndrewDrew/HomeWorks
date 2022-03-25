package qa.homeWork2;

import org.testng.annotations.Test;

public class DeletionGroupTests extends TestBase {

  @Test //inceput de test
  public void testGroupDeletion() {
    //Delete group
    gotoGroupPage();
    selectedGroup();
    deleteGroup();
    returnGroupPage();
  }

}




