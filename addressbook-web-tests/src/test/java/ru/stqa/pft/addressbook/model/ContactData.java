package ru.stqa.pft.addressbook.model;

public class ContactData {
    private final String givenName;
    private final String middleName;
    private final String surname;
    private final String nickname;
    private final String title;
    private final String company;
    private final String firstAddress;
    private final String phoneHome;
    private final String cell;
    private final String phoneOffice;
    private final String fax;
    private final String mainEmail;
    private final String email2;
    private final String email3;
    private final String homepageURL;
    private final String birthdayDay;
    private final String birthdayMonth;
    private final String birthdayYear;
    private final String anniversaryDay;
    private final String anniversaryMonth;
    private final String anniversaryYear;
    private final String group;
    private final String secondAddress;
    private final String phoneAlternative;
    private final String notes;
    private int id;

    @Override
    public String toString() {
        return "ContactData{" +
                "givenName='" + givenName + '\'' +
                ", surname='" + surname + '\'' +
                ", id=" + id +
                '}';
    }

    public ContactData(String givenName, String middleName, String surname, String nickname, String title, String company, String firstAddress, String phoneHome, String cell, String phoneOffice, String fax, String mainEmail, String email2, String email3, String homepageURL, String birthdayDay, String birthdayMonth, String birthdayYear, String anniversaryDay, String anniversaryMonth, String anniversaryYear, String group, String secondAddress, String phoneAlternative, String notes) {
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

}
