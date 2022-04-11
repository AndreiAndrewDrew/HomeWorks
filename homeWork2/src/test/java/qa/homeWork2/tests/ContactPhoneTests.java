package qa.homeWork2.tests;

import org.testng.annotations.Test;
import qa.homeWork2.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests extends TestBase {

  @Test
  public void testContactPhone(){
    app.goTo().homePage();
    ContactData contact = app.contactHelper().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contactHelper().infoFromEditForm(contact);

    assertThat(contact.homePhone(), equalTo(contactInfoFromEditForm.homePhone()));
    assertThat(contact.mobilePhpne(), equalTo(contactInfoFromEditForm.mobilePhpne()));
    assertThat(contact.workPhone(), equalTo(contactInfoFromEditForm.workPhone()));
  }


}
