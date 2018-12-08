package com.example.peter.planb_for_final_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NameSearch extends AppCompatActivity {
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

    private void showThem(String input) {
        System.out.println(input);
    }
}
