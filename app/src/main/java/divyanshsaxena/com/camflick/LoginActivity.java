package divyanshsaxena.com.camflick;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findViewById(R.id.Mobile).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchSignInGoogle();

            }
        });

        }

private void launchSignInGoogle(){
    startActivity(new Intent(LoginActivity.this, PhoneLoginActivity.class));


}
}
