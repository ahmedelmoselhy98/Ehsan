package com.e.k.m.a.ehsan.clothespage;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.e.k.m.a.ehsan.R;
import com.e.k.m.a.ehsan.models.DonationPost;
import com.e.k.m.a.ehsan.models.DonorModel;
import com.e.k.m.a.ehsan.models.FirebaseConstants;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class FoodPage extends AppCompatActivity {

    private DonorModel globalDonorModel;
    private DonationPost globalDonationPost;
    private TextView userNameTextView,userAddressTextView,userPhoneNumber;
    private CircleImageView userProfileImageView;
    private EditText postDescriptionEditText;
    private Button submitDonation;
    private FirebaseAuth mFirebaseAuth;
    private FirebaseUser mFirebaseUser;
    private DatabaseReference mDatabaseReference;
    private static final String TAG = "FoodPage";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_page);
        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseUser = mFirebaseAuth.getCurrentUser();
        mDatabaseReference = FirebaseDatabase.getInstance().getReference();
        getDonorData();
    }

    // get the donor data from firebase database
    public void getDonorData(){
        String userID = mFirebaseUser.getUid();
        DatabaseReference donorUserDatabaseReference = mDatabaseReference.child(FirebaseConstants.USERS).child(FirebaseConstants.DONOR_USERS).child(userID);
        donorUserDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                globalDonorModel = dataSnapshot.getValue(DonorModel.class);
                polishUi(globalDonorModel);
                Log.e(TAG, "success to read value.");
                Toast.makeText(FoodPage.this, globalDonorModel.getDonorName()+" "+
                        globalDonorModel.getDonorAddress()+" "+globalDonorModel.getDonorPhoneNumber(), Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e(TAG, "Failed to read value.", databaseError.toException());
            }
        });
    }


    /////////////////////////////////////////////
    // fill Ui with user data and initialize the ui elements
    public void polishUi(DonorModel donorModel){
        userNameTextView = findViewById(R.id.food_page_donor_name_textview);
        userNameTextView.setText(donorModel.getDonorName());
        userAddressTextView = findViewById(R.id.food_page_donor_address_textview);
        userAddressTextView.setText(donorModel.getDonorAddress());
        userPhoneNumber = findViewById(R.id.food_page_donor_phone_number_textview);
        userPhoneNumber.setText(donorModel.getDonorPhoneNumber());
        userProfileImageView = findViewById(R.id.food_page_donor_image_imageview);
        if (!TextUtils.isEmpty(globalDonorModel.getDonorProfileImage()))
            Picasso.with(this).load(globalDonorModel.getDonorProfileImage()).into(userProfileImageView);
        postDescriptionEditText = findViewById(R.id.food_page_donation_description_edittext);
        submitDonation = findViewById(R.id.food_page_donate_button);
        submitDonation.setOnClickListener(onClickListener);
    }


    // use to build post object to pass it to firebase
    public void buildPost(){
        globalDonationPost = new DonationPost();
        globalDonationPost.setDonarName(globalDonorModel.getDonorName());
        globalDonationPost.setDonarAddress(globalDonorModel.getDonorAddress());
        globalDonationPost.setDonarPhoneNumber(globalDonorModel.getDonorPhoneNumber());
        globalDonationPost.setDonarImage(globalDonorModel.getDonorProfileImage());
        globalDonationPost.setDescription(postDescriptionEditText.getText().toString());
    }
    public void addPostToFoodCategory(){
        DatabaseReference donorUserDatabaseReference = mDatabaseReference.child(FirebaseConstants.FOOD_CATEGORY);
        donorUserDatabaseReference.push().setValue(globalDonationPost).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Log.e(TAG, "addPostToFoodCategory:success");
                    Toast.makeText(FoodPage.this, "Done", Toast.LENGTH_SHORT).show();
                }else {
                    Log.e(TAG, "addPostToFoodCategory:failure", task.getException());
                }
            }
        });
    }
    public void addPostToMyDonation(){
        String userID = mFirebaseUser.getUid();
        DatabaseReference donorUserDatabaseReference = mDatabaseReference.child(FirebaseConstants.DONOR_DONATIONS).child(userID);
        donorUserDatabaseReference.push().setValue(globalDonationPost).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Log.e(TAG, "addPostToMyDonation:success");
                    Toast.makeText(FoodPage.this, "Done", Toast.LENGTH_SHORT).show();
                }else {
                    Log.e(TAG, "addPostToMyDonation:failure", task.getException());
                }
            }
        });
    }

    // here the action of the register button
    public View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            buildPost();
            addPostToFoodCategory();
            addPostToMyDonation();

        }
    };

}
