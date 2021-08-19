package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@XStreamAlias("group")
@Entity
@Table(name = "group_list")
public class GroupData {

    @Expose
    @Column(name = "group_name")
    private String groupName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupData groupData = (GroupData) o;

        if (id != groupData.id) return false;
        if (groupName != null ? !groupName.equals(groupData.groupName) : groupData.groupName != null) return false;
        if (groupHeader != null ? !groupHeader.equals(groupData.groupHeader) : groupData.groupHeader != null)
            return false;
        return groupFooter != null ? groupFooter.equals(groupData.groupFooter) : groupData.groupFooter == null;
    }

    @Override
    public int hashCode() {
        int result = groupName != null ? groupName.hashCode() : 0;
        result = 31 * result + (groupHeader != null ? groupHeader.hashCode() : 0);
        result = 31 * result + (groupFooter != null ? groupFooter.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }

    @Expose
    @Column(name = "group_header")
    @Type(type = "text")
    private String groupHeader;
    @Expose
    @Column(name = "group_footer")
    @Type(type = "text")
    private String groupFooter;

    @XStreamOmitField
    @Id
    @Column(name = "group_id")
    private int id = Integer.MAX_VALUE;

 /*   public GroupData(int id, String groupName, String groupHeader, String groupFooter) {
        this.id = id;
        this.groupName = groupName;
        this.groupHeader = groupHeader;
        this.groupFooter = groupFooter;
    } */

   /* @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupData groupData = (GroupData) o;

        return groupName != null ? groupName.equals(groupData.groupName) : groupData.groupName == null;
    } */

    /* public GroupData(String groupName, String groupHeader, String groupFooter) {
        this.id = Integer.MAX_VALUE;
        this.groupName = groupName;
        this.groupHeader = groupHeader;
        this.groupFooter = groupFooter;
    } */


    public String getGroupName() {
        return groupName;
    }

    @Override
    public String toString() {
        return "GroupData{" +
                "groupName='" + groupName + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getGroupHeader() {
        return groupHeader;
    }

    public String getGroupFooter() {
        return groupFooter;
    }

    public GroupData withId(int id) {
        this.id = id;
        return this;
    }

    public GroupData withGroupName(String groupName) {
        this.groupName = groupName;
        return this;
    }

    public GroupData withGroupHeader(String groupHeader) {
        this.groupHeader = groupHeader;
        return this;
    }

    public GroupData withGroupFooter(String groupFooter) {
        this.groupFooter = groupFooter;
        return this;
    }

}
