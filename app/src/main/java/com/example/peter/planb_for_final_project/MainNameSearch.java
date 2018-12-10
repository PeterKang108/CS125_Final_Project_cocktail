package com.example.peter.planb_for_final_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainNameSearch extends AppCompatActivity {
    public static String name;
    EditText nameInput;
    public static TextView result;
    Button button;

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
                name = nameInput.getText().toString();
                ShowResultByName showResult = new ShowResultByName();
                showResult.execute();
            }
        });

    }
}
