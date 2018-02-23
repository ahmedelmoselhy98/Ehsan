package com.e.k.m.a.ehsan.authentication.signin;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.e.k.m.a.ehsan.R;
import com.e.k.m.a.ehsan.donor.HomePage;

public class SignInActivity extends AppCompatActivity {

    private TextInputEditText email;
    private TextInputEditText password;
    private String emailText,passwordText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        email = findViewById(R.id.sign_in_page_email);
        password = findViewById(R.id.sign_in_page_password);
    }


    public void signInPageRigister(View view) {
        emailText = email.getText().toString();
        passwordText = password.getText().toString();

        if (emailText.equals("d_user")& passwordText.equals("123")){
            HomePage.userType = "user";
            Intent intent = new Intent(this, HomePage.class);
            startActivity(intent);

        }else if (emailText.equals("a_user")& passwordText.equals("123")){
        HomePage.userType = "association";
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
        }
    }
}
