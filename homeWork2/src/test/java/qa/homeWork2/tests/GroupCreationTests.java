package qa.homeWork2.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import qa.homeWork2.model.GroupData;
import java.util.Comparator;
import java.util.List;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {

    app.goTo().groupPage();
    List<GroupData> beforeCreation = app.group().list();
    GroupData group = new GroupData("TestNewGroup2", null, null);
    app.group().create(group);

    List<GroupData> afterCreation = app.group().list();
    Assert.assertEquals(afterCreation.size(), beforeCreation.size() + 1);
    beforeCreation.add(group);

    Comparator<? super GroupData> byId = Comparator.comparingInt(GroupData::id);
    beforeCreation.sort(byId);
    afterCreation.sort(byId);
    Assert.assertEquals(afterCreation, beforeCreation);

  }
}

