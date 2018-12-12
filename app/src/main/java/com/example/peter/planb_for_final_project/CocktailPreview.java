package com.example.peter.planb_for_final_project;

public class CocktailPreview {
    private String name;
    private String description;
    private String imageURL;

    public CocktailPreview(String name, String description, String imageURL) {
        this.name = name;
        this.description = description;
        this.imageURL = imageURL;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImageURL() {
        return imageURL;
    }
}
