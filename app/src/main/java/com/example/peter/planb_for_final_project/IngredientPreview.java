package com.example.peter.planb_for_final_project;

public class IngredientPreview {
    private String name;
    private String description;
    private String type;

    public IngredientPreview(String name, String description, String type) {
        this.name = name;
        this.description = description;
        this.type = type;
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
