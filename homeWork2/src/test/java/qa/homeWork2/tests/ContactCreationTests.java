package qa.homeWork2.tests;

import org.testng.annotations.Test;
import qa.homeWork2.model.ContactData;

public class ContactCreationTests extends TestBase {
  @Test //ineceput de test
  public void testContactCreation() {
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(new ContactData("testName1", "testLastName","test1"),true);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();

  }
}
