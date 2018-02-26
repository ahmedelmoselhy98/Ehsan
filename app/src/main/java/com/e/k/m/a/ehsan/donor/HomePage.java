package com.e.k.m.a.ehsan.donor;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.e.k.m.a.ehsan.AboutUs;
import com.e.k.m.a.ehsan.R;
import com.e.k.m.a.ehsan.association.DonorsRecyclerView;
import com.e.k.m.a.ehsan.association.MyDoationsPage;
import com.e.k.m.a.ehsan.authentication.mainpage.MainPage;
import com.e.k.m.a.ehsan.clothespage.ClothesPage;
import com.e.k.m.a.ehsan.clothespage.FoodPage;
import com.e.k.m.a.ehsan.models.DonorModel;
import com.e.k.m.a.ehsan.models.FirebaseConstants;
import com.e.k.m.a.ehsan.models.UserType;
import com.e.k.m.a.ehsan.settings.Settings;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class HomePage extends AppCompatActivity {

    DrawerLayout drawerLayout;
    private TextView userNameTextView,userEmailTextView;
    public static String userType;
    private DonorModel globalDonorModel;
    private FirebaseAuth mFirebaseAuth;
    private FirebaseUser mFirebaseUser;
    private DatabaseReference mDatabaseReference;
    private static final String TAG = "HomePage";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
        drawerLayout = findViewById(R.id.design_drawer_layout);
        mFirebaseAuth = FirebaseAuth.getInstance();
        userNameTextView = findViewById(R.id.home_page_nav_username_textview);
        userEmailTextView = findViewById(R.id.home_page_nav_useremail_textview);
    }


    // open navigation drawer via Nav icon in tool bar
    public void openNavBar(View view){
        drawerLayout.openDrawer(Gravity.LEFT);
    }



//    // get the donor data from firebase database
    public void getDonorData(){
        String userID = mFirebaseUser.getUid();
        DatabaseReference donorUserDatabaseReference = null;
        if (userType.equals(UserType.DONOR_USER)) {
            donorUserDatabaseReference = mDatabaseReference.child(FirebaseConstants.USERS).child(FirebaseConstants.DONOR_USERS).child(userID);
        }else
            donorUserDatabaseReference = mDatabaseReference.child(FirebaseConstants.USERS).child(FirebaseConstants.ASSOCIATION_USERS).child(userID);
        donorUserDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                globalDonorModel = dataSnapshot.getValue(DonorModel.class);
                userNameTextView.setText(globalDonorModel.getDonorName());
                userEmailTextView.setText(globalDonorModel.getDonorEmail());

                //TODO: homepage set user Image
                Log.e(TAG, "success to read value.");
                Toast.makeText(HomePage.this, globalDonorModel.getDonorName()+" "+globalDonorModel.getDonorEmail()+" "
                        +globalDonorModel.getDonorAddress()+" "+globalDonorModel.getDonorPhoneNumber(), Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e(TAG, "Failed to read value.", databaseError.toException());
            }
        });
    }

/////////////////////////////////////////////////////////////
// home page items actions
    public void openFinancialDonationHomePage(View view){
        if (userType.equals(UserType.ASSOCIATION_USER)){
            startActivity(new Intent(this,DonorsRecyclerView.class));
        }else
            startActivity(new Intent(this,FinancialDonationHomePage.class));
    }
    public void openClothesPage(View view){
        if (userType.equals(UserType.ASSOCIATION_USER)){
            startActivity(new Intent(this,DonorsRecyclerView.class));
        }else
            startActivity(new Intent(this,ClothesPage.class));
    }
    public void openFoodPage(View view){
        if (userType.equals(UserType.ASSOCIATION_USER)){
            startActivity(new Intent(this,DonorsRecyclerView.class));
        }else
            startActivity(new Intent(this,FoodPage.class));
    }
    public void openSchoolToolsPage(View view){
        if (userType.equals(UserType.ASSOCIATION_USER)){
            startActivity(new Intent(this,DonorsRecyclerView.class));
        }else
            Toast.makeText(this,"غير متوفره حاليا",Toast.LENGTH_SHORT).show();
    }
    public void openHouseToolsPage(View view){
        if (userType.equals(UserType.ASSOCIATION_USER)){
            startActivity(new Intent(this,DonorsRecyclerView.class));
        }else
            Toast.makeText(this,"غير متوفره حاليا",Toast.LENGTH_SHORT).show();
    }

/////////////////////////////////////////////////////////////
// navegation drawer items action
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
    public void logOut(View view) {
        mFirebaseAuth.signOut();
        startActivity(new Intent(this, MainPage.class));
    }
}
