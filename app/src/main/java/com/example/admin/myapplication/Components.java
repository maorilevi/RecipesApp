package com.example.admin.myapplication;

/**
 * Created by Admin on 17/11/2015.
 */
public class Components {

    private String CompName;
    private String CompID;

    //constructors
    public Components(String compName, String compID) {
        this.CompName = compName;
        this.CompID = compID;
    }
    public Components(Components componenets) {
        this.CompName = componenets.CompName;
        this.CompID = componenets.CompID;
    }
    public Components() {
    }

    //getter&seters
    public String getCompName() {
        return CompName;
    }
    public void setCompName(String compName) {
        CompName = compName;
    }
    public String getCompID() {
        return CompID;
    }
    public void setCompID(String compID) {
        CompID = compID;
    }
}
