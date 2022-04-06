package qa.homeWork2.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.homeWork2.model.GroupData;
import java.util.List;

public class GroupDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.group().list().size() == 0) {
      app.group().create(new GroupData("TestNewGroup", null, null));
    }
  }

  @Test
  public void testGroupDeletion() {

    List<GroupData> beforeDeletion = app.group().list();
    int index = beforeDeletion.size() - 1;
    app.group().delete(index);

    List<GroupData> afterDeletion = app.group().list();
    Assert.assertEquals(afterDeletion.size(), beforeDeletion.size()-1);
    beforeDeletion.remove(index);
    Assert.assertEquals(beforeDeletion,afterDeletion);
  }
}




