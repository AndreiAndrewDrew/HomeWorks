package qa.homeWork2.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import qa.homeWork2.model.GroupData;
import java.util.Set;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {

    app.goTo().groupPage();
    Set<GroupData> beforeCreation = app.group().all();
    GroupData group = new GroupData().withName("TestNewGroup2");
    app.group().create(group);

    Set<GroupData> afterCreation = app.group().all();
    Assert.assertEquals(afterCreation.size(), beforeCreation.size() + 1);
    group.withId(afterCreation.stream().mapToInt((g)->g.id()).max().getAsInt());
    beforeCreation.add(group);
    Assert.assertEquals(afterCreation, beforeCreation);

  }
}

