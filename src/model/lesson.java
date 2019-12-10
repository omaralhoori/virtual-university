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
public class lesson {
    private String corName,lesTitle,lesTime,lesLink,lesDesc;

    public lesson(String corName, String lesTitle, String lesTime, String lesLink, String lesDesc) {
        this.corName = corName;
        this.lesTitle = lesTitle;
        this.lesTime = lesTime;
        this.lesLink = lesLink;
        this.lesDesc = lesDesc;
    }

    public String getCorName() {
        return corName;
    }

    public void setCorName(String corName) {
        this.corName = corName;
    }

    public String getLesTitle() {
        return lesTitle;
    }

    public void setLesTitle(String lesTitle) {
        this.lesTitle = lesTitle;
    }

    public String getLesTime() {
        return lesTime;
    }

    public void setLesTime(String lesTime) {
        this.lesTime = lesTime;
    }

    public String getLesLink() {
        return lesLink;
    }

    public void setLesLink(String lesLink) {
        this.lesLink = lesLink;
    }

    public String getLesDesc() {
        return lesDesc;
    }

    public void setLesDesc(String lesDesc) {
        this.lesDesc = lesDesc;
    }
    
}
