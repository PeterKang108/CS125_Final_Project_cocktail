package com.example.peter.planb_for_final_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GlassSearch extends AppCompatActivity {
    public static String glass;
    EditText glassInput;
    public static TextView result;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glass_search);

        glassInput = (EditText) findViewById(R.id.GlassInput);
        result = (TextView) findViewById(R.id.tvResultGlass);
        button = (Button) findViewById(R.id.buttonGlass);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                glass = glassInput.getText().toString();
                ShowResultByGlass showResult = new ShowResultByGlass();
                showResult.execute();
            }
        });

    }
}