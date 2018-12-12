package com.example.peter.planb_for_final_project;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import static com.example.peter.planb_for_final_project.GsonHelperFunctions.IngredientResults;
import static com.example.peter.planb_for_final_project.GsonHelperFunctions.IngredientResultsPreview;
public class IngredientSearch extends AppCompatActivity {
    public static String Ingredient;
    EditText ingredientInput;
    public static TextView result;
    Button button;
    public static List<IngredientPreview> previewResultsList;

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
                openIngredientSearchResult();
            }
        });

    }

    public void openIngredientSearchResult() {
        Intent intent = new Intent(this, ingredient_search_result.class);
        startActivity(intent);
    }

    public class ShowIngredientResult extends AsyncTask<Void, Void, Void> {
        String data = "";

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                String searchBase = "https://www.thecocktaildb.com/api/json/v1/1/search.php?i=";
                URL searchResult = new URL(searchBase+IngredientSearch.Ingredient);
                HttpURLConnection search = (HttpURLConnection) searchResult.openConnection();
                InputStream result = search.getInputStream();
                BufferedReader readResult = new BufferedReader(new InputStreamReader(result));
                String line = "" +readResult.readLine();
                while (line != null) {
                    data = data + line;
                    line = readResult.readLine();
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            IngredientSearch.previewResultsList = IngredientResultsPreview(IngredientResults(data));
            openIngredientSearchResult();
        }
    }

}
