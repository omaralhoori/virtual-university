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
public class course {
    int corId;
    String corName,corDep,clas,teacher;

    public course(int corId, String teacher, String corName, String corDep, String clas) {
        this.corId = corId;
        this.teacher = teacher;
        this.corName = corName;
        this.corDep = corDep;
        this.clas = clas;
    }

    public int getCorId() {
        return corId;
    }

    public void setCorId(int corId) {
        this.corId = corId;
    }

    public String getTeaId() {
        return teacher;
    }

    public void setTeaId(String teaId) {
        this.teacher = teacher;
    }

    public String getCorName() {
        return corName;
    }

    public void setCorName(String corName) {
        this.corName = corName;
    }

    public String getCorDep() {
        return corDep;
    }

    public void setCorDep(String corDep) {
        this.corDep = corDep;
    }

    public String getClas() {
        return clas;
    }

    public void setClas(String clas) {
        this.clas = clas;
    }
    
    
    
    
}
