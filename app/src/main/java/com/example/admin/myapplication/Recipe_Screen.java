package com.example.admin.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Recipe_Screen extends AppCompatActivity {

    private TextView Rec_Name;
    private TextView Rec_RecSTR;
    private TextView Rec_Comp;

    Button back;

    static protected int RecIndex=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe__screen);
        Recipe recipe=MainActivity.RecArray.get(RecIndex);
        //connection varibule with layout
        Rec_Name=(TextView)findViewById(R.id.ResultScreen_RecipeName);
        Rec_RecSTR=(TextView)findViewById(R.id.ResultScreen_Rec_Str);
        Rec_Comp=(TextView)findViewById(R.id.ResultScreen_Comp_Str);
        //set details
        Rec_Name.setText(recipe.getRecName());
        Rec_RecSTR.setText(recipe.getRecSTR());
        Rec_Comp.setText(recipe.getRec_Comp());

    }
    //back to firstscreen
    public  void tofirstscreen(View view){
        Intent intent=new Intent(Recipe_Screen.this,MainActivity.class);
        startActivity(intent);
    }

}
