package com.example.admin.myapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Admin on 28/10/2015.
 */
public class FirstScreen extends Fragment {

    static protected ArrayList<Recipes> FirstScreenRecArray=new ArrayList<Recipes>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View firstscreen= inflater.inflate(R.layout.firstscreen, container, false);
        return firstscreen;
    }
}
