package qa.homeWork2.appmanager;

import io.netty.handler.codec.AsciiHeadersEncoder;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import qa.homeWork2.model.ContactData;
import qa.homeWork2.model.Contacts;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver driver) {
    super(driver);
  }

  public void initContactCreation() {
    clickbuton(By.linkText("add new"));
  }

  public void fillContactForm(ContactData contactData) {
    type(By.name("firstname"), contactData.firstname());
    type(By.name("lastname"), contactData.lastname());
    type(By.name("address"), contactData.address());
    type(By.name("email"), contactData.email());
    type(By.name("home"), contactData.homePhone());
    type(By.name("mobile"), contactData.mobilePhpne());
    type(By.name("work"), contactData.workPhone());
  }

  public void submitContactCreation() {
    clickbuton(By.name("submit"));
  }

  public void returnToHomePage() {
    clickbuton(By.linkText("home page"));
  }

  public void selectedContactById(int id) {
    driver.findElement(By.cssSelector("input[id='"+ id +"']")).click();
  }

  public void deleteSelectedContacts() {
    clickbuton(By.name("delete"));
    Alert alert = driver.switchTo().alert();
    alert.accept();
  }

  public void createContact(ContactData contact) {
    initContactCreation();
    fillContactForm(contact);
    submitContactCreation();
    contactsCache = null;
    returnToHomePage();
  }

  public void delete(ContactData contact) {
    selectedContactById(contact.id());
    deleteSelectedContacts();
    contactsCache = null;
    //returnToHomePage();
  }

  /*
  public Set<ContactData> all(){
    Set<ContactData> contacts =new HashSet<ContactData>();
    List<WebElement> rows =driver.findElements(By.name("entry"));
    for (WebElement row:rows){
      List<WebElement> cells = row.findElements(By.tagName("td"));
      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
      String lastname = cells.get(1).getText();
      String firstname = cells.get(2).getText();

      contacts.add(new ContactData().withId(id).withLastname(lastname).withFirstname(firstname));

    }
    return contacts;

  }*/


  private Contacts contactsCache = null;

  public Contacts all() {
    if (contactsCache != null) {
      return new Contacts(contactsCache);
    }
    contactsCache = new Contacts();
    //Set<ContactData> contacts =new HashSet<ContactData>();
    List<WebElement> rows =driver.findElements(By.name("entry"));
    for (WebElement row:rows) {
      List<WebElement> cells = row.findElements(By.tagName("td"));
      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
      String lastname = cells.get(1).getText();
      String firstname = cells.get(2).getText();
      String address = cells.get(3).getText();
      String email =cells.get(4).getText();
      String[] phones = cells.get(5).getText().split("\n");
      contactsCache.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname)
              .withAddress(address).withEmail(email).withHomePhone(phones[0])
              .withMobilePhone(phones[1]).withWorkPhone(phones[2]));
    }
    return new Contacts(contactsCache);
  }

  public int count() {
   return driver.findElements(By.name("entry")).size();
  }

  public ContactData infoFromEditForm(ContactData contact) {
    initContactModificationById(contact.id());
    String firstname = driver.findElement(By.name("firstname")).getAttribute("value");
    String lastname = driver.findElement(By.name("lastname")).getAttribute("value");
    String address = driver.findElement(By.name("address")).getAttribute("value");
    String email = driver.findElement(By.name("email")).getAttribute("value");
    String homePhone = driver.findElement(By.name("home")).getAttribute("value");
    String mobilePhone = driver.findElement(By.name("mobile")).getAttribute("value");
    String workPhone = driver.findElement(By.name("work")).getAttribute("value");
    driver.navigate().back();
    return new ContactData().withId(contact.id()).withFirstname(firstname).withLastname(lastname)
            .withAddress(address).withEmail(email).withHomePhone(homePhone).withMobilePhone(mobilePhone)
            .withWorkPhone(workPhone);
  }

  public void initContactModificationById(int id){
    driver.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']",id))).click();
  }

}



