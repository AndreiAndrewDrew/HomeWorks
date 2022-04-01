package qa.homeWork2.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import qa.homeWork2.model.ContactData;
import qa.homeWork2.model.GroupData;


public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver driver) {
    super(driver);
  }

  public void initContactCreation() {
    clickbuton(By.linkText("add new"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.firstname());
    type(By.name("lastname"), contactData.lastname());

    if (creation){
      new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(contactData.group());
    }else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }

  }

  public void submitContactCreation() {
    clickbuton(By.name("submit"));
  }

  public void submitContactModification() {
    clickbuton(By.name("update"));
  }

  public void returnToHomePage() {
    clickbuton(By.linkText("home page"));
  }

  public void initContactModification() {
    clickbuton(By.xpath("//img[@alt='Edit']"));
  }

  public void createContact(ContactData contact, boolean b) {
    initContactCreation();
    fillContactForm(contact,b);
    submitContactCreation();
    returnToHomePage();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));

  }
}


