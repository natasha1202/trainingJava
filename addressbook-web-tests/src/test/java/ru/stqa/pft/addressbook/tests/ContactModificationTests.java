package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification(){
        app.getContactHelper().selecteEditIcon();
        app.getContactHelper().fillContactForm(new ContactData("user", "mn", "userSN", "nick", "dr", "IT", "new", "+79010010010", "+79010010010", "849500000123", "849500000123", "user1@email.test", "user1email2@email.test", "user1email3@email.test", "http://1234.ru", "19", "April", "1978", "15", "March", "2010",null, "address new", "phone", "note"), false);
        app.getContactHelper().submitContactUpdate();
        app.getContactHelper().returntoHomePage();
    }
}
