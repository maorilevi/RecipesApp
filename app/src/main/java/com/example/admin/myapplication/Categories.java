package com.example.admin.myapplication;

/**
 * Created by Admin on 16/11/2015.
 */
public class Categories {


    private boolean checked = false;
    private String name;
    private String CatID;

    //constructors
    public void Categories(String name, String ID) {
        this.name = name;
        this.CatID = ID;
    }
    public void Categories(Categories categories) {
        this.name = categories.name;
        this.CatID = categories.CatID;
    }

    //getter&seter
    public boolean isChecked() {
        return checked;
    }
    public void setChecked(boolean checked) {
        this.checked = checked;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCatID() {
        return CatID;
    }
    public void setCatID(String catID) {
        this.CatID = catID;
    }
}
