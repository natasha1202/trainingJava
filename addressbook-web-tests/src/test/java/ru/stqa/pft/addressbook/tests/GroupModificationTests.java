package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().groupPage();
        if (app.group().all().size() == 0){
           // app.group().createGroup(new GroupData("test01", "test", "text"));
            app.group().create(new GroupData().withGroupName("testA").withGroupHeader("testB"));

        }
    }

    @Test
    public void testGroupModification(){
        //List<GroupData> before = app.group().groupList();
        //Set<GroupData> before = app.group().all();
        Groups before = (Groups) app.group().all();
        GroupData modifiedGroup = before.iterator().next();
        //int index = before.size() - 1;
        //GroupData group = new GroupData(before.get(index).getId(), "test01", "test02", "test03");
        GroupData group = new GroupData()
               // .withId(before.get(index).getId())
                .withId(modifiedGroup.getId())
                .withGroupName("test21")
                .withGroupHeader("header")
                .withGroupFooter("footer");
        //int before = app.getGroupHelper().getGroupCount();
        // app.getGroupHelper().selectGroup(before-1);
        //app.group().modify(group, index);
        app.group().modify(group);
        //List<GroupData> after = app.group().groupList();
        // Set<GroupData> after = app.group().all();
        assertThat(app.group().groupCount(), equalTo(before.size()));
        Groups after = (Groups) app.group().all();
        //int after = app.getGroupHelper().getGroupCount();
        // Assert.assertEquals(after, before);
        // assertEquals(after.size(), before.size());

        //before.remove(index);
        //before.remove(modifiedGroup);
        //before.add(group);
        /* Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId); */
        // Assert.assertEquals(new HashSet<Object>(before) ,new HashSet<Object>(after));
        //Assert.assertEquals(before, after);
        assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));
    }

}
