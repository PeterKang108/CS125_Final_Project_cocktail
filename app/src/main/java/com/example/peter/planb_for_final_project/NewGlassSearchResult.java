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

public class NewGlassSearchResult extends AppCompatActivity
        implements SearchView.OnQueryTextListener, SearchView.OnCloseListener {

    private SearchManager searchManager;
    private android.widget.SearchView searchView;
    private MyExpandableListAdapterGlassSearch listAdapterGlassSearch;
    private ExpandableListView myList;
    private ArrayList<ParentRowGlassSearch> parentList = new ArrayList<ParentRowGlassSearch>();
    private ArrayList<ParentRowGlassSearch> shwoTheseParentList
            = new ArrayList<ParentRowGlassSearch>();
    private MenuItem searchItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_glass_search_result);
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

        parentList = new ArrayList<ParentRowGlassSearch>();
        shwoTheseParentList = new ArrayList<ParentRowGlassSearch>();

        // The app will crash if display list is not called here.
        displayList();

        //This expends the lsit of continents.
        expandAll();
    }

    private void loadData() {
        ArrayList<ChildRowGlassSearch> childRows = new ArrayList<ChildRowGlassSearch>();
        ParentRowGlassSearch parentRow = null;

        childRows.add(new ChildRowGlassSearch(R.drawable.ic_action_name
                , "This is test 1"));
        childRows.add(new ChildRowGlassSearch(R.drawable.ic_action_name
                , "This is test 2"));
        parentRow = new ParentRowGlassSearch("First Group", childRows);
        parentList.add(parentRow);

        childRows = new ArrayList<ChildRowGlassSearch>();
        childRows.add(new ChildRowGlassSearch(R.drawable.ic_action_name
                , "This is test 3"));
        childRows.add(new ChildRowGlassSearch(R.drawable.ic_action_name
                , "This is test 4"));
        parentRow = new ParentRowGlassSearch("Second Group", childRows);
        parentList.add(parentRow);

        childRows = new ArrayList<ChildRowGlassSearch>();
        childRows.add(new ChildRowGlassSearch(R.drawable.ic_action_name
                , "This is test 4"));
        childRows.add(new ChildRowGlassSearch(R.drawable.ic_action_name
                , "This is test 5"));
        parentRow = new ParentRowGlassSearch("Third Group", childRows);
        parentList.add(parentRow);
    }

    private void expandAll() {
        int count = listAdapterGlassSearch.getGroupCount();
        for (int i = 0; i < count; i++) {
            myList.expandGroup(i);
        } // end for (int i = 0; i < count; i++)
    }

    private void displayList() {
        loadData();

        myList = (ExpandableListView) findViewById(R.id.expandableListView_search);
        listAdapterGlassSearch
                = new MyExpandableListAdapterGlassSearch(NewGlassSearchResult.this
                , parentList);

        myList.setAdapter(listAdapterGlassSearch);
    }

    @Override
    public boolean onClose() {
        listAdapterGlassSearch.filterData("");
        expandAll();
        return false;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        listAdapterGlassSearch.filterData(query);
        expandAll();
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        listAdapterGlassSearch.filterData(newText);
        expandAll();
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_glass, menu);
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
