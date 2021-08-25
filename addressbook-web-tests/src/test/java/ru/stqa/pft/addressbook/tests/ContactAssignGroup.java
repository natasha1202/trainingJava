package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

public class ContactAssignGroup extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        Groups groups = app.db().groups();
        if (groups.size() == 0){
            app.goTo().groupPage();
            GroupData group = new GroupData();
            app.group().create(group.withGroupName("new_test"));
        }
        if ( app.db().contacts().size() == 0){
            app.goTo().homePage();
            app.contact().create(new ContactData()
                    .withGivenName("name1")
                    .withSurname("surname1")
            );
        }
    }

    @Test
    public void assignGroupToContact(){
        GroupData group = app.db().groups().iterator().next();
        ContactData contact = app.db().contacts().iterator().next();
        app.goTo().homePage();





    }
}
