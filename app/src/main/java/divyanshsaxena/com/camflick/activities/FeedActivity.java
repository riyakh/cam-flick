package divyanshsaxena.com.camflick.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;

import divyanshsaxena.com.camflick.R;
import divyanshsaxena.com.camflick.Utilities.BottomNavMenuHelper;

public class FeedActivity extends Activity {
    private static final String TAG = "FeedActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Log.d(TAG, "onCreate: started. ");
        setupBottomNavigationView();
    }


    private void setupBottomNavigationView() {
        Log.d(TAG, "setupBottomNavigationView : setting up Bottom Navigation Menu");
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavMenu);
        BottomNavMenuHelper.disableShiftMode(bottomNavigationView);

    }
}
