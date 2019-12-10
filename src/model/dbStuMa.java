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
public class dbStuMa {
    public static java.sql.Connection connect() throws SQLException{
    
        return DriverManager.getConnection("jdbc:sqlite:database.db");
    }
    
    public static ArrayList<studentMa> getStudent(){
        ArrayList<studentMa> list=new ArrayList<>();
        try {
            java.sql.Connection con =connect();
            PreparedStatement p=con.prepareStatement("select * from users where level='student' and users.id not in(select stuId from students) order by department");
            ResultSet r=p.executeQuery();
            while(r.next()){
               
                list.add(new studentMa(r.getInt("id"),r.getString("department")));
               
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    
       public static ArrayList<activeStu> getActStudent(){
        ArrayList<activeStu> list=new ArrayList<>();
        try {
            java.sql.Connection con =connect();
            PreparedStatement p=con.prepareStatement("select * from students order by depName,class");
            ResultSet r=p.executeQuery();
            while(r.next()){
               
                list.add(new activeStu(r.getInt("stuId"),r.getString("depName"),r.getString("class")));
               
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    
    public static boolean insertStu(int id, String depart, String clas) throws SQLException {
        try {
            java.sql.Connection con = connect();
            PreparedStatement p = con.prepareStatement("insert into students values(?,?,?)");
            p.setInt(1, id);
            p.setString(2, depart);
            p.setString(3, clas);

            p.execute();
            return true;
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());
            return false;
        }

    }

    public static boolean deleteStu(int id) throws SQLException {
        try {
            java.sql.Connection con = connect();
            PreparedStatement p = con.prepareStatement("delete from students where stuId=?");
            p.setInt(1, id);
            p.execute();
            return true;
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());
            return false;
        }
    }
       
       
}
