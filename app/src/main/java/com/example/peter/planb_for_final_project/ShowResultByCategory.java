package com.example.peter.planb_for_final_project;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


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
            String line = "";
            while (line != null) {
                line = readResult.readLine();
                data = data + line;
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
        CategorySearch.result.setText(this.data);
    }
}
