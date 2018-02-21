package com.e.k.m.a.ehsan.donor;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;

import com.e.k.m.a.ehsan.R;

public class DonorHomePage extends AppCompatActivity {

    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.donor_home_nav);
        drawerLayout = findViewById(R.id.design_drawer_layout);
    }

    public void openNavBar(View view){
        Log.e("DrawerView Open","aaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        drawerLayout.openDrawer(Gravity.LEFT);
    }
    public void openFinancialDonationHomePage(View view){
        startActivity(new Intent(this,FinancialDonationHomePage.class));
    }
    public void openProfile(View view){
        startActivity(new Intent(this,Profile.class));
    }

}
