package qa.homeWork2.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.homeWork2.model.GroupData;
import java.util.Set;

public class GroupDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.group().all().size() == 0) {
      app.group().create(new GroupData().withName("NewGroup"));
    }
  }

  @Test
  public void testGroupDeletion() {

    Set<GroupData> beforeDeletion = app.group().all();
    GroupData deletedGroup = beforeDeletion.iterator().next();
    app.group().delete(deletedGroup);

    Set<GroupData> afterDeletion = app.group().all();
    Assert.assertEquals(afterDeletion.size(), beforeDeletion.size()-1);
    beforeDeletion.remove(deletedGroup);
    Assert.assertEquals(beforeDeletion,afterDeletion);
  }
}




