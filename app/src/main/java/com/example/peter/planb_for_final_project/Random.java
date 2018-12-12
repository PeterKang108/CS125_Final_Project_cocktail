package com.example.peter.planb_for_final_project;

import android.content.Intent;
import android.location.GnssClock;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import static com.example.peter.planb_for_final_project.GsonHelperFunctions.CocktailResults;
import static com.example.peter.planb_for_final_project.GsonHelperFunctions.CocktailResultsPreview;

public class Random extends AppCompatActivity {
    Button Generate;
    public static String URL;
    public static List<CocktailPreview> previewResultsList;
    public static List<Cocktail> ResultsInfoLists;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_random);
        Generate = (Button) findViewById(R.id.generate);
        Generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainNameSearch.previewResultsList = null;
                CategorySearch.previewResultsList = null;
                Alcohol.previewResultsList = null;
                GlassSearch.previewResultsList = null;
                Random.previewResultsList = null;
                URL = "https://www.thecocktaildb.com/api/json/v1/1/random.php";
                ShowResultByName showResult = new ShowResultByName();
                showResult.execute();
            }
        });
    }
    public class ShowResultByName extends AsyncTask<Void, Void, Void> {
        String data = "";

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                java.net.URL searchResult = new URL(URL);
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
            Random.ResultsInfoLists = CocktailResults(data);
            Random.previewResultsList = CocktailResultsPreview(Random.ResultsInfoLists);
            openNameSearchResult();
        }
    }
}
