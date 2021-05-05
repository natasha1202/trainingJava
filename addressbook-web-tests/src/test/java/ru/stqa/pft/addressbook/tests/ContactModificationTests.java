package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification(){
        int before = app.getContactHelper().getContactCount();
        if (! app.getContactHelper().isThereAContact()){
            app.getContactHelper().createContact(new ContactData("name1", "middlename1", "surname", "nickname", "title", "company", "address", "+79000000000", "+79001000000", "849500000000", "849500000000", "email1@email.test", "email2@email.test", "email3@email.test", "http://123.ru", "9", "October", "2000", "5", "March", "2020", "test01", "address2", "home2", "comment"));
        }
        app.getContactHelper().selecteEditIcon();
        app.getContactHelper().fillContactForm(new ContactData("user", "mn", "userSN", "nick", "dr", "IT", "new", "+79010010010", "+79010010010", "849500000123", "849500000123", "user1@email.test", "user1email2@email.test", "user1email3@email.test", "http://1234.ru", "19", "April", "1978", "15", "March", "2010",null, "address new", "phone", "note"), false);
        app.getContactHelper().submitContactUpdate();
        app.getContactHelper().returntoHomePage();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before);
    }
}
