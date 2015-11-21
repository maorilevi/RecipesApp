package com.example.admin.myapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * Created by Admin on 28/10/2015.
 */
public class ResultScreen extends Fragment{

    private static Thread mythread;
    private static boolean threadRunning;

    private ListView list;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View resultscreen= inflater.inflate(R.layout.resultscreen, container, false);

        return resultscreen;

    }
    public void setrecipesresults(){



    }
}
