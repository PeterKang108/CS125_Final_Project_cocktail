package com.example.peter.planb_for_final_project;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.FileReader;
import java.util.List;
import java.util.ArrayList;

public class GsonHelperFunctions {
    public static List<Cocktail> CocktailResults(String data) {
        Gson gson = new Gson();
        Drink result = gson.fromJson(data, Drink.class);
        return result.getCocktailResults();
    }

    public static List<CocktailPreview> CocktailResultsPreview(List<Cocktail> data) {
        List<CocktailPreview> result = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            CocktailPreview newOne = new CocktailPreview(data.get(i).getName(),
                    data.get(i).getCategory(), data.get(i).getThumbnailURL() );
            result.add(newOne);
        }
        if (result == null) {
            System.out.print("haha");
        }
        return result;
    }
}
