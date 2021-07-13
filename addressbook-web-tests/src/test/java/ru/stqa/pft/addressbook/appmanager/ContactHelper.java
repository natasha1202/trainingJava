package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactHelper extends HelperBase {

    public List<ContactData> contactList(){
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements){
            List<WebElement> cells = element.findElements(By.tagName("td"));
            for(WebElement cell : cells) {
                String cellText = cell.getText();
            }
            String givenName = cells.get(2).getText();
            String surname = cells.get(1).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            ContactData contact = new ContactData()
                    .withId(id)
                    .withGivenName(givenName)
                    .withSurname(surname);
            contacts.add(contact);
        }
        return contacts;
    };

    public Set<ContactData> all(){
        Set<ContactData> contacts = new HashSet<ContactData>();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements){
            List<WebElement> cells = element.findElements(By.tagName("td"));
            for(WebElement cell : cells) {
                String cellText = cell.getText();
            }
            String givenName = cells.get(2).getText();
            String surname = cells.get(1).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            ContactData contact = new ContactData()
                    .withId(id)
                    .withGivenName(givenName)
                    .withSurname(surname);
            contacts.add(contact);
        }
        return contacts;
    };

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void returntoHomePage() {
        if (isElementPresent(By.id("maintable"))){
            return;
        }
        click(By.linkText("home page"));
    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void fillContactForm(ContactData contactData, boolean creation) {
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

        new Select(wd.findElement(By.name("bday"))).selectByVisibleText(contactData.getBirthdayDay());
        new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText(contactData.getBirthdayMonth());
        type(By.name("byear"), contactData.getBirthdayYear());

        new Select(wd.findElement(By.name("aday"))).selectByVisibleText(contactData.getAnniversaryDay());
        new Select(wd.findElement(By.name("amonth"))).selectByVisibleText(contactData.getAnniversaryMonth());
        type(By.name("ayear"), contactData.getAnniversaryYear());

        if (creation){
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }

        /* if (isElementPresent(By.name("new_group"))) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } */

        type(By.name("address2"), contactData.getSecondAddress());
        type(By.name("phone2"), contactData.getPhoneAlternative());
        type(By.name("notes"), contactData.getNotes());

    }

    public void selectedContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void deleteSelectedContacts() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void submitContactDeletion() {
        wd.switchTo().alert().accept();
        wd.findElement(By.cssSelector("div.msgbox"));
    }

    public void selecteEditIcon(int index) {
        // click(By.xpath("(//img[@alt='Edit'])[1]"));
        wd.findElements(By.xpath("//img[@alt='Edit']")).get(index).click();
    }

    public void submitContactUpdate() {
        click(By.name("update"));
    }

    public void create(ContactData contact) {
        new NavigationHelper(wd).createContactPage();
        fillContactForm(contact, true);
        submitContactCreation();
        returntoHomePage();
    }

    public void modify(int index, ContactData contact) {
        selecteEditIcon(index);
        fillContactForm(contact, false);
        submitContactUpdate();
        returntoHomePage();
    }

    public void delete(int index) {
        selectedContact(index);
        deleteSelectedContacts();
        submitContactDeletion();
        returntoHomePage();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size(); // List
    }

}