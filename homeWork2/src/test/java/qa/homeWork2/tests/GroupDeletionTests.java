package qa.homeWork2.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.homeWork2.model.GroupData;
import qa.homeWork2.model.Groups;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;

public class GroupDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().groups().size()==0){
      app.goTo().groupPage();
      app.groupHelper().create(new GroupData().withName("NewGroup"));
    }
  }

  @Test
  public void testGroupDeletion() {

    Groups beforeDeletion = app.db().groups();
    GroupData deletedGroup = beforeDeletion.iterator().next();

    app.goTo().groupPage();
    app.groupHelper().delete(deletedGroup);

    assertThat(app.groupHelper().count(), equalTo(beforeDeletion.size()-1));
    Groups afterDeletion = app.db().groups();
    assertThat(afterDeletion, equalTo(beforeDeletion.without(deletedGroup)));
  }
}




