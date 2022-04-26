package qa.homeWork2.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.homeWork2.model.GroupData;
import qa.homeWork2.model.Groups;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().groups().size()==0){
      app.goTo().groupPage();
      app.groupHelper().create(new GroupData().withName("NewGroup"));
    }
  }

  @Test
  public void testGroupModification() {

    Groups beforeModification = app.db().groups();
    GroupData modifiedGroup = beforeModification.iterator().next();
    GroupData group = new GroupData()
            .withId(modifiedGroup.id()).withName("NameModification")
            .withHeader("HeaderModification").withFooter("FooterModification");
    app.goTo().groupPage();
    app.groupHelper().modify(group);

    assertThat(app.groupHelper().count(), equalTo(beforeModification.size()));
    Groups afterModification = app.db().groups();
    assertThat(afterModification, equalTo
            (beforeModification.without(modifiedGroup).withAdded(group)));
  }
}
