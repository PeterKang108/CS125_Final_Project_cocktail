package com.example.peter.planb_for_final_project;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ingredients {
    @SerializedName("ingredients")
    private List<IngredientSource> ingredientResults;

    public ingredients(List<IngredientSource> ingredientResults) {
        this.ingredientResults = ingredientResults;
    }

    public List<IngredientSource> getIngredientResults() {
        return ingredientResults;
    }
}
