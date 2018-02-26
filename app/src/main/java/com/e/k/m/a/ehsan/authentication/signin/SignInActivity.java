package com.e.k.m.a.ehsan.authentication.signin;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.e.k.m.a.ehsan.R;
import com.e.k.m.a.ehsan.donor.HomePage;
import com.e.k.m.a.ehsan.models.DonorModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

import org.w3c.dom.Text;

public class SignInActivity extends AppCompatActivity {

    private TextInputEditText email;
    private TextInputEditText password;
    private String emailText,passwordText;

    private FirebaseAuth mFirebaseAuth;
    private FirebaseUser mFirebaseUser;
    private DatabaseReference mDatabaseReference;

    private static final String TAG = "SignInActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        mFirebaseAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.sign_in_page_email);
        password = findViewById(R.id.sign_in_page_password);
    }


    public void signInPageRigister(View view) {
        emailText = email.getText().toString();
        passwordText = password.getText().toString();
        //chec if the
        if (!TextUtils.isEmpty(emailText) & !TextUtils.isEmpty(passwordText)) {
            mFirebaseAuth.signInWithEmailAndPassword(emailText, passwordText)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                HomePage.userType = "donor";
                                Intent intent = new Intent(SignInActivity.this, HomePage.class);
                                startActivity(intent);
                                Log.d(TAG, "signInWithEmail:success");
                                FirebaseUser user = mFirebaseAuth.getCurrentUser();
                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w(TAG, "signInWithEmail:failure", task.getException());
                                Toast.makeText(SignInActivity.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
                            }

                            // ...
                        }
                    });
        }
    }
}
