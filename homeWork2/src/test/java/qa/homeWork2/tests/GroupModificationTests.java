package qa.homeWork2.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import qa.homeWork2.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupModificationTests extends TestBase {

  @Test
  public void testGroupModification() {

    app.getNavigationHelper().gotoGroupPage();

    if (!app.getGroupHelper().isThereAGroup()) {

      app.getGroupHelper().createGroup(new GroupData("AddnewtestGroup", null, null));

    }
    //int before = app.getGroupHelper().getGroupCount();
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectedGroup(before.size() - 1);
    app.getGroupHelper().initGroupModification();
    GroupData group = new GroupData(before.get(before.size() - 1).id()/*pastram id vechi de la grupa modificata*/
            ,"TestModification2", "test2modificat", "test3modificat");
    app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnGroupPage();
    //int after = app.getGroupHelper().getGroupCount();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size());


    before.remove(before.size() - 1);
    before.add(group);
    //Transformam listele in multimi si le comparam
    Assert.assertEquals(new HashSet<Object>(after), new HashSet<Object>(before));

  }
}
