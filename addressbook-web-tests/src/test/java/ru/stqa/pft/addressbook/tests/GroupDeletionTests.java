package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;
import java.util.Set;

public class GroupDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().groupPage();
        if ( app.group().groupList().size() == 0){
           // app.group().createGroup(new GroupData("test01", "test", "text"));
            app.group().create(new GroupData().withGroupName("removeGroup"));
        }
    }

    @Test
    public void testGroupDeletion() {
        //List<GroupData> before = app.group().groupList();
        Set<GroupData> before = app.group().all();
        GroupData deletedGroup = before.iterator().next();
        int index = before.size() - 1;
        // int before = app.getGroupHelper().getGroupCount();
        //app.getGroupHelper().selectGroup(before -1);
        //app.group().delete(index);
        app.group().delete(deletedGroup);
        // List<GroupData> after = app.group().groupList();
        Set<GroupData> after = app.group().all();
        //int after = app.getGroupHelper().getGroupCount();
        //Assert.assertEquals(after, before - 1);
        Assert.assertEquals(after.size(), before.size() - 1);

        //before.remove(index);
        before.remove(deletedGroup);
            Assert.assertEquals(before, after);

    }



}
