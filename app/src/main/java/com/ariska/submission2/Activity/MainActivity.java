package com.ariska.submission2.Activity;

import android.os.Bundle;
import android.view.MenuItem;

import com.ariska.submission2.Fragment.MoviesFragment;
import com.ariska.submission2.R;
import com.ariska.submission2.Fragment.TvShowFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity {

private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener
        = new BottomNavigationView.OnNavigationItemSelectedListener() {
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        Fragment fragment;

        switch (menuItem.getItemId()){

            case R.id.navigation_movies:
                fragment = new MoviesFragment();
                getSupportFragmentManager().beginTransaction().
                        replace(R.id.container_layout, fragment, fragment.getClass().getSimpleName()).commit();
                return true;

            case R.id.navigation_tvShow:
                fragment = new TvShowFragment();
                getSupportFragmentManager().beginTransaction().
                        replace(R.id.container_layout, fragment, fragment.getClass().getSimpleName()).commit();
                return true;
        }
        return false;
    }

};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);

        if (savedInstanceState == null){

            navView.setSelectedItemId(R.id.navigation_movies);
        }
    }
}
