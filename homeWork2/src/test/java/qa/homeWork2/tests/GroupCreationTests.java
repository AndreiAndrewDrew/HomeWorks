package qa.homeWork2.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import qa.homeWork2.model.GroupData;
import qa.homeWork2.model.Groups;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;

public class GroupCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validGroups() throws IOException {
    List<Object[]> list = new ArrayList<Object[]>();
    BufferedReader reader = new BufferedReader(new FileReader
            ("src/test/resources/groups.csv"));
    String line = reader.readLine();
    while (line != null){
      String[] split = line.split(";");
      list.add(new Object[] {new GroupData().withName(split[0]).withHeader(split[1])
              .withFooter(split[2])});
      line = reader.readLine();
    }
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

