package ru.stqa.pft.addressbook.tests;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import org.openqa.selenium.json.TypeToken;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {

    @DataProvider
    public Iterator<Object[]> validGroupsFromXml() throws IOException {
        try(BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.xml")))){
            String xml = "";
            String line = reader.readLine();
            while (line != null){
                xml += line;
                line = reader.readLine();
            }
            XStream xstream = new XStream();
            xstream.processAnnotations(GroupData.class);
            List<GroupData> groups = (List<GroupData>) xstream.fromXML(xml);
            return groups.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
        }
    }

    @DataProvider
    public Iterator<Object[]> validGroupsFromJson() throws IOException {
        try(BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.json")))){
        String json = "";
        String line = reader.readLine();
        while (line != null){
            json += line;
            line = reader.readLine();
        }
        Gson gson = new Gson();
        List<GroupData> groups = gson.fromJson(json, new TypeToken<List<GroupData>>(){}.getType()); // List<GroupData>.class
        return groups.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();}
    }

    @DataProvider
    public Iterator<Object[]> validGroupsFromScv() throws IOException {
        List<Object[]> list = new ArrayList<Object[]>();
        try(BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.csv")))){
        String line = reader.readLine();
        while (line != null){
            String[] split = line.split(";"); // меджу кавычками указывается разделитель, для csv-файла это ;
            list.add(new Object[]{new  GroupData().withGroupName(split[0]).withGroupHeader(split[1]).withGroupFooter(split[2])});
            line = reader.readLine();
        }
        return list.iterator();}
    }

    /*
    @DataProvider
    public Iterator<Object[]> validGroups() throws IOException {
       List<Object[]> list = new ArrayList<Object[]>();
       list.add(new Object[]{"test1", "header1", "footer1"});
       list.add(new Object[]{"test2", "header2", "footer2"});
       list.add(new Object[]{"test3", "header3", "footer3"});
        return list.iterator();
    }
    */


    @Test (dataProvider = "validGroupsFromJson")
    public void testGroupCreation(GroupData group) {
        app.goTo().groupPage();
        Groups before = (Groups) app.group().all();
        app.group().create(group);
        assertThat(app.group().groupCount(), equalTo(before.size() + 1));
        Groups after = (Groups) app.group().all();
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

        /*
     @Test (dataProvider = "validGroups")
    //public void testGroupCreation() {
        app.goTo().groupPage();
        // List<GroupData> before = app.group().groupList();
        // Set<GroupData> before = app.group().all();
        Groups before = (Groups) app.group().all();
        // int before = app.getGroupHelper().getGroupCount();
        // GroupData group = new GroupData("test22", null, null);
        GroupData group = new GroupData().withGroupName("test12").withGroupFooter("test").withGroupHeader("text");
        app.group().create(group);
        // List<GroupData> after = app.group().groupList();
        // Set<GroupData> after = app.group().all();
        assertThat(app.group().groupCount(), equalTo(before.size() + 1));
        Groups after = (Groups) app.group().all();
        // int after = app.getGroupHelper().getGroupCount();
        // Assert.assertEquals(after, before + 1);
        // Assert.assertEquals(after.size(), before.size() + 1);
        // assertThat(after.size(), equalTo(before.size() + 1));

    // after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId();
    // group.setId(max);
    // group.withId(after.stream().mapToInt((g)-> g.getId()).max().getAsInt());
    // before.add(group);
    // Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    // before.sort(byId);
    // after.sort(byId);
    // Assert.assertEquals(new HashSet<Object>(before) ,new HashSet<Object>(after));
    // Assert.assertEquals(before, after);
    // assertThat(after, equalTo(before));
    // assertThat(after, equalTo(before.withAdded(group)));
    assertThat(after, equalTo(
            before.withAdded(group.withId(after.stream().mapToInt((g)-> g.getId()).max().getAsInt()))));
    }
     */

    /*
     @Test (dataProvider = "validGroups")
    public void testGroupCreation(String name, String header, String footer) {
        GroupData group = new GroupData().withGroupName(name).withGroupFooter(header).withGroupHeader(footer);
        app.goTo().groupPage();
        Groups before = (Groups) app.group().all();
        app.group().create(group);
        assertThat(app.group().groupCount(), equalTo(before.size() + 1));
        Groups after = (Groups) app.group().all();
        assertThat(after, equalTo(
            before.withAdded(group.withId(after.stream().mapToInt((g)-> g.getId()).max().getAsInt()))));
    }
     */

    /*
     @Test (dataProvider = "validGroups")
    public void testGroupCreation(GroupData group) {
        app.goTo().groupPage();
        Groups before = (Groups) app.group().all();
        app.group().create(group);
        assertThat(app.group().groupCount(), equalTo(before.size() + 1));
        Groups after = (Groups) app.group().all();
        assertThat(after, equalTo(
            before.withAdded(group.withId(after.stream().mapToInt((g)-> g.getId()).max().getAsInt()))));
    }
     */
}
