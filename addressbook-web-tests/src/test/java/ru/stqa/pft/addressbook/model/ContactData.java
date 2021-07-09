package ru.stqa.pft.addressbook.model;

public class ContactData {
    private String givenName;
    private String middleName;
    private String surname;
    private String nickname;
    private String title;
    private String company;
    private String firstAddress;
    private String phoneHome;
    private String cell;
    private String phoneOffice;
    private String fax;
    private String mainEmail;
    private String email2;
    private String email3;
    private String homepageURL;
    private String birthdayDay;
    private String birthdayMonth;
    private String birthdayYear;
    private String anniversaryDay;
    private String anniversaryMonth;
    private String anniversaryYear;
    private String group;
    private String secondAddress;
    private String phoneAlternative;
    private String notes;
    private int id = Integer.MAX_VALUE;

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

        if (givenName != null ? !givenName.equals(that.givenName) : that.givenName != null) return false;
        return surname != null ? surname.equals(that.surname) : that.surname == null;
    }

    @Override
    public int hashCode() {
        int result = givenName != null ? givenName.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        return result;
    }

  /*  public ContactData(String givenName, String middleName, String surname, String nickname, String title, String company, String firstAddress, String phoneHome, String cell, String phoneOffice, String fax, String mainEmail, String email2, String email3, String homepageURL, String birthdayDay, String birthdayMonth, String birthdayYear, String anniversaryDay, String anniversaryMonth, String anniversaryYear, String group, String secondAddress, String phoneAlternative, String notes) {
        this.givenName = givenName;
        this.middleName = middleName;
        this.surname = surname;
        this.nickname = nickname;
        this.title = title;
        this.company = company;
        this.firstAddress = firstAddress;
        this.phoneHome = phoneHome;
        this.cell = cell;
        this.phoneOffice = phoneOffice;
        this.fax = fax;
        this.mainEmail = mainEmail;
        this.email2 = email2;
        this.email3 = email3;
        this.homepageURL = homepageURL;
        this.birthdayDay = birthdayDay;
        this.birthdayMonth = birthdayMonth;
        this.birthdayYear = birthdayYear;
        this.anniversaryDay = anniversaryDay;
        this.anniversaryMonth = anniversaryMonth;
        this.anniversaryYear = anniversaryYear;
        this.group = group;
        this.secondAddress = secondAddress;
        this.phoneAlternative = phoneAlternative;
        this.notes = notes;
        this.id = Integer.MAX_VALUE;
    }

    public ContactData(int id, String givenName, String middleName, String surname, String nickname, String title, String company, String firstAddress, String phoneHome, String cell, String phoneOffice, String fax, String mainEmail, String email2, String email3, String homepageURL, String birthdayDay, String birthdayMonth, String birthdayYear, String anniversaryDay, String anniversaryMonth, String anniversaryYear, String group, String secondAddress, String phoneAlternative, String notes) {
        this.givenName = givenName;
        this.middleName = middleName;
        this.surname = surname;
        this.nickname = nickname;
        this.title = title;
        this.company = company;
        this.firstAddress = firstAddress;
        this.phoneHome = phoneHome;
        this.cell = cell;
        this.phoneOffice = phoneOffice;
        this.fax = fax;
        this.mainEmail = mainEmail;
        this.email2 = email2;
        this.email3 = email3;
        this.homepageURL = homepageURL;
        this.birthdayDay = birthdayDay;
        this.birthdayMonth = birthdayMonth;
        this.birthdayYear = birthdayYear;
        this.anniversaryDay = anniversaryDay;
        this.anniversaryMonth = anniversaryMonth;
        this.anniversaryYear = anniversaryYear;
        this.group = group;
        this.secondAddress = secondAddress;
        this.phoneAlternative = phoneAlternative;
        this.notes = notes;
        this.id = id;
    } */

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

}
