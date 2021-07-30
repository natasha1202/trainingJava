package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

    @Test
    public void addNewContact(){
        app.goTo().homePage();
        Contacts before = (Contacts) app.contact().all();
        app.goTo().createContactPage();
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
        Contacts after = (Contacts) app.contact().all();
        assertThat(after.size(), equalTo(before.size() + 1));

        //contact.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt());
        //assertThat(after, equalTo(before.withAdded(contact)));

        assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt()))));
    }

}
