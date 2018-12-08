package com.example.peter.planb_for_final_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class IngredientSearch extends AppCompatActivity {
    String ingredient;
    EditText ingredientInput;

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredient_search);

        ingredientInput = (EditText) findViewById(R.id.ingredientInput);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ingredient = ingredientInput.getText().toString();

                showThem(ingredient);
            }
        });
    }

    private void showThem(String input) {
        System.out.println(input);
    }
}
