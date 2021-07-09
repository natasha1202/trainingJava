package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.goTo().groupPage();
        List<GroupData> before = app.group().groupList();
       // int before = app.getGroupHelper().getGroupCount();
       // GroupData group = new GroupData("test22", null, null);
        GroupData group = new GroupData().withGroupName("test1").withGroupFooter("test").withGroupHeader("text");
        app.group().create(group);
        List<GroupData> after = app.group().groupList();
       // int after = app.getGroupHelper().getGroupCount();
       // Assert.assertEquals(after, before + 1);
        Assert.assertEquals(after.size(), before.size() + 1);

        /* int max = 0;
        for (GroupData g : after){
            if (g.getId() > max){
                max = g.getId();
            }
        } */

        // after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId();
        // group.setId(max);
        before.add(group);
        Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        //Assert.assertEquals(new HashSet<Object>(before) ,new HashSet<Object>(after));
        Assert.assertEquals(before, after);
    }

}
