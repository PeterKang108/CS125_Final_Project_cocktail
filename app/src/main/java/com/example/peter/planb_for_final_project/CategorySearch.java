package com.example.peter.planb_for_final_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class CategorySearch extends AppCompatActivity {

    public static String category;
    EditText categoryInput;
    public static TextView result;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_category);

        categoryInput = (EditText) findViewById(R.id.CategoryInput);
        result = (TextView) findViewById(R.id.tvResultCategory);
        button = (Button) findViewById(R.id.buttonCategory);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                category = categoryInput.getText().toString();
                ShowResultByCategory showResult = new ShowResultByCategory();
                showResult.execute();
            }
        });


    }
}
