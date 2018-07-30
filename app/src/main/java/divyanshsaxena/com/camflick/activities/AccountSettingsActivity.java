package divyanshsaxena.com.camflick.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import divyanshsaxena.com.camflick.R;
import divyanshsaxena.com.camflick.Utilities.BottomNavMenuHelper;
import divyanshsaxena.com.camflick.Utilities.SectionStatePagerAdapter;
import divyanshsaxena.com.camflick.fragment.EditProfileFragment;
import divyanshsaxena.com.camflick.fragment.SignOutFragment;

public class AccountSettingsActivity extends AppCompatActivity {
    public static final int ACTIVITY_NUM = 4;
    private String TAG;
    private SectionStatePagerAdapter pagerAdapter;
    private ViewPager mViewPager;
    private RelativeLayout mRelativeLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accountsettings);
        Log.d(TAG, "onCreate: started");
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mRelativeLayout = (RelativeLayout) findViewById(R.id.rellayoutaccountsettings1);
        setupBottomNavigationView();

        setupSettingsList();
        setupFragment();


        ImageView imageView = (ImageView) findViewById(R.id.profilebackmenu);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: navigating to account settings");
                finish();

            }
        });
    }

    private void setupFragment() {

        pagerAdapter = new SectionStatePagerAdapter(getSupportFragmentManager());
        pagerAdapter.addFragment(new EditProfileFragment(), getString(R.string.edit_profile));
        pagerAdapter.addFragment(new SignOutFragment(), getString(R.string.sign_out));
    }

    private void setupViewpager(int fragmentNumber) {
        mRelativeLayout.setVisibility(View.GONE);
        Log.d(TAG, "setupViewpager: Navigating to fragment no #" + fragmentNumber);
        mViewPager.setAdapter(pagerAdapter);
        mViewPager.setCurrentItem(fragmentNumber);
    }

    private void setupSettingsList() {
        Log.d(TAG, "setupSettingsList: initializing setting list");
        ListView listView1 = (ListView) findViewById(R.id.lvtvAccountsettings);

        ArrayList<String> options1 = new ArrayList<>();
        options1.add("Password");
        options1.add("Blocked Users");

        ArrayAdapter arrayAdapter1 = new ArrayAdapter(AccountSettingsActivity.this, android.R.layout.simple_list_item_1, options1);

        listView1.setAdapter(arrayAdapter1);

//        ListView listView2 = (ListView) findViewById(R.id.lvtvAbout);
//
//        ArrayList<String> options2 = new ArrayList<>();
//        options2.add("About Us");
//        options2.add("Terms and Conditions");
//        options2.add("Privacy Policy");
//
//        ArrayAdapter arrayAdapter2 = new ArrayAdapter(AccountSettingsActivity.this, android.R.layout.simple_list_item_1, options2);
//
//        listView2.setAdapter(arrayAdapter2);
//        ListView listView3 = (ListView) findViewById(R.id.lvtvSupport);
//
//        ArrayList<String> options3 = new ArrayList<>();
//        options3.add("Report A Problem");
//        options3.add("Help Centre");
//
//        ArrayAdapter arrayAdapter3 = new ArrayAdapter(AccountSettingsActivity.this, android.R.layout.simple_list_item_1, options3);
//
//        listView3.setAdapter(arrayAdapter3);
//        ListView listView4 = (ListView) findViewById(R.id.lvtvLogins);
//
//        ArrayList<String> options4 = new ArrayList<>();
//        options4.add("Log Out");
//
//        ArrayAdapter arrayAdapter4 = new ArrayAdapter(AccountSettingsActivity.this, android.R.layout.simple_list_item_1, options4);
//
//        listView4.setAdapter(arrayAdapter4);


        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d(TAG, "onItemClick: navigating to fragment" + i);
                setupViewpager(i);
            }
        });

//
//        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Log.d(TAG, "onItemClick: navigating to fragment" + i);
//                setupViewpager(i);
//            }
//        });
//
//        listView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Log.d(TAG, "onItemClick: navigating to fragment" + i);
//                setupViewpager(i);
//            }
//        });
//
//        listView4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Log.d(TAG, "onItemClick: navigating to fragment" + i);
//                setupViewpager(i);
//            }
//        });
    }

    private void setupBottomNavigationView() {
        Log.d(TAG, "setupBottomNavigationView : setting up Bottom Navigation Menu");
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavMenu);
        BottomNavMenuHelper.disableShiftMode(bottomNavigationView);
        BottomNavMenuHelper.enableNavigation(AccountSettingsActivity.this, bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);

    }

}
