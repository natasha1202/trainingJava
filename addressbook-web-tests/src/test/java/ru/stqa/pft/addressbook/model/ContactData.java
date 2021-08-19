package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;

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
   // @Column(name="bday")
   // @Type(type="tinyint")
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
  //  @Type(type="tinyint")
    @Expose
    private String anniversaryDay;

    @Column(name="amonth")
    @Expose
    private String anniversaryMonth;

    @Column(name="ayear")
    @Expose
    private String anniversaryYear;

    @Transient
    @Expose
    private String group;
    //transient private String group;

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

    public ContactData withGroup(String group) {
        this.group = group;
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

   /* @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (givenName != null ? !givenName.equals(that.givenName) : that.givenName != null) return false;
        return surname != null ? surname.equals(that.surname) : that.surname == null;
    }

    @Override
    public int hashCode() {
        int result = givenName != null ? givenName.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        return result;
    } */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (id != that.id) return false;
        if (givenName != null ? !givenName.equals(that.givenName) : that.givenName != null) return false;
        return surname != null ? surname.equals(that.surname) : that.surname == null;
    }

    @Override
    public int hashCode() {
        int result = givenName != null ? givenName.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
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

    public String getGroup() {
        return group;
    }

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

}
