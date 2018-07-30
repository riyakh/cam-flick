package divyanshsaxena.com.camflick.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

import divyanshsaxena.com.camflick.R;
import divyanshsaxena.com.camflick.Utilities.BottomNavMenuHelper;
import divyanshsaxena.com.camflick.Utilities.UniversalImageLoader;

public class ProfileActivity extends AppCompatActivity {
    private static final String TAG = "ProfileActivity";
    public static final int ACTIVITY_NUM = 4;
    private ImageView profilepic;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Log.d(TAG, "onCreate: started. ");
        setupBottomNavigationView();
        setupToolbar();
        setupActivityWidget();
        setProfileImage();
    }


    public void setupGrid(ArrayList<String> imgURLs){
        GridView gridView = (GridView)findViewById(R.id.grid);

    }



    private void setProfileImage() {

        Log.d(TAG, "setProfileImage: setting profile photo");
        String imgURL = "images.idgesg.net/images/article/2017/08/android_robot_logo_by_ornecolorada_cc0_via_pixabay1904852_wide-100732483-large.jpg";
        UniversalImageLoader.setImage(imgURL, profilepic, null, "https://");

    }

    private void setupActivityWidget() {
        profilepic = (ImageView) findViewById(R.id.profileImage);

    }

    private void setupToolbar() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.profileToolbar);
        setSupportActionBar(toolbar);

        ImageView imageView = (ImageView) findViewById(R.id.profiledropmenu);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: navigating to account settings");
                Intent intent = new Intent(ProfileActivity.this, AccountSettingsActivity.class);
                startActivity(intent);

            }
        });

    }

    private void setupBottomNavigationView() {
        Log.d(TAG, "setupBottomNavigationView : setting up Bottom Navigation Menu");
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavMenu);
        BottomNavMenuHelper.disableShiftMode(bottomNavigationView);
        BottomNavMenuHelper.enableNavigation(ProfileActivity.this, bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);

    }

}
