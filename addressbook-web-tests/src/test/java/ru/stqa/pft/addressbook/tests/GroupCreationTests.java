package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;

public class GroupCreationTests extends TestBase {

    @DataProvider
    public Iterator<Object[]> validGroups(){
        List<Object[]> list = new ArrayList<Object[]>();
       // list.add(new Object[]{"test1", "header1", "footer1"});
       // list.add(new Object[]{"test2", "header2", "footer2"});
       // list.add(new Object[]{"test3", "header3", "footer3"});
        list.add(new Object[] {new GroupData().withGroupName("test1").withGroupFooter("header1").withGroupHeader("footer1")});
        list.add(new Object[] {new GroupData().withGroupName("test2").withGroupFooter("header2").withGroupHeader("footer2")});
        list.add(new Object[] {new GroupData().withGroupName("test3").withGroupFooter("header3").withGroupHeader("footer3")});
        return list.iterator();
    }


    @Test (dataProvider = "validGroups")
    //public void testGroupCreation(String name, String header, String footer) {
    public void testGroupCreation(GroupData group) {
        //GroupData group = new GroupData().withGroupName(name).withGroupFooter(header).withGroupHeader(footer);
        app.goTo().groupPage();
        // List<GroupData> before = app.group().groupList();
        //Set<GroupData> before = app.group().all();
        Groups before = (Groups) app.group().all();
        // int before = app.getGroupHelper().getGroupCount();
        // GroupData group = new GroupData("test22", null, null);
        //GroupData group = new GroupData().withGroupName("test12").withGroupFooter("test").withGroupHeader("text");
        app.group().create(group);
        // List<GroupData> after = app.group().groupList();
        //Set<GroupData> after = app.group().all();
        assertThat(app.group().groupCount(), equalTo(before.size() + 1));
        Groups after = (Groups) app.group().all();
        // int after = app.getGroupHelper().getGroupCount();
        // Assert.assertEquals(after, before + 1);
        // Assert.assertEquals(after.size(), before.size() + 1);
        //assertThat(after.size(), equalTo(before.size() + 1));

        /* int max = 0;
        for (GroupData g : after){
            if (g.getId() > max){
                max = g.getId();
            }
        } */

        // after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId();
        // group.setId(max);
        //group.withId(after.stream().mapToInt((g)-> g.getId()).max().getAsInt());
        //before.add(group);
        //Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        //before.sort(byId);
        //after.sort(byId);
        //Assert.assertEquals(new HashSet<Object>(before) ,new HashSet<Object>(after));
        //Assert.assertEquals(before, after);
        //assertThat(after, equalTo(before));
        //assertThat(after, equalTo(before.withAdded(group)));

        assertThat(after, equalTo(
                before.withAdded(group.withId(after.stream().mapToInt((g)-> g.getId()).max().getAsInt()))));
    }

    @Test
    public void testBadGroupCreation() {
        app.goTo().groupPage();
        Groups before = (Groups) app.group().all();
        GroupData group = new GroupData().withGroupName("test2'");
        app.group().create(group);
        assertThat(app.group().groupCount(), equalTo(before.size()));
        Groups after = (Groups) app.group().all();
        assertThat(after, equalTo(before));
    }

}
