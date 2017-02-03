package com.blogspot.adjanybekov.gpacalculator.activities;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toolbar;

import com.blogspot.adjanybekov.gpacalculator.R;

public class ListActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        setActionBar((Toolbar) findViewById(R.id.toolbar));
    }
}
