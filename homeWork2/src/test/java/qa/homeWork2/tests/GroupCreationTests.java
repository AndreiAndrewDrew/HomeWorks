package qa.homeWork2.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import qa.homeWork2.model.GroupData;
import qa.homeWork2.model.Groups;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;

public class GroupCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validGroups(){
    List<Object[]> list = new ArrayList<Object[]>();
    list.add(new Object[] {new GroupData().withName("NameGroup 1").withHeader("headear 1")
            .withFooter("footer 1")});
    list.add(new Object[] {new GroupData().withName("NameGroup 2").withHeader("headear 2")
            .withFooter("footer 2")});
    list.add(new Object[] {new GroupData().withName("NameGroup 3").withHeader("headear 3")
            .withFooter("footer 3")});
    return list.iterator();
  }

  @Test(dataProvider = "validGroups")
  public void testGroupCreation(GroupData group) {
    app.goTo().groupPage();
    Groups beforeCreation = app.groupHelper().all();
    app.groupHelper().create(group);
    assertThat(app.groupHelper().count(), equalTo(beforeCreation.size() + 1));
    Groups afterCreation = app.groupHelper().all();
    assertThat(afterCreation, equalTo
            (beforeCreation.withAdded(group.withId(afterCreation.stream()
                    .mapToInt((g)->g.id()).max().getAsInt()))));
  }

  @Test (enabled = false)
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

