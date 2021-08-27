package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.List;
import java.util.stream.Collectors;

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

        List<GroupData> groupList = app.db().groups().stream().collect(Collectors.toList());
        ContactData assigningContact = app.db().contacts().iterator().next();
     //   Groups groupsOfContact = assigningContact.getGroups();
        GroupData assigningGroup = app.db().groups().iterator().next();
        List <ContactData> assignedContactsBefore = assigningGroup.getContacts().stream().collect(Collectors.toList());
        app.goTo().homePage();
        app.contact().selectedContactById(assigningContact.getId());
        app.contact().chooseGroup(assigningGroup.getId(), assigningGroup);
        app.contact().addToGroup();
        List <ContactData> assignedContactsAfter = assigningGroup.getContacts().stream().collect(Collectors.toList());
        assertThat(assignedContactsAfter, equalTo(assignedContactsBefore.add(assigningContact)));
    }
}
