package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTests extends TestBase {

    @BeforeMethod

    public void ensurePreconditions(){
        app.goTo().homePage();
        if ( app.contact().all().size() == 0){
            app.contact().create(new ContactData()
                    .withGivenName("name1")
                    .withSurname("surname1")
                    .withCompany("abcIT")
                    .withCell("+79000000000")
                    .withMainEmail("email@test.ru")
                    .withGroup("test1"));
        }
    }

    @Test
    public void testContactDeletion(){
        Contacts before = (Contacts) app.contact().all();
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        Contacts after = (Contacts) app.contact().all();
        assertThat(after.size(), equalTo(before.size() - 1));
        assertThat(after, equalTo(before.without(deletedContact)));

    }


}
