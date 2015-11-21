package com.example.admin.myapplication;

/**
 * Created by Admin on 19/11/2015.
 */
public class Recipes {


    private String RecName;
    private String Rec_Str;
    private String Comp_Str;
    private String WorkTime;
    private String preperTime;


    //constructors
    public Recipes(String recName, String rec_Str, String comp_Str, String workTime, String preperTime) {
        this.RecName = recName;
        this.Rec_Str = rec_Str;
        this.Comp_Str = comp_Str;
        this.WorkTime = workTime;
        this.preperTime = preperTime;
    }
    public Recipes() {
    }
    public Recipes(Recipes recipes){
        this.RecName = recipes.getRecName();
        this.Rec_Str = recipes.getRec_Str();
        this.Comp_Str = recipes.getComp_Str();
        this.WorkTime = recipes.getWorkTime();
        this.preperTime = recipes.getPreperTime();
    }



    //getter&setter
    public String getRecName() {
        return RecName;
    }
    public void setRecName(String recName) {
        RecName = recName;
    }
    public String getRec_Str() {
        return Rec_Str;
    }
    public void setRec_Str(String rec_Str) {
        Rec_Str = rec_Str;
    }
    public String getComp_Str() {
        return Comp_Str;
    }
    public void setComp_Str(String comp_Str) {
        Comp_Str = comp_Str;
    }
    public String getWorkTime() {
        return WorkTime;
    }
    public void setWorkTime(String workTime) {
        WorkTime = workTime;
    }
    public String getPreperTime() {
        return preperTime;
    }
    public void setPreperTime(String preperTime) {
        this.preperTime = preperTime;
    }


}
