package qa.homeWork2.model;

import java.util.Objects;

public final class ContactData {

  private int id=Integer.MAX_VALUE;
  private String firstname;
  private String lastname;


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

  public int id() {return id;}

  public String firstname() {return firstname;}

  public String lastname() {return lastname;}


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id && Objects.equals(firstname, that.firstname);
  }

  @Override
  public int hashCode() {return Objects.hash(id, firstname);}

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", firstname='" + firstname + '\'' +
            '}';
  }

}
