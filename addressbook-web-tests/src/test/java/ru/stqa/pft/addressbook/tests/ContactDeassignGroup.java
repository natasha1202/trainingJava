package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.List;
import java.util.stream.Collectors;

public class ContactDeassignGroup extends  TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        if ( app.db().contacts().size() == 0){
            Groups groups = app.db().groups();
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
        app.contact().selectGroupFromDropdown(assignedGroup.getId(), assignedGroup);
        ContactData deassignedContact = (ContactData) app.contact().all();
        app.contact().selectedContactById(deassignedContact.getId());
        app.contact().removeFromGroup();
        app.goTo().homePage();


    }

    private GroupData findGroupWithContact(List<GroupData> groupList) {
        int contactsCount;
        GroupData groupWithContact = new GroupData();
        for(GroupData group: groupList){
            contactsCount = group.getContacts().size();
            if (contactsCount > 0){
                groupWithContact = group;
             //   groupWithContact = groupList.get(group.getId());
            //    groupWithContact.iterator().next();
                break;
            }
        }
        return groupWithContact;
    }
}
