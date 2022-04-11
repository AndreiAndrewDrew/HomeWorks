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
    if (app.groupHelper().all().size() == 0) {
      app.groupHelper().create(new GroupData().withName("NewGroup"));
    }
  }

  @Test
  public void testGroupDeletion() {

    Groups beforeDeletion = app.groupHelper().all();
    GroupData deletedGroup = beforeDeletion.iterator().next();
    app.groupHelper().delete(deletedGroup);

    assertThat(app.groupHelper().count(), equalTo(beforeDeletion.size()-1));
    Groups afterDeletion = app.groupHelper().all();
    assertThat(afterDeletion, equalTo(beforeDeletion.without(deletedGroup)));

  }
}




