package qa.homeWork2;

import org.testng.annotations.Test;

public class CreateGroupTests extends TestBase {

  @Test
  public void testGroupCreation() {
    //Create new group
    gotoGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupData("Addnew test1", "test2", "test3"));
    submitGroupCreation();
    returnGroupPage();
  }

}

