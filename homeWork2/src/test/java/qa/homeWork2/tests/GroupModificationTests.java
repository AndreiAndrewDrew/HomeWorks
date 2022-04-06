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
    app.getNavigationHelper().gotoGroupPage();
    if (!app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("NewGroupFromPrecondition", null, null));
    }
  }

  @Test
  public void testGroupModification() {

    List<GroupData> beforeModification = app.getGroupHelper().getGroupList();
    int index = beforeModification.size() - 1;
    GroupData group = new GroupData(beforeModification.get(index).id(), "NameModification", "HeaderModification", "FooterModification");
    app.getGroupHelper().modifyGroup(index, group);

    List<GroupData> afterModification = app.getGroupHelper().getGroupList();
    Assert.assertEquals(afterModification.size(), beforeModification.size());//comparam marimea listelor
    beforeModification.remove(index);
    beforeModification.add(group);

    Comparator<? super GroupData> byId = Comparator.comparingInt(GroupData::id);//sortam listele dupa id si le comparam
    beforeModification.sort(byId);
    afterModification.sort(byId);
    Assert.assertEquals(afterModification, beforeModification);
  }
}
