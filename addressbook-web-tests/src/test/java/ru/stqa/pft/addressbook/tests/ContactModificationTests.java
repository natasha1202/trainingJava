package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactModificationTests extends TestBase {

    @BeforeMethod

    public void ensurePreconditions(){
        if (app.db().contacts().size() == 0){
            Groups groups = app.db().groups();
            app.goTo().homePage();
            app.contact().create(new ContactData()
                    .withGivenName("Name")
                    .withSurname("Surname")
                    .withCompany("abc")
                    .withCell("+71231234000")
                    .withMainEmail("email@test.test")
                    .inGroups(groups.iterator().next())
                 //   .withGroup("test1")
            );
        }
    }

    @Test
    public void testContactModification(){
        Contacts before = app.db().contacts();
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
                .withCell("+71111234545")
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
        app.goTo().homePage();
        app.contact().modify(contact);
        assertThat(app.contact().contactCount(), equalTo(before.size()));
        Contacts after = app.db().contacts();
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
        verifyContactListInUI();
    }

}
