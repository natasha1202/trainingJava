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
        click(By.cssSelector("select:nth-child(61) > option:nth-child(11)"));
        click(By.name("bmonth"));
        {
            WebElement dropdown = wd.findElement(By.name("bmonth"));
            dropdown.findElement(By.xpath(contactData.getBirthdayMonth())).click();
        }
        click(By.cssSelector("select:nth-child(62) > option:nth-child(11)"));
        type(By.name("byear"), contactData.getBirthdayYear());

        click(By.name("aday"));
        {
            WebElement dropdown = wd.findElement(By.name("aday"));
            dropdown.findElement(By.xpath(contactData.getAnniversaryDay())).click();
        }
        click(By.cssSelector("select:nth-child(66) > option:nth-child(7)"));
        click(By.name("amonth"));
        {
            WebElement dropdown = wd.findElement(By.name("amonth"));
            dropdown.findElement(By.xpath(contactData.getAnniversaryMonth())).click();
        }
        click(By.cssSelector("select:nth-child(67) > option:nth-child(4)"));
        type(By.name("ayear"), contactData.getAnniversaryYear());


        click(By.name("new_group"));
        {
            WebElement dropdown = wd.findElement(By.name("new_group"));
            dropdown.findElement(By.xpath(contactData.getGroup())).click();
        }
        click(By.cssSelector("select:nth-child(71) > option:nth-child(3)"));

        type(By.name("address2"), contactData.getSecondAddress());
        type(By.name("phone2"), contactData.getPhoneAlternative());
        type(By.name("notes"), contactData.getNotes());
        
    }
}
