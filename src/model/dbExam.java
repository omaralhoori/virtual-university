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
import java.util.ArrayList;

/**
 *
 * @author omar
 */
public class dbExam {

    public static java.sql.Connection connect() throws SQLException {

        return DriverManager.getConnection("jdbc:sqlite:database.db");
    }

    public static ArrayList<exam> getExam() {
        ArrayList<exam> list = new ArrayList<>();
        try {
            java.sql.Connection con = connect();
            PreparedStatement p = con.prepareStatement("select * from exams");
            ResultSet r = p.executeQuery();
            while (r.next()) {

                list.add(new exam(r.getString("examName"), r.getString("examDesc"), r.getString("examTime"), r.getString("examLink"), r.getString("corName")));

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public static boolean insertExam(String title, String time, String link, String cors, String desc) throws SQLException {
        try {
            java.sql.Connection con = connect();
            PreparedStatement p = con.prepareStatement("insert into exams(examName,examTime,examLink,corName,examDesc) values(?,?,?,?,?)");
            p.setString(1, title);
            p.setString(2, time);
            p.setString(3, link);
            p.setString(4, cors);
            p.setString(5, desc);

            p.execute();
            return true;
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());
            return false;
        }

    }

}
