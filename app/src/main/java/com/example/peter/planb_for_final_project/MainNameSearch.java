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

import static com.example.peter.planb_for_final_project.GsonHelperFunctions.CocktailResults;
import static com.example.peter.planb_for_final_project.GsonHelperFunctions.CocktailResultsPreview;


public class MainNameSearch extends AppCompatActivity {
    public static String name;
    EditText nameInput;
    public static TextView result;
    Button button;
    public static List<CocktailPreview> previewResultsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_search);

        nameInput = (EditText) findViewById(R.id.nameInput);
        result = (TextView) findViewById(R.id.tvResultName);
        button = (Button) findViewById(R.id.buttonName);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = dealWithSpace.dealWithSpace(nameInput.getText().toString());
                ShowResultByName showResult = new ShowResultByName();
                showResult.execute();
            }
        });

    }
    public void openNameSearchResult() {
        Intent intent = new Intent(this, name_search_result.class);
        startActivity(intent);
    }

    public class ShowResultByName extends AsyncTask<Void, Void, Void> {
        String data = "";

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                String searchBase = "https://www.thecocktaildb.com/api/json/v1/1/search.php?s=";
                URL searchResult = new URL(searchBase+MainNameSearch.name);
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

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            MainNameSearch.previewResultsList = CocktailResultsPreview(CocktailResults(data));
            openNameSearchResult();
        }
    }
}
