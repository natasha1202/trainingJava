package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;


public class ContactPhoneTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().homePage();
        if (app.contact().all().size() == 0){
            app.contact().create(new ContactData()
                    .withGivenName("Alex")
                    .withSurname("Lex")
                    .withCompany("company")
                    .withCell("+71231234000")
                    .withPhoneHome("123")
                    .withFax("54321")
                    .withPhoneHome("2002020")
                    .withMainEmail("alex@test.test"));
        }
    }

    @Test //(enabled = false)
    public void testContactPhones(){
        app.goTo().homePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);


    }
}
