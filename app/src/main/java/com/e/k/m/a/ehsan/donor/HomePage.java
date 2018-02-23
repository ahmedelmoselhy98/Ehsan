package com.e.k.m.a.ehsan.donor;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.e.k.m.a.ehsan.AboutUs;
import com.e.k.m.a.ehsan.R;
import com.e.k.m.a.ehsan.association.DonorsRecyclerView;
import com.e.k.m.a.ehsan.association.MyDoationsPage;
import com.e.k.m.a.ehsan.clothespage.ClothesPage;
import com.e.k.m.a.ehsan.settings.Settings;

public class HomePage extends AppCompatActivity {

    DrawerLayout drawerLayout;
    public static String userType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
        drawerLayout = findViewById(R.id.design_drawer_layout);
    }

    public void openNavBar(View view){
        Log.e("DrawerView Open","aaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        drawerLayout.openDrawer(Gravity.LEFT);
    }
    public void openFinancialDonationHomePage(View view){
        if (userType.equals("association")){
            startActivity(new Intent(this,DonorsRecyclerView.class));
        }else
            startActivity(new Intent(this,FinancialDonationHomePage.class));
    }

    public void openClothesPage(View view){
        if (userType.equals("association")){
            startActivity(new Intent(this,DonorsRecyclerView.class));
        }else
            startActivity(new Intent(this,ClothesPage.class));
    }
    public void openFurniturePage(View view){
        if (userType.equals("association")){
            startActivity(new Intent(this,DonorsRecyclerView.class));
        }else
            Toast.makeText(this,"غير متوفره حاليا",Toast.LENGTH_SHORT).show();

    }
    public void openSchoolToolsPage(View view){
        if (userType.equals("association")){
            startActivity(new Intent(this,DonorsRecyclerView.class));
        }else
            Toast.makeText(this,"غير متوفره حاليا",Toast.LENGTH_SHORT).show();
    }

    public void openHouseToolsPage(View view){
        if (userType.equals("association")){
            startActivity(new Intent(this,DonorsRecyclerView.class));
        }else
            Toast.makeText(this,"غير متوفره حاليا",Toast.LENGTH_SHORT).show();

    }


    public void openProfile(View view){
        startActivity(new Intent(this,Profile.class));
    }

    public void openSettings(View view) {
        startActivity(new Intent(this, Settings.class));
    }
    public void openMyDonotion(View view) {
        startActivity(new Intent(this, MyDoationsPage.class));
    }
    public void aboutUs(View view) {
        startActivity(new Intent(this, AboutUs.class));
    }
}
