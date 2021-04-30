package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion(){
        if (! app.getContactHelper().isThereAContact()){
            app.getContactHelper().createContact(new ContactData("name1", "middlename1", "surname", "nickname", "title", "company", "address", "+79000000000", "+79001000000", "849500000000", "849500000000", "email1@email.test", "email2@email.test", "email3@email.test", "http://123.ru", "9", "October", "2000", "5", "March", "2020", "test01", "address2", "home2", "comment"));
        }
        app.getContactHelper().selectedContact();
        app.getContactHelper().deleteSelectedContacts();
        app.getContactHelper().submitContactDeletion();
    }
}
