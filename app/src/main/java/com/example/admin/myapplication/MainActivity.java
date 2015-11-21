package com.example.admin.myapplication;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private DrawerLayout drawerLayout;
    private ScrollView navList;
    private ScrollView CompList;
    private ScrollView RecList;
    private LinearLayout RecLayout;
    private EditText textView;

    static protected boolean isclick=true;

    static protected EditText componentTextBox;
    //categories array
    static protected ArrayList<Categories> catArray=new ArrayList<Categories>();
    //components array
    static protected ArrayList<Components> compArray=new ArrayList<Components>();
    //Recipe Array
    static protected ArrayList<Recipe> RecArray=new ArrayList<Recipe>();

    static protected ArrayList<String> STR=new ArrayList<String>();

    static protected  String[] STR2=new String[30];


    private LinearLayout Layoutcategories;
    private LinearLayout LayoutComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Parse.enableLocalDatastore(this);
        Parse.initialize(this, Keys.key1, Keys.key2);

        //open first fragment
        Fragment newfragment;
        newfragment = new FirstScreen();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentholder, newfragment);
        transaction.addToBackStack(null);
        transaction.commit();
        drawerLayout=(DrawerLayout)findViewById(R.id.drawerlayout);
        //categories list
        navList = (ScrollView) findViewById(R.id.navlist);
        Layoutcategories = new LinearLayout(this);
        Layoutcategories.setOrientation(LinearLayout.VERTICAL);
        navList.addView(Layoutcategories);

        //component list
        CompList=(ScrollView)findViewById(R.id.complis);
        LayoutComponent = new LinearLayout(this);
        LayoutComponent.setOrientation(LinearLayout.VERTICAL);
        CompList.addView(LayoutComponent);


        actionBarDrawerToggle= new ActionBarDrawerToggle(this, drawerLayout,R.string.openbar,R.string.closebar);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        //open and close component list fragment
        Button btnComponent=new Button(this);
        btnComponent.setText("save");
        btnComponent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(drawerLayout.isDrawerOpen(CompList)){
                    drawerLayout.closeDrawer(CompList);
                }else{
                    drawerLayout.openDrawer(CompList);
                }
            }
        });
        //open and close categories fragment
        Button btnCategories=new Button(this);
        btnCategories.setText("save");
        btnCategories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(drawerLayout.isDrawerOpen(navList)){
                    drawerLayout.closeDrawer(navList);
                }else{
                    drawerLayout.openDrawer(navList);
                }
            }
        });
        Layoutcategories.addView(btnCategories);
        getCategoriesfromparse();
    }
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }
    //open component chooses
    public void ComponentChoose(View view){
        if(drawerLayout.isDrawerOpen(CompList)){
            drawerLayout.closeDrawer(CompList);

        }else{
            drawerLayout.openDrawer(CompList);
        }
    }
    //open categories menu
    public void Categoriesmenu(View view){
        if(drawerLayout.isDrawerOpen(navList)){
            drawerLayout.closeDrawer(navList);

        }else{
            drawerLayout.openDrawer(navList);
        }
    }
    //checking if the component is true in parse
    public void checkingcomponent(String CompName){
        String s;
        final ParseQuery<ParseObject> Components = ParseQuery.getQuery("Components");
        Components.whereEqualTo("Name", CompName);
        Components.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> object, ParseException e) {
                if (e == null) {
                    if (object.size() > 0) {
                        for (int indx = 0; indx < object.size(); indx++) {
                            final Button btn = new Button(MainActivity.this);
                            btn.setText(object.get(indx).getString("Name"));
                            btn.setTextColor(Color.BLACK);
                            btn.setBackgroundColor(Color.WHITE);
                            //add component to array components
                            final Components comp = new Components();
                            //set component details
                            comp.setCompName(object.get(indx).getString("Name"));
                            comp.setCompID(object.get(indx).getObjectId());
                            compArray.add(comp);
                            /*In case the user wants to delete a component would have to press
                            a button component then the app searched  matches Between the button
                            and the components array then the component is been removd from array*/
                            btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LayoutComponent.removeView(btn);
                                    for (int i = 0; i < compArray.size(); i++) {
                                        if (compArray.get(i).getCompName().matches(btn.getText().toString())) {
                                            compArray.remove(i);
                                        }
                                    }
                                }
                            });
                            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                            alertDialog.setMessage("המרכיב נוסף בהצלחה");
                            alertDialog.setCanceledOnTouchOutside(false);
                            alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    componentTextBox.setText("");
                                    isclick = true;
                                }
                            });
                            alertDialog.show();
                            LayoutComponent.addView(btn);
                        }
                    } else {
                        //in case the component its not true in parse
                        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                        alertDialog.setTitle("שגיאה");
                        alertDialog.setCanceledOnTouchOutside(false);
                        alertDialog.setMessage("המרכיב שהוקלד אינו נמצא אנה הקלד שנית");
                        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                isclick = true;
                            }
                        });
                        alertDialog.show();
                    }
                } else {
                    //connection problem
                    Toast.makeText(getApplication(), "בעיות תקשורת אנה אמתן", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    //add the component to lise
    public void addcomponent(View view){
        boolean ItsExist=false;
        if(isclick) {
            isclick=false;
            componentTextBox = (EditText) findViewById(R.id.ComponentFromUser);
            String component = componentTextBox.getText().toString();
            /*checking if the component Is it already exists in array*/
            if (compArray.size() > 0) {
                /*in case we have components in array*/
                for (int i = 0; i < compArray.size(); i++) {
                    if (compArray.get(i).getCompName().matches(component)) {
                        /*in case the component is exist in array*/
                        ItsExist=true;
                        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                        alertDialog.setTitle("שגיאה");
                        alertDialog.setCanceledOnTouchOutside(false);
                        alertDialog.setMessage("המרכיב כבר קיים ברשימה");
                        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                isclick=true;
                            }
                        });
                        alertDialog.show();
                    }
                }
                if(!ItsExist){
                    /*in case the component is    n  o  t   exist in array*/
                    checkingcomponent(component);
                }
            } else {
                /*in case its first component in array*/
                checkingcomponent(component);
            }
        }
    }
    //geting all categories
    private void getCategoriesfromparse(){
        ParseQuery<ParseObject> CatgeTable = ParseQuery.getQuery("Categories");
        CatgeTable.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> object, ParseException e) {
                if (e == null) {
                    for (int indx = 0; indx < object.size(); indx++) {
                        Categories cat = new Categories();
                        cat.setCatID(object.get(indx).getObjectId());
                        cat.setName(object.get(indx).getString("Name"));
                        catArray.add(cat);
                        final Button btn = new Button(MainActivity.this);
                        btn.setText(object.get(indx).getString("Name"));
                        btn.setBackgroundColor(Color.WHITE);
                        //set selected in array
                        //blu green its selected btn and blu its not
                        btn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                ColorDrawable buttonColor = (ColorDrawable) btn.getBackground();
                                int colorId = buttonColor.getColor();
                                // in case user choose this button
                                if (colorId == Color.WHITE) {
                                    btn.setBackgroundColor(Color.BLACK);
                                    btn.setTextColor(Color.WHITE);
                                    for (int i = 0; i < catArray.size(); i++) {
                                        if (catArray.get(i).getName().matches(btn.getText().toString())) {
                                            catArray.get(i).setChecked(true);
                                        }
                                    }
                                } else {
                                    // in case user delete is choose
                                    btn.setBackgroundColor(Color.WHITE);
                                    btn.setTextColor(Color.BLACK);
                                    for (int i = 0; i < catArray.size(); i++) {
                                        if (catArray.get(i).getName().matches(btn.getText().toString())) {
                                            catArray.get(i).setChecked(false);
                                        }
                                    }
                                }
                            }
                        });
                        Layoutcategories.addView(btn);
                    }
                }
            }
        });
    }
    public void Move2ResultScreen(View view) {
        RecList=(ScrollView)findViewById(R.id.resultlist);
        RecLayout=new LinearLayout(this);
        RecLayout.setOrientation(LinearLayout.VERTICAL);
        RecList.addView(RecLayout);
        RecLayout.removeAllViews();
        int CatCounter = 0;
        //create string array for components and Categories
        for (int indx = 0; indx < catArray.size(); indx++) {
            if (catArray.get(indx).isChecked()) {
                CatCounter++;
            }
        }
        final String[] CatArray_STR = new String[CatCounter];
        for (int indx = 0, indx2 = 0; indx < catArray.size(); indx++) {
            if (catArray.get(indx).isChecked()) {
                CatArray_STR[indx2++] = (catArray.get(indx).getCatID());
            }
        }
        String[] CompArray_STR = new String[compArray.size()];
        for (int indx = 0; indx < compArray.size(); indx++) {
            CompArray_STR[indx] = (compArray.get(indx).getCompID());
        }
        ParseQuery<ParseObject> Rec_Comp_TABLE = ParseQuery.getQuery("Rec_Comp");
        Rec_Comp_TABLE.whereContainedIn("CompID", Arrays.asList(CompArray_STR));
        ParseQuery<ParseObject> Rec_Cat_TABLE = ParseQuery.getQuery("Rec_Cat");
        Rec_Cat_TABLE.whereContainedIn("CatId", Arrays.asList(CatArray_STR));
        Rec_Cat_TABLE.whereMatchesKeyInQuery("RecId", "RecId", Rec_Comp_TABLE);
        ParseQuery<ParseObject> Rec_TABLE = ParseQuery.getQuery("Recipes");
        Rec_TABLE.whereMatchesKeyInQuery("objectId", "RecId", Rec_Comp_TABLE);
        Rec_TABLE.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> results2, ParseException e3) {
                if (e3 == null) {
                    if (results2.size() > 0) {
                        for (int indx = 0; indx < results2.size(); indx++) {
                            Button btn=new Button(MainActivity.this);
                            btn.setText(results2.get(indx).getString("Name"));
                            RecLayout.addView(btn);
                        }
                    } else {
                        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                        alertDialog.setCanceledOnTouchOutside(false);
                        alertDialog.setMessage("לא נמצאו מתכונים מתאימים");
                        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                        alertDialog.show();
                    }
                } else {
                }
            }
        });
    }
    public void Change2WhitingScreen(){
        Fragment newfragment;
        newfragment = new FlashScreen_Add_Component();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentholder, newfragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    public void Change2FirstScreen(){
        Fragment newfragment;
        newfragment = new FirstScreen();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentholder, newfragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
