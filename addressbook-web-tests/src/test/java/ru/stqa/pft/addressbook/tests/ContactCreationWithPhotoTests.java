package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationWithPhotoTests extends TestBase{

    @Test
    public void addNewContactWithPhoto(){
        app.goTo().homePage();
        Contacts before = (Contacts) app.contact().all();
        app.goTo().createContactPage();
        File photo = new File("src/test/resources/mokona.png");
        ContactData contact = new ContactData()
                .withGivenName("userWithPhoto")
                .withSurname("userWithPhoto")
                .withPhoto(photo)
                .withGroup("test01");

        app.contact().createWithPhoto(contact);
        Contacts after = (Contacts) app.contact().all();
        assertThat(after.size(), equalTo(before.size() + 1));
    }

    @Test (enabled = true)
    public void testCurrentDir(){
        File currentDir = new File(".");
        System.out.println(currentDir.getAbsolutePath()); // C:\Users\nuvarova\Desktop\TrainingJava\trainingJava\addressbook-web-tests\.
        File photo = new File("src/test/resources/mokona.png");
        System.out.println(photo.getAbsolutePath());
        System.out.println(photo.exists());
    }


}
