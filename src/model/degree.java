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
public class degree {
    private int stuId;
    private String vize,finl,corId;

    public degree(int stuId, String corId, String vize, String finl) {
        this.stuId = stuId;
        this.corId = corId;
        this.vize = vize;
        this.finl = finl;
    }

    public int getStuId() {
        return stuId;
    }

    public String getCorId() {
        return corId;
    }

    public String getVize() {
        return vize;
    }

    public String getFinl() {
        return finl;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public void setCorId(String corId) {
        this.corId = corId;
    }

    public void setVize(String vize) {
        this.vize = vize;
    }

    public void setFinl(String finl) {
        this.finl = finl;
    }
    
    
    
}
