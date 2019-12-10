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
public class dbCor {

    public static java.sql.Connection connect() throws SQLException {

        return DriverManager.getConnection("jdbc:sqlite:database.db");
    }

    public static ArrayList<course> getCourse() {
        ArrayList<course> list = new ArrayList<>();
        try {
            java.sql.Connection con = connect();
            PreparedStatement p = con.prepareStatement("select * from courses order by depName,class");
            ResultSet r = p.executeQuery();
            while (r.next()) {

                
                list.add(new course(r.getInt("corId"), r.getString("teacher"), r.getString("corName"), r.getString("depName"), r.getString("class")));

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public static boolean insertCor(String corName, String depart, String teacher, String clas) throws SQLException {
        try {
            java.sql.Connection con = connect();
            PreparedStatement p = con.prepareStatement("insert into courses(corName,depName,teacher,class) values(?,?,?,?)");
            p.setString(1, corName);
            p.setString(2, depart);
            p.setString(3, teacher);
            p.setString(4, clas);

            p.execute();
            return true;
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());
            return false;
        }

    }

    public static boolean deleteCor(int id) throws SQLException {
        try {
            java.sql.Connection con = connect();
            PreparedStatement p = con.prepareStatement("delete from courses where corId=?");
            p.setInt(1, id);
            p.execute();
            return true;
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());
            return false;
        }
    }
    
    public static boolean insertCorStu(int id,String corName) throws SQLException {
        try {
            java.sql.Connection con = connect();
            PreparedStatement p = con.prepareStatement("insert into student_degree(stuId,corName) values(?,?)");
            p.setInt(1, id);
            p.setString(2, corName);

            p.execute();
            return true;
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());
            return false;
        }

    }


}
