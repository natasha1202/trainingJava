package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().groupPage();
        if ( app.group().groupList().size() == 0){
           // app.group().createGroup(new GroupData("test01", "test", "text"));
            app.group().createGroup(new GroupData().withGroupName("removeGroup"));
        }
    }

    @Test
    public void testGroupDeletion() {
        List<GroupData> before = app.group().groupList();
        int index = before.size() - 1;
        // int before = app.getGroupHelper().getGroupCount();
        //app.getGroupHelper().selectGroup(before -1);
        app.group().deleteGroup(index);
        List<GroupData> after = app.group().groupList();
        //int after = app.getGroupHelper().getGroupCount();
        //Assert.assertEquals(after, before - 1);
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(index);
            Assert.assertEquals(before, after);

    }



}
