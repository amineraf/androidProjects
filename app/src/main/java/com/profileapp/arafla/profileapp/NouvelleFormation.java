package com.profileapp.arafla.profileapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;

import sheredValues.CommonSharedPreferences;

public class NouvelleFormation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nouvelle_formation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
/*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Formation enregistré avec succés", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.nouvelle_formation_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_settings) {
            Intent myIntent = new Intent(NouvelleFormation.this, LoginActivity.class);
            NouvelleFormation.this.startActivity(myIntent);
            return true;
        } else if (item.getItemId() == R.id.ajoutFormation) {
            ArrayList<String> formationList =CommonSharedPreferences.getInstance(this.getApplicationContext()).getFormationList();
            RelativeLayout coreFormationView=(RelativeLayout)findViewById(R.id.contentFormation);
            TextView descNewFormationTextView = (TextView) coreFormationView.findViewById(R.id.descNewFormation);;
            String descNewFormation = descNewFormationTextView.getText().toString();
            if (formationList != null && descNewFormation != null) {
                formationList.add(descNewFormation);
                CommonSharedPreferences.getInstance(this.getApplicationContext()).setFormationList(formationList);
                Intent myIntent = new Intent(NouvelleFormation.this, MainFormationActivity.class);
                NouvelleFormation.this.startActivity(myIntent);
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
