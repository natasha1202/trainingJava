package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().groupPage();
        if ( app.group().all().size() == 0){
           // app.group().createGroup(new GroupData("test01", "test", "text"));
            app.group().create(new GroupData().withGroupName("removeGroup"));
        }
    }

    @Test
    public void testGroupDeletion() {
        //List<GroupData> before = app.group().groupList();
        //Set<GroupData> before = app.group().all();
        Groups before = (Groups) app.group().all();
        GroupData deletedGroup = before.iterator().next();
        int index = before.size() - 1;
        // int before = app.getGroupHelper().getGroupCount();
        //app.getGroupHelper().selectGroup(before -1);
        //app.group().delete(index);
        app.group().delete(deletedGroup);
        // List<GroupData> after = app.group().groupList();
        // Set<GroupData> after = app.group().all();
        assertThat(app.group().groupCount(), equalTo(before.size() - 1));
        Groups after = (Groups) app.group().all();
        //int after = app.getGroupHelper().getGroupCount();
        //Assert.assertEquals(after, before - 1);
        //assertEquals(after.size(), before.size() - 1);

        //before.remove(index);
        //before.remove(deletedGroup);
        assertThat(after, CoreMatchers.equalTo(before.without(deletedGroup)));
        //    Assert.assertEquals(before, after);

    }



}
