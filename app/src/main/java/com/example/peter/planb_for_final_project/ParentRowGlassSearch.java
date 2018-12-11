package com.example.peter.planb_for_final_project;
import java.util.List;
import java.util.ArrayList;

public class ParentRowGlassSearch {
    private String name;
    private ArrayList<ChildRowGlassSearch> childList;

    public ParentRowGlassSearch(String name, ArrayList<ChildRowGlassSearch> childList) {
        this.name = name;
        this.childList = childList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<ChildRowGlassSearch> getChildList() {
        return childList;
    }

    public void setChildList(ArrayList<ChildRowGlassSearch> childList) {
        this.childList = childList;
    }
}
