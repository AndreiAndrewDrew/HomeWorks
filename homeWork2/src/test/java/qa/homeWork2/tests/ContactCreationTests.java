package qa.homeWork2.tests;

import org.openqa.selenium.devtools.v85.dom.model.ShapeOutsideInfo;
import org.testng.annotations.Test;
import qa.homeWork2.model.ContactData;
import qa.homeWork2.model.Contacts;
import qa.homeWork2.model.Groups;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.goTo().homePage();
    Contacts beforeCreation = app.contactHelper().all();
    File photo= new File("src/test/resources/btt.jpg");
    ContactData contact = new ContactData().withFirstname("FirstNameTestContact")
            .withLastname("LastNameTestContact").withAddress("Tests-Strada1").
            withEmail("test1@gmail.com").withHomePhone("1237738324")
            .withMobilePhone("06798793").withWorkPhone("635732732").withPhoto(photo);
    app.contactHelper().createContact(contact);

    assertThat(app.contactHelper().count(), equalTo(beforeCreation.size()+1));
    Contacts afterCreation = app.contactHelper().all();
    assertThat(afterCreation, equalTo
            (beforeCreation.withAdded(contact.withId(afterCreation.stream().mapToInt((c)->c.id()).max().getAsInt()))));
  }

  @Test (enabled = false)
  public void testCurrentDir(){
    File currentDir= new File(".");
    System.out.println(currentDir.getAbsolutePath());
    File photo= new File("src/test/resources/btt.jpg");
    System.out.println(photo.getAbsolutePath());
    System.out.println(photo.exists());
  }
}
