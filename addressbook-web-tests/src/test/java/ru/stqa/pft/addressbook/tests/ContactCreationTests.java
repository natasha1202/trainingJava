package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

    @Test
    public void addNewContact(){
        int before = app.getContactHelper().getContactCount();
        app.getNavigationHelper().gotoCreateContactPage();
        app.getContactHelper().createContact(new ContactData("name1", "middlename1", "surname", "nickname", "title", "company", "address", "+79000000000", "+79001000000", "849500000000", "849500000000", "email1@email.test", "email2@email.test", "email3@email.test", "http://123.ru", "9", "October", "2000", "5", "March", "2020", "test1", "address2", "home2", "comment"));
        /* app.getContactHelper().fillContactForm(new ContactData("name1", "middlename1", "surname", "nickname", "title", "company", "address", "+79000000000", "+79001000000", "849500000000", "849500000000", "email1@email.test", "email2@email.test", "email3@email.test", "http://123.ru", "9", "October", "2000", "5", "March", "2020", "test1", "address2", "home2", "comment"), true);
        app.getContactHelper().submitContactCreation();
        app.getContactHelper().returntoHomePage(); */
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before + 1);
    }

}
