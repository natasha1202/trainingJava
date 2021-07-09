package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test
    public void addNewContact(){
        app.goTo().homePage();
        List<ContactData> before = app.contact().contactList();
        app.goTo().createContactPage();
       // ContactData contact = new ContactData("name3", "middlename1", "surname3", "nickname", "title", "company", "address", "+79000000000", "+79001000000", "849500000000", "849500000000", "email1@email.test", "email2@email.test", "email3@email.test", "http://123.ru", "9", "October", "2000", "5", "March", "2020", "test1", "address2", "home2", "comment");
        ContactData contact = new ContactData()
                .withGivenName("firstName")
                .withMiddleName("middle")
                .withSurname("SurName")
                .withNickname("nick")
                .withTitle("dr")
                .withCompany("firma")
                .withFirstAddress("MyCity")
                .withPhoneHome("2222222")
                .withCell("+71231234545")
                .withPhoneOffice("1234567")
                .withFax("+491231234545")
                .withMainEmail("test@test.test")
                .withEmail2("email2@test.test")
                .withEmail3("email3@test.test")
                .withHomepageURL("http://myPage.ru")
                .withBirthdayDay("11")
                .withBirthdayMonth("April")
                .withBirthdayYear("2000")
                .withAnniversaryDay("21")
                .withAnniversaryMonth("December")
                .withAnniversaryYear("2019")
                .withGroup("test01")
                .withSecondAddress("new address")
                .withPhoneAlternative("321123123")
                .withNotes("comment");

        app.contact().create(contact);
        List<ContactData> after = app.contact().contactList();

        Assert.assertEquals(after.size(), before.size() + 1);

        before.add(contact);
        Comparator<? super ContactData> byId = (o1, o2) -> Integer.compare(o1.getId(), o2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }

}
