package com.example.peter.planb_for_final_project;

import com.google.gson.annotations.SerializedName;

public class Cocktail {
    @SerializedName("idDrink")
    private int idDrink;
    @SerializedName("strDrink")
    private String name;

    //useless for now

    @SerializedName("strDrinkES")
    private String drinkES;
    @SerializedName("strDrinkDE")
    private String drinkDE;
    @SerializedName("strDrinkFR")
    private String drinkFR;
    @SerializedName("strDrinkZH-HANS")
    private String drinkZHHANS;
    @SerializedName("strDrinkZH-HANT")
    private String drinkZHHANT;
    @SerializedName("strVideo")
    private String videoURL;

    //

    @SerializedName("strCategory")
    private String Category;
    @SerializedName("strIBA")
    private String iba;
    @SerializedName("strAlcoholic")
    private String alcohol;
    @SerializedName("strGlass")
    private String glass;
    @SerializedName("strInstructions")
    private String instructions;

    //useless for now

    @SerializedName("strInstructionsES")
    private String instructionsES;
    @SerializedName("strInstructionsDE")
    private String instructionsDE;
    @SerializedName("strInstructionsFR")
    private String instructionsFR;
    @SerializedName("strInstructionsZH-HANS")
    private String instructionsZHHS;
    @SerializedName("strInstructionsZH-HANT")
    private String instructionsZHHT;

    //

    @SerializedName("strDrinkThumb")
    private String thumbnailURL;

    //ingredient 1-15
    @SerializedName("strIngredient1")
    private String ingredient1;
    @SerializedName("strIngredient2")
    private String ingredient2;
    @SerializedName("strIngredient3")
    private String ingredient3;
    @SerializedName("strIngredient4")
    private String ingredient4;
    @SerializedName("strIngredient5")
    private String ingredient5;
    @SerializedName("strIngredient6")
    private String ingredient6;
    @SerializedName("strIngredient7")
    private String ingredient7;
    @SerializedName("strIngredient8")
    private String ingredient8;
    @SerializedName("strIngredient9")
    private String ingredient9;
    @SerializedName("strIngredient10")
    private String ingredient10;
    @SerializedName("strIngredient11")
    private String ingredient11;
    @SerializedName("strIngredient12")
    private String ingredient12;
    @SerializedName("strIngredient13")
    private String ingredient13;
    @SerializedName("strIngredient14")
    private String ingredient14;
    @SerializedName("strIngredient15")
    private String ingredient15;

    //measurement 1-15
    @SerializedName("strMeasure1")
    private String measure1;
    @SerializedName("strMeasure2")
    private String measure2;
    @SerializedName("strMeasure3")
    private String measure3;
    @SerializedName("strMeasure4")
    private String measure4;
    @SerializedName("strMeasure5")
    private String measure5;
    @SerializedName("strMeasure6")
    private String measure6;
    @SerializedName("strMeasure7")
    private String measure7;
    @SerializedName("strMeasure8")
    private String measure8;
    @SerializedName("strMeasure9")
    private String measure9;
    @SerializedName("strMeasure10")
    private String measure10;
    @SerializedName("strMeasure11")
    private String measure11;
    @SerializedName("strMeasure12")
    private String measure12;
    @SerializedName("strMeasure13")
    private String measure13;
    @SerializedName("strMeasure14")
    private String measure14;
    @SerializedName("strMeasure15")
    private String measure15;
    @SerializedName("dateModified")
    private String date;

    public Cocktail(int idDrink, String name, String drinkES, String drinkDE, String drinkFR,
                    String drinkZHHANS, String drinkZHHANT, String videoURL, String category,
                    String iba, String alcohol, String glass, String instructions,
                    String instructionsES, String instructionsDE, String instructionsFR,
                    String instructionsZHHS, String instructionsZHHT, String thumbnailURL,
                    String ingredient1, String ingredient2, String ingredient3, String ingredient4,
                    String ingredient5, String ingredient6, String ingredient7, String ingredient8,
                    String ingredient9, String ingredient10, String ingredient11,
                    String ingredient12, String ingredient13, String ingredient14,
                    String ingredient15, String measure1, String measure2, String measure3,
                    String measure4, String measure5, String measure6, String measure7,
                    String measure8, String measure9, String measure10, String measure11,
                    String measure12, String measure13, String measure14, String measure15, String date) {
        this.idDrink = idDrink;
        this.name = name;
        this.drinkES = drinkES;
        this.drinkDE = drinkDE;
        this.drinkFR = drinkFR;
        this.drinkZHHANS = drinkZHHANS;
        this.drinkZHHANT = drinkZHHANT;
        this.videoURL = videoURL;
        this.Category = category;
        this.iba = iba;
        this.alcohol = alcohol;
        this.glass = glass;
        this.instructions = instructions;
        this.instructionsES = instructionsES;
        this.instructionsDE = instructionsDE;
        this.instructionsFR = instructionsFR;
        this.instructionsZHHS = instructionsZHHS;
        this.instructionsZHHT = instructionsZHHT;
        this.thumbnailURL = thumbnailURL;
        this.ingredient1 = ingredient1;
        this.ingredient2 = ingredient2;
        this.ingredient3 = ingredient3;
        this.ingredient4 = ingredient4;
        this.ingredient5 = ingredient5;
        this.ingredient6 = ingredient6;
        this.ingredient7 = ingredient7;
        this.ingredient8 = ingredient8;
        this.ingredient9 = ingredient9;
        this.ingredient10 = ingredient10;
        this.ingredient11 = ingredient11;
        this.ingredient12 = ingredient12;
        this.ingredient13 = ingredient13;
        this.ingredient14 = ingredient14;
        this.ingredient15 = ingredient15;
        this.measure1 = measure1;
        this.measure2 = measure2;
        this.measure3 = measure3;
        this.measure4 = measure4;
        this.measure5 = measure5;
        this.measure6 = measure6;
        this.measure7 = measure7;
        this.measure8 = measure8;
        this.measure9 = measure9;
        this.measure10 = measure10;
        this.measure11 = measure11;
        this.measure12 = measure12;
        this.measure13 = measure13;
        this.measure14 = measure14;
        this.measure15 = measure15;
        this.date = date;
    }
}
