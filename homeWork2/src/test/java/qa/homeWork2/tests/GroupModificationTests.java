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
    app.goTo().groupPage();
    if (app.groupHelper().all().size() == 0) {
      app.groupHelper().create(new GroupData().withName("NewGroup"));
    }
  }

  @Test
  public void testGroupModification() {

    Groups beforeModification = app.groupHelper().all();
    GroupData modifiedGroup = beforeModification.iterator().next();
    GroupData group = new GroupData()
            .withId(modifiedGroup.id()).withName("NameModification")
            .withHeader("HeaderModification").withFooter("FooterModification");
    app.groupHelper().modify(group);

    assertThat(app.groupHelper().count(), equalTo(beforeModification.size()));
    Groups afterModification = app.groupHelper().all();
    assertThat(afterModification, equalTo
            (beforeModification.without(modifiedGroup).withAdded(group)));
  }
}
