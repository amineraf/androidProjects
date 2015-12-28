package com.profileapp.arafla.profileapp;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;

public class MainFormationActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_formation);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new FormationFragmentPagerAdapter(getSupportFragmentManager(),
                MainFormationActivity.this));
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
    }


        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.main_formation_sample, menu);

        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent myIntent;
        switch (item.getItemId()) {
            case R.id.addFormationSample:
                myIntent = new Intent(MainFormationActivity.this, NouvelleFormation.class);
                MainFormationActivity.this.startActivity(myIntent);
                return true;
            case R.id.searchSample:
                myIntent = new Intent(MainFormationActivity.this, ResultatRecherche.class);
                MainFormationActivity.this.startActivity(myIntent);
                return true;
            case R.id.action_settings:
                myIntent = new Intent(MainFormationActivity.this, LoginActivity.class);
                MainFormationActivity.this.startActivity(myIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
