package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import ru.stqa.pft.addressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

    @Parameter(names = "-c", description = "Contact count")
    public int count;

    @Parameter(names = "-f", description = "Target file")
    public String file;

    @Parameter(names = "-d", description = "Data format")
    public String format;

    public static void main(String[] args) throws IOException {
        ContactDataGenerator generator = new ContactDataGenerator();
        JCommander jCommander = new JCommander(generator);
        try {
            jCommander.parse(args);
        } catch (ParameterException ex){
            jCommander.usage();
            return;
        }
        generator.run();
    }

    private void run() throws IOException {
        List<ContactData> contacts = generateContacts(count);
        if(format.equals("csv")){
            saveAsCsv(contacts, new File(file));
        } else if (format.equals("xml")) {
            saveAsXml(contacts, new File(file));
        } else if (format.equals("json")) {
            saveAsJson(contacts, new File(file));
        } else {
            System.out.println("Unrecognized format " + format);
        }

    }

    private void saveAsJson(List<ContactData> contacts, File file) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        String json = gson.toJson(contacts);
        Writer writer = new FileWriter(file);
        writer.write(json);
        writer.close();
    }

    private void saveAsXml(List<ContactData> contacts, File file) throws IOException {
        XStream xstream = new XStream();
        xstream.processAnnotations(ContactData.class);
        String xml = xstream.toXML(contacts);
        Writer writer = new FileWriter(file);
        writer.write(xml);
        writer.close();
    }

    private void saveAsCsv(List<ContactData> contacts, File file) throws IOException {
        System.out.println(new File(".").getAbsolutePath());
        Writer writer = new FileWriter(file);
        for (ContactData contact : contacts){
            writer.write(String.format("%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s\n",
                    contact.getGivenName(),
                    contact.getMiddleName(),
                    contact.getSurname(),
                    contact.getNickname(),
                    contact.getTitle(),
                    contact.getCompany(),
                    contact.getFirstAddress(),
                    contact.getPhoneHome(),
                    contact.getCell(),
                    contact.getPhoneOffice(),
                    contact.getFax(),
                    contact.getMainEmail(),
                    contact.getEmail2(),
                    contact.getEmail3(),
                    contact.getHomepageURL(),
                    contact.getBirthdayDay(),
                    contact.getBirthdayMonth(),
                    contact.getBirthdayYear(),
                    contact.getAnniversaryDay(),
                    contact.getAnniversaryMonth(),
                    contact.getAnniversaryYear(),
                    contact.getGroup(),
                    contact.getSecondAddress(),
                    contact.getPhoneAlternative(),
                    contact.getNotes()));
        }
        writer.close();
    }

    private List<ContactData> generateContacts(int count) {
        List<ContactData> contacts = new ArrayList<ContactData>();
        for(int i = 0; i < count; i++){
            contacts.add(new ContactData().withGivenName(String.format("name %s", i))
                    .withMiddleName(String.format("middle %s", i))
                    .withSurname(String.format("surname %s", i))
                    .withNickname(String.format("nick %s", i))
                    .withTitle(String.format("title %s", i))
                    .withCompany(String.format("company %s", i))
                    .withFirstAddress(String.format("address %s", i))
                    .withPhoneHome("12345" + i)
                    .withCell("+7 (123) 123 45 6" + i)
                    .withPhoneOffice("812345" + i)
                    .withFax("1111-222" + i)
                    .withMainEmail("email0" + i + "@test.test")
                    .withEmail2("email2" + i + "@test.test")
                    .withEmail3("email3" + i + "@test.test")
                    .withHomepageURL("http://123" + i)
                    .withBirthdayDay("11")
                    .withBirthdayMonth("April")
                    .withBirthdayYear("2000")
                    .withAnniversaryDay("5")
                    .withAnniversaryMonth("May")
                    .withAnniversaryYear("2018")
                    .withGroup("test 1")
                    .withSecondAddress(String.format("new address %s", i))
                    .withPhoneAlternative("2012345"+ i)
                    .withNotes("comment")
            );
        }
        return  contacts;

    }


}
