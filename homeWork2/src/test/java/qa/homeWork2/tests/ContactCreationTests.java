package qa.homeWork2.tests;

import org.testng.annotations.Test;
import qa.homeWork2.model.ContactData;
import qa.homeWork2.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.goTo().homePage();
    Contacts beforeCreation = app.contactHelper().all();

    ContactData contact = new ContactData().withFirstname("FirstNameTestContact").withLastname("LastNameTestContact")
            .withAddress("Tests-Strada1").withEmail("test1@gmail.com").withHomePhone("022323412")
            .withMobilePhone("069721243").withWorkPhone("022657687");
    app.contactHelper().createContact(contact);

    assertThat(app.contactHelper().count(), equalTo(beforeCreation.size()+1));
    Contacts afterCreation = app.contactHelper().all();
    assertThat(afterCreation, equalTo
            (beforeCreation.withAdded(contact.withId(afterCreation.stream().mapToInt((c)->c.id()).max().getAsInt()))));
  }
}
