package qa.homeWork2.tests;

import org.testng.annotations.Test;
import qa.homeWork2.model.GroupData;
import qa.homeWork2.model.Groups;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {

    app.goTo().groupPage();
    Groups beforeCreation = app.groupHelper().all();
    GroupData group = new GroupData().withName("TestNewGroup2");
    app.groupHelper().create(group);

    assertThat(app.groupHelper().count(), equalTo(beforeCreation.size() + 1));
    Groups afterCreation = app.groupHelper().all();
    assertThat(afterCreation, equalTo
            (beforeCreation.withAdded(group.withId(afterCreation.stream().mapToInt((g)->g.id()).max().getAsInt()))));
  }

  @Test
  public void testBadGroupCreation() {

    app.goTo().groupPage();
    Groups beforeCreation = app.groupHelper().all();
    GroupData group = new GroupData().withName("TestNewGroup2'@@$@");
    app.groupHelper().create(group);

    assertThat(app.groupHelper().count(), equalTo(beforeCreation.size()));
    Groups afterCreation = app.groupHelper().all();
    assertThat(afterCreation, equalTo(beforeCreation));
  }
}
