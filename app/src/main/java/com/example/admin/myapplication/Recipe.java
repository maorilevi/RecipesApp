package com.example.admin.myapplication;

import android.graphics.Bitmap;

/**
 * Created by Admin on 28/10/2015.
 */
public class Recipe {

    private String RecName;

    private String Rec_Comp;
    private String RecSTR;
    private String WorkTime;
    private String PreparTime;
    private String like;//like recipe counter
    private String unlike;//unlike recipe counter
    private Bitmap RecImeg;
    protected boolean side;


    //constructors
    public Recipe(){
    }
    public Recipe(String recName,String worktime,String prepartime,String RecComp,
                  String like,String unlike,Bitmap recImeg,String RecSTR) {
        this.RecName = recName;
        this.RecImeg = recImeg;
        this.Rec_Comp=RecComp;
        this.WorkTime =worktime;
        this.PreparTime =prepartime;
        this.like=like;
        this.unlike=unlike;
        this.side = true;
        this.RecSTR=RecSTR;
    }
    public Recipe(Object p0) {
    }
    public Recipe(String recName){
        super();
        this.side=true;
        this.RecName = recName;
    }



    //getter and setter
    public void setLike(String like) {
        this.like = like;
    }
    public String getUnlike() {
        return unlike;
    }
    public void setUnlike(String unlike) {
        this.unlike = unlike;
    }
    public String getLike() {
        return like;
    }
    public String getWorkTime() {
        return WorkTime;
    }
    public void setWorkTime(String workTime) {
        this.WorkTime = workTime;
    }
    public String getPreparTime() {
        return PreparTime;
    }
    public void setPreparTime(String preparTime) {
        this.PreparTime = preparTime;
    }
    public Bitmap getRecImeg() {
        return RecImeg;
    }
    public void setRecImeg(Bitmap recImeg) {
        this.RecImeg = recImeg;
    }
    public boolean isSide() {
        return side;
    }
    public void setSide(boolean side) {
        this.side = side;
    }
    public String getRecName() {
        return RecName;
    }
    public void setRecName(String recName) {
        this.RecName = recName;
    }
    public String getRecSTR() {
        return RecSTR;
    }
    public void setRecSTR(String recSTR) {
        RecSTR = recSTR;
    }
    public String getRec_Comp() {
        return Rec_Comp;
    }
    public void setRec_Comp(String rec_Comp) {
        Rec_Comp = rec_Comp;
    }


}
