package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddressTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        if (app.contact().all().size() == 0){
            app.contact().create(new ContactData()
                    .withGivenName("Alex")
                    .withSurname("Lex")
                    .withFirstAddress("myAddress 1")
                    .withSecondAddress("second one"));
        }
    }


    @Test
    public void testContactAddress(){
        app.goTo().homePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

         assertThat(contact.getFirstAddress(), equalTo(contactInfoFromEditForm.getFirstAddress()));
    }
}
