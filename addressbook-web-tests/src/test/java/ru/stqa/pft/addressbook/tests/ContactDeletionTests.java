package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {

    @BeforeMethod

    public void ensurePreconditions(){
        app.getNavigationHelper().gotoHomePage();
        if (! app.getContactHelper().isThereAContact()){
            app.getContactHelper().createContact(new ContactData("name1", "middlename1", "surname", "nickname", "title", "company", "address", "+79000000000", "+79001000000", "849500000000", "849500000000", "email1@email.test", "email2@email.test", "email3@email.test", "http://123.ru", "9", "October", "2000", "5", "March", "2020", "test01", "address2", "home2", "comment"));
        }
    }
    @Test
    public void testContactDeletion(){
        List<ContactData> before = app.getContactHelper().getContactList();
        int index = before.size() - 1;
        app.getContactHelper().selectedContact(index);
        app.getContactHelper().deleteSelectedContacts();
        app.getContactHelper().submitContactDeletion();
        app.getContactHelper().returntoHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();

        Assert.assertEquals(after.size(), index);

        before.remove(index);
        Assert.assertEquals(before, after);

    }
}
