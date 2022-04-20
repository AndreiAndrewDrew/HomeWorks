package qa.homeWork2.tests;

import com.google.gson.Gson;
import org.openqa.selenium.json.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import qa.homeWork2.model.GroupData;
import qa.homeWork2.model.Groups;

import java.io.*;
import java.util.Iterator;
import java.util.List;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;

public class GroupCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validGroupsFromJson() throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader
            ("src/test/resources/groups.json"))) {
      StringBuilder json = new StringBuilder();
      String line = reader.readLine();
      while (line != null) {
        json.append(line);
        line = reader.readLine();
      }
      Gson gson = new Gson();
      List<GroupData> groups = gson.fromJson(json.toString(), new TypeToken<List<GroupData>>() {
      }
              .getType()); //List<GroupData>.class
      return groups.stream().map((g) -> new Object[]{g}).toList().iterator();
    }
  }

  @Test(dataProvider = "validGroupsFromJson")
  public void testGroupCreation(GroupData group) {
    app.goTo().groupPage();
    Groups beforeCreation = app.groupHelper().all();
    app.groupHelper().create(group);
    assertThat(app.groupHelper().count(), equalTo(beforeCreation.size() + 1));
    Groups afterCreation = app.groupHelper().all();
    assertThat(afterCreation, equalTo
            (beforeCreation.withAdded(group.withId(afterCreation.stream()
                    .mapToInt(GroupData::id).max().getAsInt()))));

  }

  @Test(enabled = false)
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

