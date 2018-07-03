package divyanshsaxena.com.camflick.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;

import divyanshsaxena.com.camflick.R;

public class SplashActivity extends Activity {
public static int SPLASH_TIME_OUT = 4000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
            startActivity(new Intent(SplashActivity.this, LoginActivity.class));
            finish();
            }
        },SPLASH_TIME_OUT);
    }
}
