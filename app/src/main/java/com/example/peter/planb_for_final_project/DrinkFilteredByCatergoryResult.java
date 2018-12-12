package com.example.peter.planb_for_final_project;

import com.google.gson.annotations.SerializedName;

public class DrinkFilteredByCatergoryResult {
    @SerializedName("strDrink")
    private String name;
    @SerializedName("strDrinkThumb")
    private String imgURL;
    @SerializedName("idDrink")
    private int id;

    public DrinkFilteredByCatergoryResult(String name, String imgURL, int id) {
        this.name = name;
        this.imgURL = imgURL;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getImgURL() {
        return imgURL;
    }

    public int getId() {
        return id;
    }
}
