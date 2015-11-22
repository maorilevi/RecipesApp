package com.example.admin.myapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Admin on 17/11/2015.
 */
public class FlashScreen extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View flash= inflater.inflate(R.layout.flashscreen_addcomponent, container, false);
        return flash;
    }
}
