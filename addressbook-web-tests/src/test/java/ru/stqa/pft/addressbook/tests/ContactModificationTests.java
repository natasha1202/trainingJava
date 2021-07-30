package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;


public class ContactModificationTests extends TestBase {

    @BeforeMethod

    public void ensurePreconditions(){
        app.goTo().homePage();
        if (app.contact().all().size() == 0){
            app.contact().create(new ContactData()
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
        Contacts before = (Contacts) app.contact().all();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData()
                .withId(modifiedContact.getId())
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
        app.contact().modify(contact);
        Contacts after = (Contacts) app.contact().all();
        assertEquals(after.size(), before.size());
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    }

}
