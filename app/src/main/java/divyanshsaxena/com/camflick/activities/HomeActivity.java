package divyanshsaxena.com.camflick.activities;


import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.TabHost;

import com.nostra13.universalimageloader.core.ImageLoader;

import divyanshsaxena.com.camflick.R;
import divyanshsaxena.com.camflick.Utilities.BottomNavMenuHelper;
import divyanshsaxena.com.camflick.Utilities.SectionsPagerAdapter;
import divyanshsaxena.com.camflick.Utilities.UniversalImageLoader;
import divyanshsaxena.com.camflick.fragment.HomeFragment;
import divyanshsaxena.com.camflick.fragment.QuickCameraFragment;
import divyanshsaxena.com.camflick.fragment.SellShopFragment;

public class HomeActivity extends AppCompatActivity {
    public static final String TAG = "HomeActivity";
    public static final int ACTIVITY_NUM = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Log.d(TAG, "onCreate : starting.");
        intImageLoader();

        setupBottomNavigationView();
        setupViewPager();
    }


    private void intImageLoader() {

        UniversalImageLoader universalImageLoader = new UniversalImageLoader(HomeActivity.this);
        ImageLoader.getInstance().init(universalImageLoader.getConfig());
    }

    private void setupViewPager() {
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new QuickCameraFragment());
        adapter.addFragment(new HomeFragment());
        adapter.addFragment(new SellShopFragment());
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
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

