package qa.homeWork2.tests;

import org.testng.annotations.Test;
import qa.homeWork2.model.ContactData;
import qa.homeWork2.model.GroupData;

public class ContactCreationTests extends TestBase {
  @Test (enabled = false) //ineceput de test
  public void testContactCreation() {
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().createContact(new ContactData("testName1", "testLastName","Addnewtest"),true);
  }
}
