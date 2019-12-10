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
import static model.dbLesson.dtf;

/**
 *
 * @author omar
 */
public class dbDegree {
    public static java.sql.Connection connect() throws SQLException{
    
        return DriverManager.getConnection("jdbc:sqlite:database.db");
    }
    
    public static ArrayList<degree> getDegree(){
        ArrayList<degree> list=new ArrayList<>();
        try {
            java.sql.Connection con =connect();
            PreparedStatement p=con.prepareStatement("select * from student_degree");
            ResultSet r=p.executeQuery();
            while(r.next()){
               
                list.add(new degree(r.getInt("stuId"),r.getString("corName"), r.getString("vize"), r.getString("final")));
               
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    
      public static boolean updateDegree(int stuId, String corName, int vize,int finl) throws SQLException {
        try {
            java.sql.Connection con = connect();
            PreparedStatement p = con.prepareStatement("update student_degree set vize=?,final=? where stuId=? and corName=?");
            p.setInt(3, stuId);
            p.setString(4, corName);
            p.setInt(1,vize);
            p.setInt(2, finl);

            p.execute();
            return true;
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());
            return false;
        }

    }
    
    
}
