package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAssignGroup extends TestBase{


    @BeforeMethod
    public void ensurePreconditions(){
        Groups groups = app.db().groups();
        if (groups.size() == 0){
            app.goTo().groupPage();
            GroupData group = new GroupData();
            app.group().create(group.withGroupName("new_test"));
        }
        Contacts contacts = app.db().contacts();
        if ( contacts.size() == 0){
            app.goTo().homePage();
            app.contact().create(new ContactData()
                    .withGivenName("name1")
                    .withSurname("surname1")
            );
        }
    }

    @Test
    public void assignGroupToContact() throws InterruptedException {
        Groups groups = app.db().groups();
        List<Groups> groupList = new ArrayList<Groups>(Collections.singleton(app.db().groups()));
        ContactData assigningContact = app.db().contacts().iterator().next();
        Groups groupsBefore = assigningContact.getGroups();
        GroupData assigningGroup = new GroupData();
        if(groupList.size() == groupsBefore.size()){
            app.goTo().groupPage();
            app.group().create(assigningGroup.withGroupName("new_test_group"));
        } else {groupList.removeAll(groupsBefore);
            assigningGroup = groups.iterator().next();
        }
        app.goTo().homePage();
        TimeUnit.SECONDS.sleep(5);
        app.contact().chooseGroup(assigningGroup.getId());
        app.contact().selectedContactById(assigningContact.getId());
        app.contact().addToGroup();
        Groups groupsAfter = app.db().contacts(assigningContact.getId()).getGroups();
        assertThat(groupsAfter, equalTo(groupsBefore.withAdded(assigningGroup)));
    }

}
