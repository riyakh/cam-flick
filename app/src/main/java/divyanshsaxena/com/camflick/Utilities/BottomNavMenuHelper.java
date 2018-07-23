package divyanshsaxena.com.camflick.Utilities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.design.internal.BottomNavigationItemView;
import android.util.Log;
import android.view.MenuItem;

import java.lang.reflect.Field;

import divyanshsaxena.com.camflick.R;
import divyanshsaxena.com.camflick.activities.HomeActivity;
import divyanshsaxena.com.camflick.activities.NotificationActivity;
import divyanshsaxena.com.camflick.activities.ProfileActivity;
import divyanshsaxena.com.camflick.activities.SearchActivity;
import divyanshsaxena.com.camflick.activities.UploadActivity;
import divyanshsaxena.com.camflick.popups.ProfilePopup;

public class BottomNavMenuHelper {


    @SuppressLint("RestrictedApi")
    public static void disableShiftMode(BottomNavigationView view) {
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) view.getChildAt(0);
        try {
            Field shiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");
            shiftingMode.setAccessible(true);
            shiftingMode.setBoolean(menuView, false);
            shiftingMode.setAccessible(false);
            for (int i = 0; i < menuView.getChildCount(); i++) {
                BottomNavigationItemView item = (BottomNavigationItemView) menuView.getChildAt(i);
                //noinspection RestrictedApi
                item.setShiftingMode(false);
                // set once again checked value, so view will be updated
                //noinspection RestrictedApi
                item.setChecked(item.getItemData().isChecked());
            }
        } catch (NoSuchFieldException e) {
            Log.e("BNVHelper", "Unable to get shift mode field", e);
        } catch (IllegalAccessException e) {
            Log.e("BNVHelper", "Unable to change value of shift mode", e);
        }
    }
    public static void enableNavigation(final Context context, BottomNavigationView view){
        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){

                    case R.id.item_home:
                        Intent intent1 = new Intent(context , HomeActivity.class);
                        intent1.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        context.startActivity(intent1);
                        break;
                    case R.id.item_search:

                        Intent intent2 = new Intent(context , SearchActivity.class);
                        intent2.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);

                        context.startActivity(intent2);
                        break;
                    case R.id.item_upload:


                        Intent intent3 = new Intent(context , UploadActivity.class);
                        intent3.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        context.startActivity(intent3);
                        break;
                    case R.id.item_notification:

                        Intent intent4 = new Intent(context , NotificationActivity.class);
                        intent4.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        context.startActivity(intent4);
                        break;

                    case R.id.item_profile:

                        Intent intent5 = new Intent(context , ProfileActivity.class);
                        intent5.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);

                        context.startActivity(intent5);
                        break;
                }

                return false;
            }
        });
    }
}
