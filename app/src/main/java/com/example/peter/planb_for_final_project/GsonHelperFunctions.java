package com.example.peter.planb_for_final_project;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.FileReader;
import java.util.List;
import java.util.ArrayList;

public class GsonHelperFunctions {
    public static String CocktailResults(String data) {
        Gson gson = new Gson();
        Drink result = gson.fromJson(data, Drink.class);
        if (result.getCocktailResults().size() == 2) {
            return "it works!";
        } else {
            return "emmmmmm";
        }
    }
}
