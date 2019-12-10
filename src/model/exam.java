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
public class exam {
    String exName,exDesc,exTime,exLink,corName;

    public exam(String exName, String exDesc, String exTime, String exLink, String corName) {
        this.exName = exName;
        this.exDesc = exDesc;
        this.exTime = exTime;
        this.exLink = exLink;
        this.corName = corName;
    }

    public String getExName() {
        return exName;
    }

    public void setExName(String exName) {
        this.exName = exName;
    }

    public String getExDesc() {
        return exDesc;
    }

    public void setExDesc(String exDesc) {
        this.exDesc = exDesc;
    }

    public String getExTime() {
        return exTime;
    }

    public void setExTime(String exTime) {
        this.exTime = exTime;
    }

    public String getExLink() {
        return exLink;
    }

    public void setExLink(String exLink) {
        this.exLink = exLink;
    }

    public String getCorName() {
        return corName;
    }

    public void setCorName(String corName) {
        this.corName = corName;
    }
    
    
    
}
