package com.profileapp.arafla.profileapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import fragments.FormationFragment;
import sheredValues.CommonSharedPreferences;

public class FormationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String descFormationCourante= CommonSharedPreferences.getInstance(getApplicationContext()).getCurrentFormation();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formation);
        TextView formationCourante = (TextView) findViewById(R.id.descFormationCourante);
        formationCourante.setText(descFormationCourante);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_formation, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent myIntent;
        switch (item.getItemId()) {
            case R.id.participerFormation:
                Toast.makeText(FormationActivity.this, "Enregistré avec Succés", Toast.LENGTH_LONG).show();
                myIntent = new Intent(FormationActivity.this, MainFormationActivity.class);
                FormationActivity.this.startActivity(myIntent);
                return true;
        }
        return  true;
    }
}
