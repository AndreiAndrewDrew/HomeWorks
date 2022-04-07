package qa.homeWork2.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.homeWork2.model.GroupData;
import java.util.Set;

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

    Set<GroupData> beforeModification = app.group().all();
    GroupData modifiedGroup = beforeModification.iterator().next();
    GroupData group = new GroupData()
            .withId(modifiedGroup.id()).withName("NameModification")
            .withHeader("HeaderModification").withFooter("FooterModification");
    app.group().modify(group);

    Set<GroupData> afterModification = app.group().all();
    Assert.assertEquals(afterModification.size(), beforeModification.size());//comparam marimea listelor
    beforeModification.remove(modifiedGroup);
    beforeModification.add(group);
    Assert.assertEquals(afterModification, beforeModification);
  }
}
