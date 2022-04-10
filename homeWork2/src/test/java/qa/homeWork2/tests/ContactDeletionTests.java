package qa.homeWork2.tests;

import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.homeWork2.model.ContactData;
import qa.homeWork2.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contactHelper().all().size() == 0) {
      app.contactHelper().createContact(new ContactData().withFirstname("FirstNameTestContact").withLastname("LastNameTestContact")
              .withAddress("Tests-Strada1").withEmail("test1@gmail.com").withAllPhone("022323412"));
    }
  }

  @Test
  public void testContactDeletion() {

    Contacts beforeDeletion = app.contactHelper().all();
    ContactData deletedContact;
    deletedContact = beforeDeletion.iterator().next();
    app.contactHelper().delete(deletedContact);

    assertThat(app.contactHelper().count(), equalTo(beforeDeletion.size()-1));
    Contacts afterDeletion = app.contactHelper().all();
    assertThat(afterDeletion, equalTo(beforeDeletion.without(deletedContact)));
  }

}
