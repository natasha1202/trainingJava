package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeassignGroup extends  TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        Groups groups = app.db().groups();
        if (groups.size() == 0){
            app.goTo().groupPage();
            GroupData group = new GroupData();
            app.group().create(group.withGroupName("new_test"));
        }
        Contacts contacts = app.db().contacts();
        if (contacts.size() == 0){
            app.goTo().homePage();
            app.contact().create(new ContactData()
                    .withGivenName("name1")
                    .withSurname("surname1")
                    .inGroups(groups.iterator().next())
            );
        }
    }

    @Test
    public void deassignGroupFromContact() throws InterruptedException {
        List <GroupData> groupList = app.db().groups().stream().collect(Collectors.toList());
        GroupData deassignedGroup = findGroupWithContact(groupList);
        app.goTo().homePage();
        if(deassignedGroup.getGroupName() == null){
            assignContactToGroup();
            GroupData newAssignedGroup = findGroupWithContact(groupList);
            deassignedGroup = newAssignedGroup;
            TimeUnit.SECONDS.sleep(5);
            app.goTo().homePage();
        }
        //TimeUnit.SECONDS.sleep(2);
        //List<Contacts> contactsOfGroup = Collections.singletonList(assignedGroup.getContacts());
        app.contact().filterByGroup(deassignedGroup.getId());
        ContactData deassigningContact = app.db().contacts(deassignedGroup.getContacts().iterator().next().getId());
        Groups groupsBefore = deassigningContact.getGroups();
        app.contact().selectedContactById(deassigningContact.getId());
        //TimeUnit.SECONDS.sleep(2);
        app.contact().removeFromGroup();
        Groups groupsAfter = app.db().contacts(deassigningContact.getId()).getGroups();
       // assignedContactsBefore = app.db().groups(assignedGroup.getId()).getContacts();
        //List <ContactData> assignedContactsBefore = assignedGroup.getContacts().stream().collect(Collectors.toList());
        //assignedContactsAfter = app.db().groups(assignedGroup.getId()).getContacts();
        //List <ContactData> assignedContactsAfter = assignedGroup.getContacts().stream().collect(Collectors.toList());
        //assertThat(assignedContactsAfter.size(), equalTo(assignedContactsBefore.size() - 1));
        //assertThat(assignedContactsAfter, equalTo(assignedContactsBefore.without(deassignedContact)));
        assertThat(groupsAfter, equalTo(groupsBefore.without(deassignedGroup)));

    }

    private void assignContactToGroup(){
                ContactData deassigningContact = app.db().contacts().iterator().next();
                GroupData deassigningGroup = app.db().groups().iterator().next();
                app.contact().chooseGroup(deassigningGroup.getId());
                app.contact().selectedContactById(deassigningContact.getId());
                app.contact().addToGroup();
    }

    private GroupData findGroupWithContact(List<GroupData> groupList) {
        int contactsCount;
        GroupData groupWithContact = new GroupData();
        for(GroupData group: groupList){
            contactsCount = group.getContacts().size();
            if (contactsCount > 0){
                groupWithContact = group;
                break;
            }
        }
        return groupWithContact;
    }
}


