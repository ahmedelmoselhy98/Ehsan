package com.e.k.m.a.ehsan.authentication.mainpage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.e.k.m.a.ehsan.R;
import com.e.k.m.a.ehsan.authentication.signin.SignInActivity;
import com.e.k.m.a.ehsan.authentication.signup.SignUpActivity;

public class MainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
    }
    public void signInPage(View view){
        startActivity(new Intent(this, SignInActivity.class));
    }
    public void signUpPage(View view){
        startActivity(new Intent(this, SignUpActivity.class));
    }

}
