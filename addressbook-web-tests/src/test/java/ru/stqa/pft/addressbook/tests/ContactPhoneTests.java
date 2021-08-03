package ru.stqa.pft.addressbook.tests;

import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactPhoneTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        if (app.contact().all().size() == 0){
            app.contact().create(new ContactData()
                    .withGivenName("Alex")
                    .withSurname("Lex")
                    .withCompany("company")
                    .withPhoneHome("123")
                    .withCell("+71231234000")
                    .withPhoneOffice("2002020")
                    .withFax("54321")
                    .withPhoneAlternative("12345")
                    .withMainEmail("alex@test.test"));
        }
    }



    @Test
    public void testContactPhones(){
        app.goTo().homePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(contact.getPhoneHome(), equalTo(contactInfoFromEditForm.getPhoneHome()));
        assertThat(contact.getCell(), equalTo(contactInfoFromEditForm.getCell()));
        assertThat(contact.getPhoneOffice(), equalTo(contactInfoFromEditForm.getPhoneOffice()));
    }
}
