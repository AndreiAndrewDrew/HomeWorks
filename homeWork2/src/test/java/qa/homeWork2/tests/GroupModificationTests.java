package qa.homeWork2.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.homeWork2.model.GroupData;
import java.util.Comparator;
import java.util.List;

public class GroupModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.group().list().size() == 0) {
      app.group().create(new GroupData().withName("NewGroup"));
    }
  }

  @Test
  public void testGroupModification() {

    List<GroupData> beforeModification = app.group().list();
    int index = beforeModification.size() - 1;
    GroupData group = new GroupData()
            .withId(beforeModification.get(index).id()).withName("NameModification")
            .withHeader("HeaderModification").withFooter("FooterModification");
    app.group().modify(index, group);

    List<GroupData> afterModification = app.group().list();
    Assert.assertEquals(afterModification.size(), beforeModification.size());//comparam marimea listelor
    beforeModification.remove(index);
    beforeModification.add(group);

    Comparator<? super GroupData> byId = Comparator.comparingInt(GroupData::id);//sortam listele dupa id si le comparam
    beforeModification.sort(byId);
    afterModification.sort(byId);
    Assert.assertEquals(afterModification, beforeModification);
  }
}
