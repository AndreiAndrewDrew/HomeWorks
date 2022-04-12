package qa.homeWork2.model;

import java.util.Objects;

public final class ContactData {

  private int id=Integer.MAX_VALUE;
  private String firstname;
  private String lastname;
  private String address;
  private String email;
  private String homePhone;
  private String mobilePhone;
  private String workPhone;
  private String allPhones;

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public ContactData withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }
  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }

  public ContactData withHomePhone(String homePhone) {
    this.homePhone = homePhone;
    return this;
  }

  public ContactData withMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
    return this;
  }

  public ContactData withWorkPhone(String workPhone) {
    this.workPhone = workPhone;
    return this;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }


  public int id() {return id;}

  public String firstname() {return firstname;}

  public String lastname() {return lastname;}

  public String address() {return address;}

  public String email() {return email;}

  public String homePhone() {return homePhone;}

  public String mobilePhpne() {return mobilePhone;}

  public String workPhone() {return workPhone;}

  public String allPhones() {return allPhones;}

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id && Objects.equals(firstname, that.firstname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstname);
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            ", address='" + address + '\'' +
            ", email='" + email + '\'' +
            ", home='" + homePhone + '\'' +
            ", mobile='" + mobilePhone + '\'' +
            ", work='" + workPhone + '\'' +
            '}';
  }
}
