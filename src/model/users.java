/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author omar
 */
public class users {
    private String userName,passWord,departMent,eMail,genDer,leVel;
    int id;
    public users(int id,String userName, String passWord, String departMent, String eMail, String genDer,String leVel) {
        this.userName = userName;
        this.passWord = passWord;
        this.departMent = departMent;
        this.eMail = eMail;
        this.genDer = genDer;
        this.leVel=leVel;
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    
    public String getLeVel() {
        return leVel;
    }

    public void setLeVel(String leVel) {
        this.leVel = leVel;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getDepartMent() {
        return departMent;
    }

    public void setDepartMent(String departMent) {
        this.departMent = departMent;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getGenDer() {
        return genDer;
    }

    public void setGenDer(String genDer) {
        this.genDer = genDer;
    }
    
    
    
}
