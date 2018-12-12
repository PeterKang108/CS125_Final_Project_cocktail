package com.example.peter.planb_for_final_project;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Glass extends AppCompatActivity {
    ImageButton button;
    ImageButton button2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glass);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        button = (ImageButton) findViewById(R.id.searchGlass);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGlassSearch();
            }
        });

        button2 = (ImageButton) findViewById(R.id.oldSearchGlass);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openOldGlassSearch();
            }
        });

    }
    public void openGlassSearch() {
        Intent intent = new Intent(this, NewGlassSearchResult.class);
        startActivity(intent);
    }

    public void openOldGlassSearch() {
        Intent intent = new Intent(this, GlassSearch.class);
        startActivity(intent);
    }
}
