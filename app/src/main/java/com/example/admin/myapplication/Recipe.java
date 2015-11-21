package com.example.admin.myapplication;

import android.graphics.Bitmap;

/**
 * Created by Admin on 28/10/2015.
 */
public class Recipe {

    private String recName;
    private String RecSTR;
    private String worktime;
    private String prepartime;
    private String like;//like recipe counter
    private String unlike;//unlike recipe counter
    private Bitmap recImeg;
    protected boolean side;


    public Recipe(){
    }
    public Recipe(String recName,String worktime,String prepartime,
                  String like,String unlike,Bitmap recImeg,String RecSTR) {
        this.recName = recName;
        this.recImeg = recImeg;
        this.worktime=worktime;
        this.prepartime=prepartime;
        this.like=like;
        this.unlike=unlike;
        this.side = true;
        this.RecSTR=RecSTR;
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
    public String getWorktime() {
        return worktime;
    }
    public void setWorktime(String worktime) {
        this.worktime = worktime;
    }
    public String getPrepartime() {
        return prepartime;
    }
    public void setPrepartime(String prepartime) {
        this.prepartime = prepartime;
    }
    public Bitmap getRecImeg() {
        return recImeg;
    }
    public void setRecImeg(Bitmap recImeg) {
        this.recImeg = recImeg;
    }
    public boolean isSide() {
        return side;
    }
    public void setSide(boolean side) {
        this.side = side;
    }
    public String getRecName() {
        return recName;
    }
    public void setRecName(String recName) {
        this.recName = recName;
    }
    public String getRecSTR() {
        return RecSTR;
    }
    public void setRecSTR(String recSTR) {
        RecSTR = recSTR;
    }


    public Recipe(Object p0) {
    }
    public Recipe(String recName){
        super();
        this.side=true;
        this.recName = recName;
    }
}
