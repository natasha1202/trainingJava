package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.getNavigationHelper().gotoGroupPage();
        List<GroupData> before = app.getGroupHelper().getGroupList();
       // int before = app.getGroupHelper().getGroupCount();
        GroupData group = new GroupData("test12", null, null);
        app.getGroupHelper().createGroup(group);
      /* app.getGroupHelper().initGroupCreation();
      app.getGroupHelper().fillGroupForm(new GroupData("test11", null, null));
      app.getGroupHelper().submitGroupCreation();
      app.getGroupHelper().returntoGroupPage(); */
        List<GroupData> after = app.getGroupHelper().getGroupList();
       // int after = app.getGroupHelper().getGroupCount();
       // Assert.assertEquals(after, before + 1);
        Assert.assertEquals(after.size(), before.size() + 1);

        /* int max = 0;
        for (GroupData g : after){
            if (g.getId() > max){
                max = g.getId();
            }
        } */

        after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId();
        // group.setId(max);
        before.add(group);
        Assert.assertEquals(new HashSet<Object>(before) ,new HashSet<Object>(after));
    }

}
