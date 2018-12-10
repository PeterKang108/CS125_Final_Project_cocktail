package com.example.peter.planb_for_final_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class IngredientSearch extends AppCompatActivity {
    public static String Ingredient;
    EditText ingredientInput;
    public static TextView result;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredient_search);

        ingredientInput = (EditText) findViewById(R.id.IngredientInput);
        result = (TextView) findViewById(R.id.tvResultIngredient);
        button = (Button) findViewById(R.id.buttonIngredient);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Ingredient = ingredientInput.getText().toString();
                ShowIngredientResult showResult = new ShowIngredientResult();
                showResult.execute();
            }
        });

    }
}
