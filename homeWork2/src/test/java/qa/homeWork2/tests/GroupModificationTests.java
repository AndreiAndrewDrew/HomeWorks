package qa.homeWork2.tests;

import org.testng.annotations.Test;
import qa.homeWork2.model.GroupData;

public class GroupModificationTests extends TestBase {

  @Test
  public void testGroupModification(){

    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().selectedGroup();
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("Addnewtest", "test2", "test3modificat"));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnGroupPage();

  }
}
