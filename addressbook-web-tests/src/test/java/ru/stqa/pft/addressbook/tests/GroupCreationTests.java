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
            String[] split = line.split(";"); // ?????????? ?????????????????? ?????????????????????? ??????????????????????, ?????? csv-?????????? ?????? ;
            list.add(new Object[]{new  GroupData().withGroupName(split[0]).withGroupHeader(split[1]).withGroupFooter(split[2])});
            line = reader.readLine();
        }
        return list.iterator();}
    }

    @Test (dataProvider = "validGroupsFromJson")
    public void testGroupCreation(GroupData group) {
        Groups before = app.db().groups();
        app.goTo().groupPage();
        app.group().create(group);
        assertThat(app.group().groupCount(), equalTo(before.size() + 1));
        Groups after = app.db().groups();
        assertThat(after, equalTo(
                before.withAdded(group.withId(after.stream().mapToInt((g)-> g.getId()).max().getAsInt()))));
        verifyGroupListInUI();
    }

    @Test
    public void testBadGroupCreation() {
        Groups before = app.db().groups();
        app.goTo().groupPage();
        GroupData group = new GroupData().withGroupName("test2'");
        app.group().create(group);
        assertThat(app.group().groupCount(), equalTo(before.size()));
        Groups after = app.db().groups();
        assertThat(after, equalTo(before));
        verifyGroupListInUI();
    }

}
