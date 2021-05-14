package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().groupPage();
        if (app.group().groupList().size() == 0){
           // app.group().createGroup(new GroupData("test01", "test", "text"));
            app.group().createGroup(new GroupData().withGroupName("testA").withGroupHeader("testB"));

        }
    }

    @Test
    public void testGroupModification(){
        List<GroupData> before = app.group().groupList();
        int index = before.size() - 1;
        //GroupData group = new GroupData(before.get(index).getId(), "test01", "test02", "test03");
        GroupData group = new GroupData()
                .withId(before.get(index).getId())
                .withGroupName("test21")
                .withGroupHeader("header")
                .withGroupFooter("footer");
        //int before = app.getGroupHelper().getGroupCount();
        // app.getGroupHelper().selectGroup(before-1);
        app.group().modifyGroup(group, index);
        List<GroupData> after = app.group().groupList();
        //int after = app.getGroupHelper().getGroupCount();
        // Assert.assertEquals(after, before);
        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(group);
        Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        // Assert.assertEquals(new HashSet<Object>(before) ,new HashSet<Object>(after));
        Assert.assertEquals(before, after);
    }

}
