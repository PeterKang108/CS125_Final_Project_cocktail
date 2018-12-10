package com.example.peter.planb_for_final_project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class showThem {
    public static String showResult(String name) {
        String data = "";
        try {
            String searchBase = "https://www.thecocktaildb.com/api/json/v1/1/search.php?i=";
            URL searchResult = new URL(searchBase + name);
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
        return data;
    }
}
