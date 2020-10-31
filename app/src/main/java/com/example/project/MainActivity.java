package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout mDrawerLayout;
    private Toolbar toolbar;
    private static final String KEY_TITLE = "Title";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        updateUI();

        mDrawerLayout = findViewById(R.id.layout_nav_drawer);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,mDrawerLayout,toolbar,
                R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if(savedInstanceState == null) {

            getSupportActionBar().setTitle("Home");
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }
        else {
            getSupportActionBar().setTitle(savedInstanceState.getString(KEY_TITLE));
        }
    }

    //  SAVING TITLE
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(KEY_TITLE,toolbar.getTitle().toString());
    }


    //  HANDLING SELECTED ITEM IN NAVIGATION DRAWER
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.nav_search_bar :
                toolbar.setTitle("Search");
                updateUI();
                getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container,new SearchFragment()).commit();
                break;
            case R.id.nav_home :
                toolbar.setTitle("Home");
                updateUI();
                getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container,new HomeFragment()).commit();
                break;
            case R.id.nav_compare :
                toolbar.setTitle("Compare");
                updateUI();
                getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container,new CompareFragment()).commit();
                break;
        }
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void updateUI() {
        MyAnimator.animation(getBaseContext(), toolbar);
    }

    @Override
    public void onBackPressed() {
        if(mDrawerLayout.isDrawerOpen(GravityCompat.START))
            mDrawerLayout.closeDrawer(GravityCompat.START);
        else
            super.onBackPressed();
    }

}