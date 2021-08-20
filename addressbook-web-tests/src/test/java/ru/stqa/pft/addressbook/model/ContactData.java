package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "addressbook")
@XStreamAlias("contact")
public class ContactData {
    @Column(name="firstname")
    @Expose
    private String givenName;

    @Column(name="middlename")
    @Expose
    private String middleName;

    @Column(name="lastname")
    @Expose
    private String surname;

    @Column(name="nickname")
    @Expose
    private String nickname;

    @Column(name="title")
    @Expose
    private String title;

    @Column(name="company")
    @Expose
    private String company;

    @Column(name="address")
    @Type(type="text")
    @Expose
    private String firstAddress;

    @Column(name="home")
    @Type(type="text")
    @Expose
    private String phoneHome;

    @Column(name="mobile")
    @Type(type="text")
    @Expose
    private String cell;

    @Column(name="work")
    @Type(type="text")
    @Expose
    private String phoneOffice;

    @Column(name="fax")
    @Type(type="text")
    @Expose
    private String fax;

    @Column(name="email")
    @Type(type="text")
    @Expose
    private String mainEmail;

    @Column(name="email2")
    @Type(type="text")
    @Expose
    private String email2;

    @Column(name="email3")
    @Type(type="text")
    @Expose
    private String email3;

    @Column(name="homepage")
    @Type(type="text")
    @Expose
    private String homepageURL;

    @Transient
 //   @Column(name="bday")
 //   @Type(type="tinyint")
    @Expose
    private String birthdayDay;

    @Column(name="bmonth")
    @Expose
    private String birthdayMonth;

    @Column(name="byear")
    @Expose
    private String birthdayYear;

    @Transient
  //  @Column(name="aday")
 //   @Type(type="int")
    @Expose
    private String anniversaryDay;

    @Column(name="amonth")
    @Expose
    private String anniversaryMonth;

    @Column(name="ayear")
    @Expose
    private String anniversaryYear;

    @Column(name="address2")
    @Type(type="text")
    @Expose
    private String secondAddress;

    @Column(name="phone2")
    @Type(type="text")
    @Expose
    private String phoneAlternative;

    @Column(name="notes")
    @Type(type="text")
    @Expose
    private String notes;

    @Id
    @Column(name="id")
    @XStreamOmitField
    private int id = Integer.MAX_VALUE;

    @Transient
    private String allPhones;
    @Transient
    private String allEmails;

   // @Type(type="mediumtext")
    @Type(type="text")
    @Column(name="photo")
    private String photo;

    @Expose
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="address_in_groups",
            joinColumns = @JoinColumn (name = "id"),  inverseJoinColumns = @JoinColumn(name = "group_id"))
    private Set<GroupData> groups = new HashSet<GroupData>();

    public ContactData withGivenName(String givenName) {
        this.givenName = givenName;
        return this;
    }

    public ContactData withMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public ContactData withSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public ContactData withNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public ContactData withTitle(String title) {
        this.title = title;
        return this;
    }

    public ContactData withCompany(String company) {
        this.company = company;
        return this;
    }

    public ContactData withFirstAddress(String firstAddress) {
        this.firstAddress = firstAddress;
        return this;
    }

    public ContactData withPhoneHome(String phoneHome) {
        this.phoneHome = phoneHome;
        return this;
    }

    public ContactData withCell(String cell) {
        this.cell = cell;
        return this;
    }

    public ContactData withPhoneOffice(String phoneOffice) {
        this.phoneOffice = phoneOffice;
        return this;
    }

    public ContactData withFax(String fax) {
        this.fax = fax;
        return this;
    }

    public ContactData withMainEmail(String mainEmail) {
        this.mainEmail = mainEmail;
        return this;
    }

    public ContactData withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }

    public ContactData withEmail3(String email3) {
        this.email3 = email3;
        return this;
    }

    public ContactData withHomepageURL(String homepageURL) {
        this.homepageURL = homepageURL;
        return this;
    }

    public ContactData withBirthdayDay(String birthdayDay) {
        this.birthdayDay = birthdayDay;
        return this;
    }

    public ContactData withBirthdayMonth(String birthdayMonth) {
        this.birthdayMonth = birthdayMonth;
        return this;
    }

    public ContactData withBirthdayYear(String birthdayYear) {
        this.birthdayYear = birthdayYear;
        return this;
    }

    public ContactData withAnniversaryDay(String anniversaryDay) {
        this.anniversaryDay = anniversaryDay;
        return this;
    }

    public ContactData withAnniversaryMonth(String anniversaryMonth) {
        this.anniversaryMonth = anniversaryMonth;
        return this;
    }

    public ContactData withAnniversaryYear(String anniversaryYear) {
        this.anniversaryYear = anniversaryYear;
        return this;
    }

    public ContactData withSecondAddress(String secondAddress) {
        this.secondAddress = secondAddress;
        return this;
    }

    public ContactData withPhoneAlternative(String phoneAlternative) {
        this.phoneAlternative = phoneAlternative;
        return this;
    }

    public ContactData withNotes(String notes) {
        this.notes = notes;
        return this;
    }

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    public ContactData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public ContactData withAllEmails(String allEmails) {
        this.allEmails = allEmails;
        return this;
    }

    public ContactData withPhoto(File photo) {
        this.photo = photo.getPath();
        return this;
    }


    @Override
    public String toString() {
        return "ContactData{" +
                "givenName='" + givenName + '\'' +
                ", surname='" + surname + '\'' +
                ", id=" + id +
                '}';
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (id != that.id) return false;
        if (givenName != null ? !givenName.equals(that.givenName) : that.givenName != null) return false;
        if (middleName != null ? !middleName.equals(that.middleName) : that.middleName != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
        if (nickname != null ? !nickname.equals(that.nickname) : that.nickname != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (company != null ? !company.equals(that.company) : that.company != null) return false;
        if (firstAddress != null ? !firstAddress.equals(that.firstAddress) : that.firstAddress != null) return false;
        if (phoneHome != null ? !phoneHome.equals(that.phoneHome) : that.phoneHome != null) return false;
        if (cell != null ? !cell.equals(that.cell) : that.cell != null) return false;
        if (phoneOffice != null ? !phoneOffice.equals(that.phoneOffice) : that.phoneOffice != null) return false;
        if (fax != null ? !fax.equals(that.fax) : that.fax != null) return false;
        if (mainEmail != null ? !mainEmail.equals(that.mainEmail) : that.mainEmail != null) return false;
        if (email2 != null ? !email2.equals(that.email2) : that.email2 != null) return false;
        if (email3 != null ? !email3.equals(that.email3) : that.email3 != null) return false;
        if (homepageURL != null ? !homepageURL.equals(that.homepageURL) : that.homepageURL != null) return false;
        if (birthdayYear != null ? !birthdayYear.equals(that.birthdayYear) : that.birthdayYear != null) return false;
        if (anniversaryYear != null ? !anniversaryYear.equals(that.anniversaryYear) : that.anniversaryYear != null)
            return false;
        if (secondAddress != null ? !secondAddress.equals(that.secondAddress) : that.secondAddress != null)
            return false;
        if (phoneAlternative != null ? !phoneAlternative.equals(that.phoneAlternative) : that.phoneAlternative != null)
            return false;
        return notes != null ? notes.equals(that.notes) : that.notes == null;
    }

    @Override
    public int hashCode() {
        int result = givenName != null ? givenName.hashCode() : 0;
        result = 31 * result + (middleName != null ? middleName.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (company != null ? company.hashCode() : 0);
        result = 31 * result + (firstAddress != null ? firstAddress.hashCode() : 0);
        result = 31 * result + (phoneHome != null ? phoneHome.hashCode() : 0);
        result = 31 * result + (cell != null ? cell.hashCode() : 0);
        result = 31 * result + (phoneOffice != null ? phoneOffice.hashCode() : 0);
        result = 31 * result + (fax != null ? fax.hashCode() : 0);
        result = 31 * result + (mainEmail != null ? mainEmail.hashCode() : 0);
        result = 31 * result + (email2 != null ? email2.hashCode() : 0);
        result = 31 * result + (email3 != null ? email3.hashCode() : 0);
        result = 31 * result + (homepageURL != null ? homepageURL.hashCode() : 0);
        result = 31 * result + (birthdayYear != null ? birthdayYear.hashCode() : 0);
        result = 31 * result + (anniversaryYear != null ? anniversaryYear.hashCode() : 0);
        result = 31 * result + (secondAddress != null ? secondAddress.hashCode() : 0);
        result = 31 * result + (phoneAlternative != null ? phoneAlternative.hashCode() : 0);
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }

    public String getGivenName() {
        return givenName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getSurname() {
        return surname;
    }

    public String getNickname() {
        return nickname;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getFirstAddress() {
        return firstAddress;
    }

    public String getPhoneHome() {
        return phoneHome;
    }

    public String getCell() {
        return cell;
    }

    public String getPhoneOffice() {
        return phoneOffice;
    }

    public String getFax() {
        return fax;
    }

    public String getMainEmail() {
        return mainEmail;
    }

    public String getEmail2() {
        return email2;
    }

    public String getEmail3() {
        return email3;
    }

    public String getHomepageURL() {
        return homepageURL;
    }

    public String getBirthdayDay() {
        return birthdayDay;
    }

    public String getBirthdayMonth() {
        return birthdayMonth;
    }

    public String getBirthdayYear() {
        return birthdayYear;
    }

    public String getAnniversaryDay() {
        return anniversaryDay;
    }

    public String getAnniversaryMonth() {
        return anniversaryMonth;
    }

    public String getAnniversaryYear() {
        return anniversaryYear;
    }

    public Groups getGroups() {  return new Groups(groups); }

    public String getSecondAddress() {
        return secondAddress;
    }

    public String getPhoneAlternative() {
        return phoneAlternative;
    }

    public String getNotes() {
        return notes;
    }

    public String getAllPhones() { return allPhones; }

    public String getAllEmails() { return allEmails; }

    public File getPhoto() { return new File(photo); }

    public ContactData inGroups(GroupData group) {
        groups.add(group);
        return this;
    }
}
