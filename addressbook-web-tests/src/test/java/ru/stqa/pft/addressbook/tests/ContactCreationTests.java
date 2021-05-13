package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test
    public void addNewContact(){
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getNavigationHelper().gotoCreateContactPage();
        ContactData contact = new ContactData(before.get(before.size() -1).getId(),"name3", "middlename1", "surname3", "nickname", "title", "company", "address", "+79000000000", "+79001000000", "849500000000", "849500000000", "email1@email.test", "email2@email.test", "email3@email.test", "http://123.ru", "9", "October", "2000", "5", "March", "2020", "test1", "address2", "home2", "comment");
        app.getContactHelper().createContact(contact);
        /* app.getContactHelper().fillContactForm(new ContactData("name1", "middlename1", "surname", "nickname", "title", "company", "address", "+79000000000", "+79001000000", "849500000000", "849500000000", "email1@email.test", "email2@email.test", "email3@email.test", "http://123.ru", "9", "October", "2000", "5", "March", "2020", "test1", "address2", "home2", "comment"), true);
        app.getContactHelper().submitContactCreation();
        app.getContactHelper().returntoHomePage(); */
        List<ContactData> after = app.getContactHelper().getContactList();

        Assert.assertEquals(after.size(), before.size() + 1);

        //after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId();
        before.add(contact);
        Comparator<? super ContactData> byId = (o1, o2) -> Integer.compare(o1.getId(), o2.getId());
        before.sort(byId);
        after.sort(byId);
        //Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
        Assert.assertEquals(before, after);
    }

}
