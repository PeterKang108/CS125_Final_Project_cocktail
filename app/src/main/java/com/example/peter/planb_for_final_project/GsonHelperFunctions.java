package com.example.peter.planb_for_final_project;

import com.google.gson.Gson;


import java.util.List;
import java.util.ArrayList;

public class GsonHelperFunctions {
    public static List<IngredientSource> IngredientResults(String data) {
        Gson gson = new Gson();
        ingredients result = gson.fromJson(data, ingredients.class);
        return result.getIngredientResults();
    }

    public static List<IngredientPreview> IngredientResultsPreview(List<IngredientSource> data) {
        List<IngredientPreview> result = new ArrayList<>();
        if (data == null) {
            return null;
        }
        for (int i = 0; i < data.size(); i++) {
            IngredientPreview newOne = new IngredientPreview(data.get(i).getName(),
                    data.get(i).getType(), data.get(i).getDescription() );
            result.add(newOne);
        }
        return result;
    }
    public static List<Cocktail> CocktailResults(String data) {
        Gson gson = new Gson();
        Drink result = gson.fromJson(data, Drink.class);
        return result.getCocktailResults();
    }

    public static List<CocktailPreview> CocktailResultsPreview(List<Cocktail> data) {
        List<CocktailPreview> result = new ArrayList<>();
        if (data == null) {
            return null;
        }
        for (int i = 0; i < data.size(); i++) {
            CocktailPreview newOne = new CocktailPreview(data.get(i).getName(),
                    data.get(i).getCategory(), data.get(i).getThumbnailURL() );
            result.add(newOne);
        }
        return result;
    }
    public static List<DrinkFilteredByCatergoryResult> FilterCategoryResults(String data) {
        Gson gson = new Gson();
        DrinkFilteredByCategory result = gson.fromJson(data, DrinkFilteredByCategory.class);
        if (result == null) {
            return null;
        }
        return result.getFilteredByCatergoryResults();
    }
    //convert List<DrinkFilteredByCategoryResult> to List<CocktailPreview>
    public static List<CocktailPreview> ConvertCategoryResultstoCRP(
            List<DrinkFilteredByCatergoryResult> data) {
        List<CocktailPreview> result = new ArrayList<>();
        if (data == null) {
            return null;
        }
        for (int i = 0; i < data.size(); i++) {
            CocktailPreview newOne = new CocktailPreview(data.get(i).getName(),
                    CategorySearch.category, data.get(i).getImgURL());
            result.add(newOne);
        }
        return result;
    }
    public static List<CocktailPreview> ConvertGlassResultstoCRP(
            List<DrinkFilteredByCatergoryResult> data) {
        List<CocktailPreview> result = new ArrayList<>();
        if (data == null) {
            return null;
        }
        for (int i = 0; i < data.size(); i++) {
            CocktailPreview newOne = new CocktailPreview(data.get(i).getName(),
                    GlassSearch.glass, data.get(i).getImgURL());
            result.add(newOne);
        }
        return result;
    }
    public static List<CocktailPreview> ConvertAlcoholResultstoCRP(
            List<DrinkFilteredByCatergoryResult> data) {
        List<CocktailPreview> result = new ArrayList<>();
        if (data == null) {
            return null;
        }
        for (int i = 0; i < data.size(); i++) {
            CocktailPreview newOne = new CocktailPreview(data.get(i).getName(),
                    Alcohol.type, data.get(i).getImgURL());
            result.add(newOne);
        }
        return result;
    }
}
