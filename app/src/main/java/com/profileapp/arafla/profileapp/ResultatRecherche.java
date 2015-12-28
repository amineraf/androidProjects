package com.profileapp.arafla.profileapp;

import android.app.ActionBar;
import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;

import adapters.FormationAdapter;
import fragments.FormationFragment;
import service.FormationService;
import sheredValues.CommonSharedPreferences;

public class ResultatRecherche extends AppCompatActivity implements SearchView.OnQueryTextListener{
    private ListView formationListView;
    private FormationAdapter formationAdapter;
    private ArrayList<String> formationList;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat_recherche);

        initFriendList();
    }

    private void initFriendList() {
        formationList = CommonSharedPreferences.getInstance(getApplicationContext()).getFormationList();
        formationListView = (ListView) findViewById(R.id.resultSearch);
        formationAdapter = new FormationAdapter(this, formationList);
        formationListView.setAdapter(formationAdapter);
        formationListView.setTextFilterEnabled(false);
        formationListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position > 0 && position <= formationList.size()) {
                    CommonSharedPreferences.getInstance(getApplicationContext()).setCurrentFormation(formationList.get(position));
                    Intent myIntent = new Intent(ResultatRecherche.this, FormationActivity.class);
                    ResultatRecherche.this.startActivity(myIntent);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_formation, menu);
     //   searchMenuItem.expandActionView();
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        MenuItem searchMenuItem = (MenuItem) menu.findItem(R.id.search);
        searchMenuItem.expandActionView();
        searchView.setIconifiedByDefault(false);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setSubmitButtonEnabled(true);
        searchView.setOnQueryTextListener(this);

        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
       formationAdapter.getFilter().filter(newText);
        return true;
    }
}