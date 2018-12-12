package com.example.peter.planb_for_final_project;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import static com.example.peter.planb_for_final_project.GsonHelperFunctions.ConvertAlcoholResultstoCRP;
import static com.example.peter.planb_for_final_project.GsonHelperFunctions.ConvertCategoryResultstoCRP;
import static com.example.peter.planb_for_final_project.GsonHelperFunctions.FilterCategoryResults;

public class Alcohol extends AppCompatActivity {
    String URL;
    Button alc;
    Button non;
    Button opt;
    public static String type;
    public static List<CocktailPreview> previewResultsList;
    public static List<DrinkFilteredByCatergoryResult> ResultsInfoLists;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alcohol);
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
        non = (Button) findViewById(R.id.Nonalcoholic);
        non.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainNameSearch.previewResultsList = null;
                CategorySearch.previewResultsList = null;
                GlassSearch.previewResultsList = null;
                Random.previewResultsList = null;
                type = "Non_Alcoholic";
                URL = "https://www.thecocktaildb.com/api/json/v1/1/filter.php?a=Non_Alcoholic";
                ShowResultByAlcohol showResult = new ShowResultByAlcohol();
                showResult.execute();
            }
        });
        alc = (Button) findViewById(R.id.Alcoholic);
        alc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainNameSearch.previewResultsList = null;
                CategorySearch.previewResultsList = null;
                GlassSearch.previewResultsList = null;
                Random.previewResultsList = null;
                type = "Alcoholic";
                URL = "https://www.thecocktaildb.com/api/json/v1/1/filter.php?a=Alcoholic";
                ShowResultByAlcohol showResult = new ShowResultByAlcohol();
                showResult.execute();
            }
        });
        opt = (Button) findViewById(R.id.OptionalAlcoholic);
        opt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainNameSearch.previewResultsList = null;
                CategorySearch.previewResultsList = null;
                GlassSearch.previewResultsList = null;
                Random.previewResultsList = null;
                type = "Optional_alcoholic";
                URL = "https://www.thecocktaildb.com/api/json/v1/1/filter.php?a=Optional_alcohol";
                ShowResultByAlcohol showResult = new ShowResultByAlcohol();
                showResult.execute();
            }
        });
    }
    public class ShowResultByAlcohol extends AsyncTask<Void, Void, Void> {
        String data = "";

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                URL searchResult = new URL(URL);
                HttpURLConnection search = (HttpURLConnection) searchResult.openConnection();
                InputStream result = search.getInputStream();
                BufferedReader readResult = new BufferedReader(new InputStreamReader(result));
                String line = "" + readResult.readLine();
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
        public void openNameSearchResult() {
            Intent intent = new Intent(getApplication(), name_search_result.class);
            startActivity(intent);
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Alcohol.ResultsInfoLists = FilterCategoryResults(data);
            Alcohol.previewResultsList = ConvertAlcoholResultstoCRP(CategorySearch.ResultsInfoLists);
            openNameSearchResult();
        }
    }
}
