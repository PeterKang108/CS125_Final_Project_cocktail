package com.example.peter.planb_for_final_project;

import com.google.gson.annotations.SerializedName;

public class IngredientSource {
    @SerializedName("idIngredient")
    private int idIngredient;
    @SerializedName("strIngredient")
    private String name;
    @SerializedName("strDescription")
    private String description;
    @SerializedName("strType")
    private String type;

    public IngredientSource(int idIngredient, String name, String description, String type) {
        this.idIngredient = idIngredient;
        this.name = name;
        this.description = description;
        this.type = type;
    }

    public int getIdIngredient() {
        return idIngredient;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }
}
