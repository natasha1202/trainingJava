package ru.stqa.pft.addressbook.tests;

import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

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

        // assertThat(contact.getPhoneHome(), equalTo(cleaned(contactInfoFromEditForm.getPhoneHome())));
        // assertThat(contact.getCell(), equalTo(cleaned(contactInfoFromEditForm.getCell())));
        // assertThat(contact.getPhoneOffice(), equalTo(cleaned(contactInfoFromEditForm.getPhoneOffice())));
        assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
    }

   /* private String mergePhones(ContactData contact) {
        String result = "";
        if(contact.getPhoneHome() != null){
            result = result + contact.getPhoneHome();

        }
        return result;
    } */

    private String mergePhones(ContactData contact) {
        return Arrays.asList(contact.getPhoneHome(), contact.getCell(), contact.getPhoneOffice(), contact.getPhoneAlternative())
                .stream().filter((s) -> ! s.equals(""))
                .map(ContactPhoneTests::cleaned)
                .collect(Collectors.joining("\n"));
    }


    public static String cleaned(String phone){
        return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
    }
}
