package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.List;
import java.util.Set;

public class ContactHelper extends HelperBase {

    private Contacts contactCache = null;

    public Set<ContactData> all(){
        if (contactCache != null){
            return new Contacts(contactCache);
        }
        contactCache = new Contacts();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements){
            List<WebElement> cells = element.findElements(By.tagName("td"));
            for(WebElement cell : cells) {
                String cellText = cell.getText();
            }
            String givenName = cells.get(2).getText();
            String surname = cells.get(1).getText();
            String allPhones = cells.get(5).getText();
            String address = cells.get(3).getText();
            String allEmails = cells.get(4).getText();
           // String[] phones = allPhones.split("\n");

            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            ContactData contact = new ContactData()
                    .withId(id)
                    .withGivenName(givenName)
                    .withSurname(surname)
                    .withAllPhones(allPhones)
                    .withFirstAddress(address)
                    .withAllEmails(allEmails);
                   /* .withPhoneHome(phones[0])
                    .withCell(phones[1])
                    .withPhoneOffice(phones[2])
                    .withPhoneAlternative(phones[3]);*/
            contactCache.add(contact);
        }
        return new Contacts(contactCache);
    };

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void returntoHomePage() {
        if (isElementPresent(By.id("maintable"))){
            return;
        }
        if (isElementPresent(By.linkText("home page"))){
        click(By.linkText("home page"));
        } else {click(By.linkText("home"));}


    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void fillContactForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getGivenName());
        type(By.name("middlename"), contactData.getMiddleName());
        type(By.name("lastname"), contactData.getSurname());
        type(By.name("nickname"), contactData.getNickname());
        //attach(By.name("photo"), contactData.getPhoto());
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

        if (contactData.getBirthdayDay() != null) {new Select(wd.findElement(By.name("bday"))).selectByVisibleText(contactData.getBirthdayDay());}
        if (contactData.getBirthdayDay() != null) {new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText(contactData.getBirthdayMonth());}
        type(By.name("byear"), contactData.getBirthdayYear());

        if (contactData.getBirthdayDay() != null) {new Select(wd.findElement(By.name("aday"))).selectByVisibleText(contactData.getAnniversaryDay());}
        if (contactData.getBirthdayDay() != null) {new Select(wd.findElement(By.name("amonth"))).selectByVisibleText(contactData.getAnniversaryMonth());}
        type(By.name("ayear"), contactData.getAnniversaryYear());

        if (creation){
     //       new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
            if (contactData.getGroups().size() > 0){
                Assert.assertTrue(contactData.getGroups().size() == 1);
                new Select(wd.findElement(By.name("new_group"))).
                        selectByVisibleText(contactData.getGroups().iterator().next().getGroupName());
            }
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

    public void fillContactFormPhoto(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getGivenName());
        type(By.name("lastname"), contactData.getSurname());
        attach(By.name("photo"), contactData.getPhoto());
        if (creation){
            if (contactData.getGroups().size() > 0){
                Assert.assertTrue(contactData.getGroups().size() == 1);
                new Select(wd.findElement(By.name("new_group"))).
                        selectByVisibleText(contactData.getGroups().iterator().next().getGroupName());
            }
       //     new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
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

    public void selectedEditIcon(int index) {
        // click(By.xpath("(//img[@alt='Edit'])[1]"));
        wd.findElements(By.xpath("//img[@alt='Edit']")).get(index).click();
    }

    public void selectedContactById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    public void selectedEditIconById(int id) {
        wd.findElement(By.xpath("//a[@href='edit.php?id=" + id + "' ]")).click();
    }

    public void submitContactUpdate() {
        click(By.name("update"));
    }

    public void filterByGroup(int id){
        /*new Select(wd.findElement(By.cssSelector(String.format("select[name='group']>option[value='%s']", id)))).
            //    selectByVisibleText(contactData.getGroups().iterator().next().getGroupName());
                    selectByVisibleText(groupData.getGroupName()); */
        new Select(wd.findElement(By.name("group"))).selectByValue("" + id);
    }

    public void chooseGroup(int id){
        new Select(wd.findElement(By.name("to_group"))).selectByValue("" +id);
    }

    public void removeFromGroup() {
        click(By.name("remove"));
    }

    public void addToGroup(){click(By.name("add")); }

    public void create(ContactData contact) {
        new NavigationHelper(wd).createContactPage();
        fillContactForm(contact, true);
        submitContactCreation();
        contactCache = null;
        returntoHomePage();
    }

    public void createWithPhoto(ContactData contact) {
        new NavigationHelper(wd).createContactPage();
        fillContactFormPhoto(contact, true);
        submitContactCreation();
        contactCache = null;
        returntoHomePage();
    }

    public void modify(ContactData contact) {
        selectedEditIconById(contact.getId());
        fillContactForm(contact, false);
        submitContactUpdate();
        contactCache = null;
        returntoHomePage();
    }

    public void delete(ContactData contact) {
        selectedContactById(contact.getId());
        deleteSelectedContacts();
        submitContactDeletion();
        contactCache = null;
        returntoHomePage();
    }


    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public int contactCount() {
        return wd.findElements(By.name("selected[]")).size(); // List
    }


    public ContactData infoFromEditForm(ContactData contact) {
        initContactModificationById(contact.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        String home2 = wd.findElement(By.name("phone2")).getAttribute("value");
        String address = wd.findElement(By.name("address")).getAttribute("value");
        String secondAddress = wd.findElement(By.name("address2")).getAttribute("value");
        String email1 = wd.findElement(By.name("email")).getAttribute("value");
        String email2 = wd.findElement(By.name("email2")).getAttribute("value");
        String email3 = wd.findElement(By.name("email3")).getAttribute("value");
        wd.navigate().back();
        return new ContactData().withId(contact.getId()).withGivenName(firstname).withSurname(lastname)
                .withPhoneHome(home).withCell(mobile).withPhoneOffice(work).withPhoneAlternative(home2)
                .withFirstAddress(address).withSecondAddress(secondAddress)
                .withMainEmail(email1).withEmail2(email2).withEmail3(email3);
    }

    private void initContactModificationById(int id) {
        WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
        WebElement row = checkbox.findElement(By.xpath("./../..")); // ?????????????? ???? ???????????? ???? 2 ???????????? ????????
        List<WebElement> cells = row.findElements(By.tagName("td"));
        cells.get(7).findElement(By.tagName("a")).click();

       // wd.findElement(By.xpath(String.format("//input[@value='%s']/../../td[8]/a",id))).click();
       // wd.findElement(By.xpath(String.format("//tr[.//input[@value='%s']]/td[8]/a", id))).click();
       // wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']",id))).click();
    }
}
