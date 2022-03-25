package qa.homeWork2.tests;

import org.testng.annotations.Test;
import qa.homeWork2.model.GroupData;

public class CreateGroupTests extends TestBase {

  @Test
  public void testGroupCreation() {
    //Create new group
    app.gotoGroupPage();
    app.initGroupCreation();
    app.fillGroupForm(new GroupData("Addnewtest3", "test2", "test3"));
    app.submitGroupCreation();
    app.returnGroupPage();
  }

}

