package qa.homeWork2.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.homeWork2.model.GroupData;
import qa.homeWork2.model.Groups;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.assertEquals;

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

    Groups beforeDeletion = app.group().all();
    GroupData deletedGroup = beforeDeletion.iterator().next();
    app.group().delete(deletedGroup);
    Groups afterDeletion = app.group().all();

    assertEquals(afterDeletion.size(), beforeDeletion.size()-1);
    assertThat(afterDeletion, equalTo(beforeDeletion.without(deletedGroup)));

  }
}




