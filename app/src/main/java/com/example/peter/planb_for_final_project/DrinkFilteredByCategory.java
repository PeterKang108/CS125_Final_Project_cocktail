package com.example.peter.planb_for_final_project;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DrinkFilteredByCategory {
    @SerializedName("drinks")
    private List<DrinkFilteredByCatergoryResult> filteredByCatergoryResults;

    public DrinkFilteredByCategory(List<DrinkFilteredByCatergoryResult> filteredByCatergoryResults) {
        this.filteredByCatergoryResults = filteredByCatergoryResults;
    }

    public List<DrinkFilteredByCatergoryResult> getFilteredByCatergoryResults() {
        return filteredByCatergoryResults;
    }
}
