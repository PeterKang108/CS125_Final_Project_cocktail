package com.example.peter.planb_for_final_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainNameSearch extends AppCompatActivity {
    String name;
    EditText nameInput;

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_search);

        nameInput = (EditText) findViewById(R.id.nameInput);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = nameInput.getText().toString();

                showThem(name);
            }
        });
    }

    private void showThem(String name) {
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

        System.out.println(data);
    }
}
