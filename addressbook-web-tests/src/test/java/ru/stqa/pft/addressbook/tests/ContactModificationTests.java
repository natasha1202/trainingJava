package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

    @BeforeMethod

    public void ensurePreconditions(){
        app.goTo().homePage();
        if (app.contact().contactList().size() == 0){
            app.contact().create(new ContactData() //new ContactData("name1", "middlename1", "surname", "nickname", "title", "company", "address", "+79000000000", "+79001000000", "849500000000", "849500000000", "email1@email.test", "email2@email.test", "email3@email.test", "http://123.ru", "9", "October", "2000", "5", "March", "2020", "test01", "address2", "home2", "comment"));
                    .withGivenName("Name")
                    .withSurname("Surname")
                    .withCompany("abc")
                    .withCell("+71231234000")
                    .withMainEmail("email@test.test")
                    .withGroup("test1"));
        }
    }

    @Test
    public void testContactModification(){
        List<ContactData> before = app.contact().contactList();
        int index = before.size() - 1;
        //ContactData contact = new ContactData(before.get(index).getId(), "user", "mn", "userSN", "nick", "dr", "IT", "new", "+79010010010", "+79010010010", "849500000123", "849500000123", "user1@email.test", "user1email2@email.test", "user1email3@email.test", "http://1234.ru", "19", "April", "1978", "15", "March", "2010",null, "address new", "phone", "note");
        ContactData contact = new ContactData()
                .withId(before.get(index).getId())
                .withGivenName("Max")
                .withMiddleName("Rex")
                .withSurname("Mustermann")
                .withNickname("jojo")
                .withTitle("title")
                .withCompany("company")
                .withFirstAddress("NewTown")
                .withPhoneHome("2222111")
                .withCell("+70001234545")
                .withPhoneOffice("1234321")
                .withFax("+490987653214")
                .withMainEmail("my.email@test.test")
                .withEmail2("name2@test.test")
                .withEmail3("surname3@test.test")
                .withHomepageURL("http://1234.ru")
                .withBirthdayDay("17")
                .withBirthdayMonth("May")
                .withBirthdayYear("1997")
                .withAnniversaryDay("20")
                .withAnniversaryMonth("June")
                .withAnniversaryYear("2018")
                .withSecondAddress("second address")
                .withPhoneAlternative("home2")
                .withNotes("my comment");
        app.contact().modify(index, contact);
        List<ContactData> after = app.contact().contactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(contact);
        Comparator<? super ContactData> byId = (o1, o2) -> Integer.compare(o1.getId(), o2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }


}
