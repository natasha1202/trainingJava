package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroupHelper extends HelperBase {

    public GroupHelper(WebDriver wd) {
        super(wd);
    }

    public void returntoGroupPage() {
        if (isElementPresent(By.tagName("h1"))
                && wd.findElement(By.tagName("h1")).getText().equals("Groups")
                && isElementPresent(By.name("new"))){
            return;
        }
        click(By.linkText("group page"));
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getGroupName());
        type(By.name("group_header"), groupData.getGroupHeader());
        type(By.name("group_footer"), groupData.getGroupFooter());
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void deleteSelectedGroups() {
        click(By.name("delete"));
    }

    public void selectGroup(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void selectGroupById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    public void initGroupModification() {
        click(By.name("edit"));
    }

    public void submitGroupModification() {
        click(By.name("update"));
    }

    public void create(GroupData group) {
        initGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
        groupCache = null;
        returntoGroupPage();
    }

    public void modify(GroupData group, int index) {
        selectGroup(index);
        initGroupModification();
        fillGroupForm(group);
        submitGroupModification();
        returntoGroupPage();
    }

    public void modify(GroupData group) {
        selectGroupById(group.getId());
        initGroupModification();
        fillGroupForm(group);
        submitGroupModification();
        groupCache = null;
        returntoGroupPage();
    }

    public void delete(int index) {
        selectGroup(index);
        deleteSelectedGroups();
        returntoGroupPage();
    }

    public void delete(GroupData group) {
        selectGroupById(group.getId());
        deleteSelectedGroups();
        groupCache = null;
        returntoGroupPage();
    }

    public boolean isThereAGroup() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getGroupCount() {
        return wd.findElements(By.name("selected[]")).size(); // List
    }

    public List<GroupData> groupList() {
        List<GroupData> groups = new ArrayList<GroupData>();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements){
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            //GroupData group = new GroupData(name, null, null)
            // groups.add(group);
            groups.add(new GroupData().withId(id).withGroupName(name));

        }
        return groups;
    }

    /*public Set<GroupData> all() {
        Set<GroupData> groups = new HashSet<GroupData>();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements){
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            groups.add(new GroupData().withId(id).withGroupName(name));

        }
        return groups;
    }*/

    private Groups groupCache = null;

    public Set<GroupData> all() {
        if (groupCache != null){
            return new Groups(groupCache);
        }
        //Groups groups = new Groups();
        groupCache = new Groups();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements){
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            //groups.add(new GroupData().withId(id).withGroupName(name));
            groupCache.add(new GroupData().withId(id).withGroupName(name));

        }
        return new Groups(groupCache); //groups;
    }

}
