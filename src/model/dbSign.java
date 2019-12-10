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
public class dbSign {
    public static java.sql.Connection connect() throws SQLException{
    
        return DriverManager.getConnection("jdbc:sqlite:database.db");
    }
    public static ArrayList<users> getUsers(){
        ArrayList<users> list=new ArrayList<>();
        try {
            java.sql.Connection con =connect();
            PreparedStatement p=con.prepareStatement("select * from users");
            ResultSet r=p.executeQuery();
            while(r.next()){
               
                list.add(new users(r.getInt("id"),r.getString("username"),r.getString("password"),r.getString("department"),r.getString("email"),r.getString("gender"),r.getString("level")));
               
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    
    public static int checkUser(String user,String pass){
        ArrayList<users> arr=getUsers();
        int x=0;
        for(int i=0;i<arr.size();i++){
            if(arr.get(i).getUserName().equalsIgnoreCase(user)){
                if(arr.get(i).getPassWord().equalsIgnoreCase(pass)){
                    if(arr.get(i).getLeVel().equalsIgnoreCase("manager")){
                    x=3;
                    break;
                    }
                    else if(arr.get(i).getLeVel().equalsIgnoreCase("teacher")){
                    x=1;
                    break;}
                    else x=4;
                    break;
                }else{
                    x=2;
                    break;
                }
            }else{
                x=0;
            }
        }
        return x;
    }
    
     public static boolean insertUser(String user,String pass,String email,String gender,String depart) throws SQLException{
       try{
        java.sql.Connection con =connect();
        PreparedStatement p=con.prepareStatement("insert into users(username,password,email,gender,department) values(?,?,?,?,?)");
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
