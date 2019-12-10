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
public class dbLesson {
    
     static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
     static LocalDateTime now = LocalDateTime.now();  
    
    public static java.sql.Connection connect() throws SQLException{
    
        return DriverManager.getConnection("jdbc:sqlite:database.db");
    }
    
    public static ArrayList<lesson> getLesson(){
        ArrayList<lesson> list=new ArrayList<>();
        try {
            java.sql.Connection con =connect();
            PreparedStatement p=con.prepareStatement("select * from lessons");
            ResultSet r=p.executeQuery();
            while(r.next()){
               
                list.add(new lesson(r.getString("corName"),r.getString("lesTitle"), r.getString("lesTime"), r.getString("lesLink"),r.getString("lesDesc")));
               
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    
      public static boolean insertLesson(String title, String link, String cors,String desc) throws SQLException {
        try {
            java.sql.Connection con = connect();
            PreparedStatement p = con.prepareStatement("insert into lessons(lesTitle,lesTime,lesLink,corName,lesDesc) values(?,?,?,?,?)");
            p.setString(1, title);
            p.setString(2, dtf.format(now));
            p.setString(3, link);
            p.setString(4,cors);
            p.setString(5, desc);

            p.execute();
            return true;
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());
            return false;
        }

    }
    
}
