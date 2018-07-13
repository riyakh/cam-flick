package divyanshsaxena.com.camflick.activities;


import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;

import divyanshsaxena.com.camflick.R;
import divyanshsaxena.com.camflick.Utilities.BottomNavMenuHelper;

public class HomeActivity extends Activity {
    public static final String TAG = "HomeActivity";
    public static final int ACTIVITY_NUM = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Log.d(TAG, "onCreate : starting.");

        setupBottomNavigationView();
    }

    private void setupViewPager(ViewPager viewPager){
//        SectionsPagerAdapter adapter = new SectionsPagerAdapter();
    }

    private void setupBottomNavigationView() {
        Log.d(TAG, "setupBottomNavigationView : setting up Bottom Navigation Menu");
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavMenu);
        BottomNavMenuHelper.disableShiftMode(bottomNavigationView);
        BottomNavMenuHelper.enableNavigation(HomeActivity.this, bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);


    }

}

