package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void addNewContact(){
        gotoCreateContactPage();
        fillContactForm(new ContactData("name1", "middlename1", "surname", "nickname", "title", "company", "address", "+79000000000", "+79001000000", "849500000000", "849500000000", "email1@email.test", "email2@email.test", "email3@email.test", "http://123.ru", "//option[. = '9']", "//option[. = 'October']", "2000", "//option[. = '5']", "//option[. = 'March']", "2020", "//option[. = 'test1']", "address2", "home2", "comment"));
        submitContactCreation();
        returntoHomePage();
    }

}
