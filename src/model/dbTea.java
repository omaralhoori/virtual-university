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
public class dbTea {
    
    public static java.sql.Connection connect() throws SQLException{
    
        return DriverManager.getConnection("jdbc:sqlite:database.db");
    }
    
    public static ArrayList<teacher> getTeacher(){
        ArrayList<teacher> list=new ArrayList<>();
        try {
            java.sql.Connection con =connect();
            PreparedStatement p=con.prepareStatement("select * from users where level='teacher'");
            ResultSet r=p.executeQuery();
            while(r.next()){
               
                list.add(new teacher(r.getInt("id"),r.getString("username"),r.getString("department")));
               
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    
    public static boolean insertTeacher(String user,String pass,String email,String gender,String depart) throws SQLException{
       try{
        java.sql.Connection con =connect();
        PreparedStatement p=con.prepareStatement("insert into users(username,password,email,gender,department,level) values(?,?,?,?,?,'teacher')");
        p.setString(1, user);
        p.setString(2, pass);
        p.setString(3, email);
        p.setString(4, gender);
        p.setString(5, depart);
        p.execute();
        return true;
       }
       catch(SQLException ee){
           System.out.println(ee.getMessage());
           return false;
       }
    }
}
