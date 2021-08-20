package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        if (app.db().groups().size() == 0){
        app.goTo().groupPage();
     //   if (app.group().all().size() == 0){
            app.group().create(new GroupData().withGroupName("testA").withGroupHeader("testB"));

        }
    }

    @Test
    public void testGroupModification(){
        Groups before = app.db().groups();
        GroupData modifiedGroup = before.iterator().next();
        app.goTo().groupPage();
        GroupData group = new GroupData()
                .withId(modifiedGroup.getId())
                .withGroupName("test21")
                .withGroupHeader("header")
                .withGroupFooter("footer");

        app.group().modify(group);
        assertThat(app.group().groupCount(), equalTo(before.size()));
        Groups after = app.db().groups();
        assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));
        verifyGroupListInUI();
    }



}
