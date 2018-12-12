package com.example.peter.planb_for_final_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class name_search_result extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_search_result);

        recyclerView = (RecyclerView) findViewById(R.id.search_result_name);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        if (MainNameSearch.previewResultsList != null) {
            adapter = new cocktail_result_adaptor(MainNameSearch.ResultsInfoLists,
                    MainNameSearch.previewResultsList, this);
            recyclerView.setAdapter(adapter);
        } else if (CategorySearch.previewResultsList != null) {
            adapter = new cocktail_result_adaptor(null,
                    CategorySearch.previewResultsList, this);
            recyclerView.setAdapter(adapter);
        } else if (GlassSearch.previewResultsList != null) {
            adapter = new cocktail_result_adaptor(null,
                    GlassSearch.previewResultsList, this);
            recyclerView.setAdapter(adapter);
        } else if (Alcohol.previewResultsList != null) {
            adapter = new cocktail_result_adaptor(null,
                    Alcohol.previewResultsList, this);
            recyclerView.setAdapter(adapter);
        } else if (Random.previewResultsList != null) {
            adapter = new cocktail_result_adaptor(Random.ResultsInfoLists,
                    Random.previewResultsList, this);
            recyclerView.setAdapter(adapter);
        } else {
            adapter = new cocktail_result_adaptor(null,
                    null, this);
            recyclerView.setAdapter(adapter);
        }
    }
}
