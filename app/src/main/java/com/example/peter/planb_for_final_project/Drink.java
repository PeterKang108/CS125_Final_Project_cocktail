package com.example.peter.planb_for_final_project;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Drink {
    @SerializedName("drinks")
    private List<Cocktail> CocktailResults;

    public List<Cocktail> getCocktailResults() {
        return CocktailResults;
    }

    public Drink(List<Cocktail> cocktailResults) {
        CocktailResults = cocktailResults;
    }
}
