package com.example.mob2041_soucre_code_ph31267;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ Layout xml
        DrawerLayout drawer_navigation = findViewById(R.id.drawer_navigation);
        Toolbar toolbar_drawer_navigation = findViewById(R.id.toolbar_drawer_navigation);
        FrameLayout frame_layout_drawer_navigation = findViewById(R.id.frame_layout_drawer_navigation);
        NavigationView navigation_view = findViewById(R.id.navigation_view);
        navigation_view.setItemIconTintList(null);

        // Setup toolbar
        setSupportActionBar(toolbar_drawer_navigation);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Setup DrawerTogger
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                MainActivity.this,
                drawer_navigation,
                toolbar_drawer_navigation,
                R.string.open,
                R.string.close);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();
        drawer_navigation.addDrawerListener(toggle);


    }
}