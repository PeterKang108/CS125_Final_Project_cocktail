package com.example.peter.planb_for_final_project;

import java.util.ArrayList;

public class ParentRowCategorySearch {
    private String name;
    private ArrayList<ChildRowCategorySearch> childList;

    public ParentRowCategorySearch(String name, ArrayList<ChildRowCategorySearch> childList) {
        this.name = name;
        this.childList = childList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<ChildRowCategorySearch> getChildList() {
        return childList;
    }

    public void setChildList(ArrayList<ChildRowCategorySearch> childList) {
        this.childList = childList;
    }
}
