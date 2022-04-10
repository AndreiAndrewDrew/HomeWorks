package qa.homeWork2.appmanager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import qa.homeWork2.model.ContactData;
import qa.homeWork2.model.Contacts;
import java.util.List;


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
  }

  public void submitContactCreation() {
    clickbuton(By.name("submit"));
  }

  public void returnToHomePage() {
    clickbuton(By.linkText("home page"));
  }

  public void selectedContactById(int id) {
    driver.findElement(By.xpath("//*[@id=\"" + id + "\"]")).click();
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


  private Contacts contactsCache = null;

  public Contacts all() {
    if (contactsCache != null) {
      return new Contacts(contactsCache);
    }
    contactsCache = new Contacts();
    List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"maintable\"]/tbody/tr[@name=\"entry\"]"));
    for (WebElement element : elements) {
      for (int i = 0; i < elements.size(); i++) {
        String firstname = element.findElement(By.xpath("//*[@id=\"maintable\"]/tbody/tr[@name=\"entry\"]/td[3]")).getText();
        int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
        contactsCache.add(new ContactData().withId(id).withFirstname(firstname));
      }
    }
    return new Contacts(contactsCache);
  }

  public int count() {
    return driver.findElements(By.name("selected[]")).size();
  }


}


