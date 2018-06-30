package divyanshsaxena.com.camflick;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthProvider;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class PhoneLoginActivity extends Activity {

    EditText phonenumber, varificationcode;
    String codesent;
    FirebaseAuth mauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_login);

        phonenumber = (EditText) findViewById(R.id.mobileno);
        varificationcode = (EditText) findViewById(R.id.varcod);
        mauth = FirebaseAuth.getInstance();

        findViewById(R.id.getvarcode).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendvarificationcode();

            }
        });


        findViewById(R.id.verify).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verifysign();
            }
        });
    }

    private void verifysign() {


        String code = varificationcode.getText().toString();

        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(codesent, code);
        signInWithPhoneAuthCredential(credential);
    }


    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mauth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            startActivity(new Intent(PhoneLoginActivity.this, HomeActivity.class));
                            finish();
                        } else {
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                // The verification code entered was invalid

                                Toast.makeText(getApplicationContext(), "incorrect", Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                });
    }

    private void sendvarificationcode() {

        String phoneN = phonenumber.getText().toString();

        if (phoneN.isEmpty()) {
            phonenumber.setError("phone number is required");
            phonenumber.requestFocus();
            return;
        } else if (phoneN.length() < 10) {
            phonenumber.setError("phone number is required");
            phonenumber.requestFocus();
        }

        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phoneN,
                60,
                TimeUnit.SECONDS,
                this,
                mCallbacks);

    }

    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {

        }

        @Override
        public void onVerificationFailed(FirebaseException e) {

        }

        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            codesent = s;
        }
    };

}
