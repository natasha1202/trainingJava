package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase {

    @BeforeMethod

    public void ensurePreconditions(){
        app.getNavigationHelper().gotoHomePage();
        if (! app.getContactHelper().isThereAContact()){
            app.getContactHelper().createContact(new ContactData("name1", "middlename1", "surname", "nickname", "title", "company", "address", "+79000000000", "+79001000000", "849500000000", "849500000000", "email1@email.test", "email2@email.test", "email3@email.test", "http://123.ru", "9", "October", "2000", "5", "March", "2020", "test01", "address2", "home2", "comment"));
        }
    }

    @Test
    public void testContactModification(){
        List<ContactData> before = app.getContactHelper().getContactList();
        int index = before.size() - 1;
        ContactData contact = new ContactData(before.get(index).getId(), "user", "mn", "userSN", "nick", "dr", "IT", "new", "+79010010010", "+79010010010", "849500000123", "849500000123", "user1@email.test", "user1email2@email.test", "user1email3@email.test", "http://1234.ru", "19", "April", "1978", "15", "March", "2010",null, "address new", "phone", "note");
        app.getContactHelper().selecteEditIcon();
        app.getContactHelper().fillContactForm(contact, false);
        app.getContactHelper().submitContactUpdate();
        app.getContactHelper().returntoHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(contact);
        Comparator<? super ContactData> byId = (o1, o2) -> Integer.compare(o1.getId(), o2.getId());
        before.sort(byId);
        after.sort(byId);
         // Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
        Assert.assertEquals(before, after);
    }
}
