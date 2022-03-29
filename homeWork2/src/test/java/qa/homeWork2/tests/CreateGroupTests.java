package qa.homeWork2.tests;

import org.testng.annotations.Test;
import qa.homeWork2.model.GroupData;

public class CreateGroupTests extends TestBase {

  @Test
  public void testGroupCreation() {
    //Create new group
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().createGroup(new GroupData("Addnewtest44", null, null));
  }
}

