package com.example.peter.planb_for_final_project;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class NewCategorySearchResult extends AppCompatActivity
        implements SearchView.OnQueryTextListener, SearchView.OnCloseListener {

    private SearchManager searchManager;
    private android.widget.SearchView searchView;
    private MyExpandableListAdapterCategorySearch listAdapterCategorySearch;
    private ExpandableListView myList;
    private ArrayList<ParentRowCategorySearch> parentList
            = new ArrayList<ParentRowCategorySearch>();
    private ArrayList<ParentRowCategorySearch> shwoTheseParentList
            = new ArrayList<ParentRowCategorySearch>();
    private MenuItem searchItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_category_search_result);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);

        parentList = new ArrayList<ParentRowCategorySearch>();
        shwoTheseParentList = new ArrayList<ParentRowCategorySearch>();

        // The app will crash if display list is not called here.
        displayList();

        //This expends the lsit of continents.
        expandAll();

    }

    private void loadData() {
        ArrayList<ChildRowCategorySearch> childRows = new ArrayList<ChildRowCategorySearch>();
        ParentRowCategorySearch parentRow = null;

        childRows = new ArrayList<ChildRowCategorySearch>();
        childRows.add(new ChildRowCategorySearch(R.drawable.ic_launcher_foreground
                , "Ordinary Drink"));
        childRows.add(new ChildRowCategorySearch(R.drawable.ic_launcher_foreground
                , "Cocktail"));
        childRows.add(new ChildRowCategorySearch(R.drawable.ic_launcher_foreground
                , "Milk/Float/Shake"));
        childRows.add(new ChildRowCategorySearch(R.drawable.ic_launcher_foreground
                , "Cocoa"));
        childRows.add(new ChildRowCategorySearch(R.drawable.ic_launcher_foreground
                , "Shot"));
        childRows.add(new ChildRowCategorySearch(R.drawable.ic_launcher_foreground
                , "Coffee/Tee"));
        childRows.add(new ChildRowCategorySearch(R.drawable.ic_launcher_foreground
                , "Homemade Liqueur"));
        childRows.add(new ChildRowCategorySearch(R.drawable.ic_launcher_foreground
                , "Punch/Party Drink"));
        childRows.add(new ChildRowCategorySearch(R.drawable.ic_launcher_foreground
                , "Beer"));
        childRows.add(new ChildRowCategorySearch(R.drawable.ic_launcher_foreground
                , "Soft Drink/Soda"));
        childRows.add(new ChildRowCategorySearch(R.drawable.ic_launcher_foreground
                , "Other/Unknown"));
        parentRow = new ParentRowCategorySearch("Category", childRows);
        parentList.add(parentRow);

    }


    private void expandAll() {
        int count = listAdapterCategorySearch.getGroupCount();
        for (int i = 0; i < count; i++) {
            myList.expandGroup(i);
        } // end for (int i = 0; i < count; i++)
    }

    private void displayList() {
        loadData();

        myList = (ExpandableListView) findViewById(R.id.expandableListView_search);
        listAdapterCategorySearch
                = new MyExpandableListAdapterCategorySearch(NewCategorySearchResult.this
                , parentList);

        myList.setAdapter(listAdapterCategorySearch);
    }

    @Override
    public boolean onClose() {
        listAdapterCategorySearch.filterData("");
        expandAll();
        return false;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        listAdapterCategorySearch.filterData(query);
        expandAll();
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        listAdapterCategorySearch.filterData(newText);
        expandAll();
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_category, menu);
        searchItem = menu.findItem(R.id.action_search);
        searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(false);
        searchView.setOnQueryTextListener(this);
        searchView.setOnCloseListener(this);
        searchView.requestFocus();

        return true;
    }
}
