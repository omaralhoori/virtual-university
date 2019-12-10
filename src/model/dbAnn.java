/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author omar
 */
public class dbAnn {

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    LocalDateTime now = LocalDateTime.now();

    public static java.sql.Connection connect() throws SQLException {

        return DriverManager.getConnection("jdbc:sqlite:database.db");
    }

    public static ArrayList<announc> getAnnounc() {
        ArrayList<announc> list = new ArrayList<>();
        try {
            java.sql.Connection con = connect();
            PreparedStatement p = con.prepareStatement("select * from Announcements order by anId DESC");
            ResultSet r = p.executeQuery();
            while (r.next()) {

                list.add(new announc(r.getString("anTitle"), r.getString("anText"), r.getString("anImage"), r.getString("anDate")));

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public boolean insertAnn(String title, String text, String image) throws SQLException {
        try {
            java.sql.Connection con = connect();
            PreparedStatement p = con.prepareStatement("insert into Announcements(anTitle,anText,anImage,anDate) values(?,?,?,?)");
            p.setString(1, title);
            p.setString(2, text);
            p.setString(3, image);
            p.setString(4, dtf.format(now));

            p.execute();
            return true;
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());
            return false;
        }

    }

}
