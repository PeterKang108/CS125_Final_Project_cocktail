package com.example.peter.planb_for_final_project;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class ingredient_search_result extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredient_search_result);

        recyclerView = (RecyclerView) findViewById(R.id.search_result_ingredient);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new ingredient_result_adapter(IngredientSearch.previewResultsList, this);
        recyclerView.setAdapter(adapter);
    }


}
