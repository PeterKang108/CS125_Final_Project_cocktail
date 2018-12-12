package com.example.peter.planb_for_final_project;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import static com.example.peter.planb_for_final_project.GsonHelperFunctions.ConvertCategoryResultstoCRP;
import static com.example.peter.planb_for_final_project.GsonHelperFunctions.FilterCategoryResults;

public class CategorySearch extends AppCompatActivity {

    public static String category;
    EditText categoryInput;
    Button button;
    public static List<CocktailPreview> previewResultsList;
    public static List<DrinkFilteredByCatergoryResult> ResultsInfoLists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_category);

        categoryInput = (EditText) findViewById(R.id.CategoryInput);
        button = (Button) findViewById(R.id.buttonCategory);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainNameSearch.previewResultsList = null;
                CategorySearch.previewResultsList = null;
                Alcohol.previewResultsList = null;
                GlassSearch.previewResultsList = null;
                Random.previewResultsList = null;
                category = dealWithSpace.dealWithSpace(categoryInput.getText().toString());
                ShowResultByCategory showResult = new ShowResultByCategory();
                showResult.execute();
            }
        });


    }
    public class ShowResultByCategory extends AsyncTask<Void, Void, Void> {
        String data = "";
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                String searchBase = "https://www.thecocktaildb.com/api/json/v1/1/filter.php?c=";
                URL searchResult = new URL(searchBase+CategorySearch.category);
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
            //result.setText("Result:/n" + data);
            //System.out.println(data);
            //return data;
            return null;
        }
        public void openNameSearchResult() {
            Intent intent = new Intent(getApplication(), name_search_result.class);
            startActivity(intent);
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            CategorySearch.ResultsInfoLists = FilterCategoryResults(data);
            CategorySearch.previewResultsList = ConvertCategoryResultstoCRP(CategorySearch.ResultsInfoLists);
            openNameSearchResult();
        }
    }
}
