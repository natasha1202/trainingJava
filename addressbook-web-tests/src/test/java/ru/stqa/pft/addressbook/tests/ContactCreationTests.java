package ru.stqa.pft.addressbook.tests;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import org.openqa.selenium.json.TypeToken;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {


    @DataProvider
    public Iterator<Object[]> validContactsFromXml() throws IOException {
        try(BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml")))){
        String xml = "";
        String line = reader.readLine();
        while (line != null){
            xml += line;
            line = reader.readLine();
        }
        XStream xstream = new XStream();
        xstream.processAnnotations(ContactData.class);
        List<ContactData> contacts = (List<ContactData>) xstream.fromXML(xml);
        return contacts.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();}
    }

    @DataProvider
    public Iterator<Object[]> validContactsFromJson() throws IOException {
        try(BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.json")))){
        String json = "";
        String line = reader.readLine();
        while (line != null){
            json += line;
            line = reader.readLine();
        }
        Gson gson = new Gson();
        List<ContactData> contacts = gson.fromJson(json, new TypeToken<List<ContactData>>(){}.getType());
        return contacts.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();}
    }

    @DataProvider
    public Iterator<Object[]> validContactsFromScv() throws IOException {
        List<Object[]> list = new ArrayList<Object[]>();
        try(BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.csv")))){
        String line = reader.readLine();
        Groups groups = app.db().groups();
        while (line != null){
            String[] split = line.split(";"); // меджу кавычками указывается разделитель, для csv-файла это ;
            list.add(new Object[]{new  ContactData().withGivenName(split[0])
                    .withMiddleName(split[1])
                    .withSurname(split[2])
                    .withNickname(split[3])
                    .withTitle(split[4])
                    .withCompany(split[5])
                    .withFirstAddress(split[6])
                    .withPhoneHome(split[7])
                    .withCell(split[8])
                    .withPhoneOffice(split[9])
                    .withFax(split[10])
                    .withMainEmail(split[11])
                    .withEmail2(split[12])
                    .withEmail3(split[13])
                    .withHomepageURL(split[14])
                    .withBirthdayDay(split[15])
                    .withBirthdayMonth(split[16])
                    .withBirthdayYear(split[17])
                    .withAnniversaryDay(split[18])
                    .withAnniversaryMonth(split[19])
                    .withAnniversaryYear(split[20])
                  //  .withGroup(split[21])
                    .inGroups(groups.iterator().next())
                    .withSecondAddress(split[22])
                    .withPhoneAlternative(split[23])
                    .withNotes(split[24])});
            line = reader.readLine();
        }
        return list.iterator();}
    }

    @Test (dataProvider = "validContactsFromJson")
    public void addNewContact(ContactData contact){
        Contacts before = app.db().contacts();
        app.goTo().createContactPage();
        app.contact().create(contact);
        Contacts after = app.db().contacts();
        assertThat(after.size(), equalTo(before.size() + 1));
        assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt()))));
    }

    @Test
    public void addBadContact(){
        Groups groups = app.db().groups();
        Contacts before = app.db().contacts();
        ContactData contact = new ContactData()
                .withGivenName("firstName'")
                .withMiddleName("middle")
                .withSurname("SurName'")
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
                .withAnniversaryYear("abc")
              //  .withGroup("test01")
                .withSecondAddress("new address")
                .withPhoneAlternative("321123123")
                .withNotes("comment")
                .inGroups(groups.iterator().next());
        app.goTo().createContactPage();
        app.contact().create(contact);
        assertThat(app.contact().contactCount(), equalTo(before.size()));
        Contacts after = app.db().contacts();
        assertThat(after, equalTo(before));
    }

}
