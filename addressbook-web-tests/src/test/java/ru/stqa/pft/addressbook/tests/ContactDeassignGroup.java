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

public class ContactDeassignGroup extends  TestBase{

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
                    .inGroups(groups.iterator().next())
            );
        }
    }

    @Test
    public void deassignGroupFromContact() {
        app.goTo().homePage();
        List <GroupData> groupList = app.db().groups().stream().collect(Collectors.toList());
        GroupData assignedGroup = findGroupWithContact(groupList);
        List <ContactData> assignedContactsBefore = assignedGroup.getContacts().stream().collect(Collectors.toList());
        app.contact().filterByGroup(assignedGroup.getId());
        ContactData deassignedContact = (ContactData) app.contact().all().iterator().next();
        app.contact().selectedContactById(deassignedContact.getId());
        app.contact().removeFromGroup();
        List <ContactData> assignedContactsAfter = assignedGroup.getContacts().stream().collect(Collectors.toList());
        assertThat(assignedContactsAfter, equalTo(assignedContactsBefore.remove(deassignedContact)));
        //assertThat(assignedContactsAfter, equalToObject(assignedContactsBefore.remove(assigningContact)));

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
