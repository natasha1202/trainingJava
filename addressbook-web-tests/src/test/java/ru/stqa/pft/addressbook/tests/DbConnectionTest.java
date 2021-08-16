package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.sql.*;

public class DbConnectionTest {

    @Test
    public void testDbConnection(){
        Connection conn = null;
        try {
            conn =
                    DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook?user=root&password=");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select group_id, group_name, group_header, group_footer  from group_list");
            Groups groups = new Groups();
            while (rs.next()) {
               groups.add( new GroupData().withId(rs.getInt("group_id"))
                       .withGroupName(rs.getString("group_name"))
                       .withGroupHeader(rs.getString("group_header"))
                       .withGroupFooter(rs.getString("group_footer")));
            }
            rs.close(); // the data won't be read from db anymore
            st.close(); // queries won't be executed anymore
            conn.close(); // close db connection
            System.out.println(groups);

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
}
