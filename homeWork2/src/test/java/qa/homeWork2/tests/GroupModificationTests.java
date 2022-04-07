package qa.homeWork2.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.homeWork2.model.GroupData;
import qa.homeWork2.model.Groups;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.group().all().size() == 0) {
      app.group().create(new GroupData().withName("NewGroup"));
    }
  }

  @Test
  public void testGroupModification() {

    Groups beforeModification = app.group().all();
    GroupData modifiedGroup = beforeModification.iterator().next();
    GroupData group = new GroupData()
            .withId(modifiedGroup.id()).withName("NameModification")
            .withHeader("HeaderModification").withFooter("FooterModification");
    app.group().modify(group);

    assertThat(app.group().count(), equalTo(beforeModification.size()));
    Groups afterModification = app.group().all();
    assertThat(afterModification, equalTo
            (beforeModification.without(modifiedGroup).withAdded(group)));
  }
}
