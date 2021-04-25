package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void returntoHomePage() {
        click(By.linkText("home page"));
    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"), contactData.getGivenName());
        type(By.name("middlename"), contactData.getMiddleName());
        type(By.name("lastname"), contactData.getSurname());
        type(By.name("nickname"), contactData.getNickname());
        type(By.name("title"), contactData.getTitle());
        type(By.name("company"), contactData.getCompany());
        type(By.name("address"), contactData.getFirstAddress());
        type(By.name("home"), contactData.getPhoneHome());
        type(By.name("mobile"), contactData.getCell());
        type(By.name("work"), contactData.getPhoneOffice());
        type(By.name("fax"), contactData.getFax());
        type(By.name("email"), contactData.getMainEmail());
        type(By.name("email2"), contactData.getEmail2());
        type(By.name("email3"), contactData.getEmail3());
        type(By.name("homepage"), contactData.getHomepageURL());

        click(By.name("bday"));
        {
            WebElement dropdown = wd.findElement(By.name("bday"));
            dropdown.findElement(By.xpath(contactData.getBirthdayDay())).click();
        }
        click(By.name("bmonth"));
        {
            WebElement dropdown = wd.findElement(By.name("bmonth"));
            dropdown.findElement(By.xpath(contactData.getBirthdayMonth())).click();
        }
        type(By.name("byear"), contactData.getBirthdayYear());

        click(By.name("aday"));
        {
            WebElement dropdown = wd.findElement(By.name("aday"));
            dropdown.findElement(By.xpath(contactData.getAnniversaryDay())).click();
        }
        click(By.name("amonth"));
        {
            WebElement dropdown = wd.findElement(By.name("amonth"));
            dropdown.findElement(By.xpath(contactData.getAnniversaryMonth())).click();
        }
        type(By.name("ayear"), contactData.getAnniversaryYear());


      /*  click(By.name("new_group"));
        {
            WebElement dropdown = wd.findElement(By.name("new_group"));
            dropdown.findElement(By.xpath(contactData.getGroup())).click();
        } */

        type(By.name("address2"), contactData.getSecondAddress());
        type(By.name("phone2"), contactData.getPhoneAlternative());
        type(By.name("notes"), contactData.getNotes());
        
    }

    public void selectedContact() {
        click(By.name("selected[]"));
    }

    public void deleteSelectedContacts() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void submitContactDeletion() {
        wd.switchTo().alert().accept();
    }

    public void selecteEditIcon() {
        click(By.xpath("(//img[@alt='Edit'])[1]"));
    }

    public void submitContactUpdate() {
        click(By.name("update"));
    }
}
