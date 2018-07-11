package divyanshsaxena.com.camflick.activities;


import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;

import divyanshsaxena.com.camflick.R;
import divyanshsaxena.com.camflick.Utilities.BottomNavMenuHelper;

public class HomeActivity extends Activity {
public static final String TAG = "HomeActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavMenu);
        BottomNavMenuHelper.disableShiftMode(bottomNavigationView);

    }
}

