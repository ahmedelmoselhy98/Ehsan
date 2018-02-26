package com.e.k.m.a.ehsan.authentication.signup;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.e.k.m.a.ehsan.R;
import com.e.k.m.a.ehsan.donor.HomePage;
import com.e.k.m.a.ehsan.models.DonorModel;
import com.e.k.m.a.ehsan.models.FirebaseConstants;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpAsDontorFragment extends Fragment{

    // Declaration the ui element and donor object from donor model class
    private TextInputEditText signUpDonorName,signUpDonorEmail,signUpDonorPassword,signUpDonorComfirmPassword
            ,signUpDonorAddress,signUpDonorPhoneNumber;
    private Button registerButton;
    private ProgressDialog progressDialog;
    private FirebaseAuth mFirebaseAuth;
    private FirebaseUser mFirebaseUser;
    private DatabaseReference mDatabaseReference;
    private DonorModel globalDonorModel;
    private static final String TAG = "SignUpAsDonorFragment";

    public SignUpAsDontorFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.sign_up_as_donor_fragment, container, false);
        progressDialog = new ProgressDialog(root.getContext());
        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseUser = mFirebaseAuth.getCurrentUser();
        mDatabaseReference = FirebaseDatabase.getInstance().getReference();
        inflateUiElements(root);
        return root;
    }



    // this method for Inflate the layout for this fragment
    public void inflateUiElements(View root){
        signUpDonorName = root.findViewById(R.id.sign_up_donor_user_name);
        signUpDonorEmail = root.findViewById(R.id.sign_up_donor_email);
        signUpDonorPassword = root.findViewById(R.id.sign_up_donor_password);
        signUpDonorComfirmPassword = root.findViewById(R.id.sign_up_donor_password_confirm);
        signUpDonorAddress = root.findViewById(R.id.sign_up_donor_address);
        signUpDonorPhoneNumber = root.findViewById(R.id.sign_up_donor_phone_number);
        registerButton = root.findViewById(R.id.sign_up_donor_regiter);
        registerButton.setOnClickListener(onClickListener);
    }



    // this method fetchs the donor data from UI elements and assign it in donor object
    public void fetchDonorDataFromUi(){

        DonorModel donorModel = new DonorModel();
        String donorName,donorEmail,donorPassword,donorPasswordComfirm,donorAddress,donorPhoneNumber,donorImage;
                donorName = signUpDonorName.getText().toString();
                donorEmail = signUpDonorEmail.getText().toString();
                donorPhoneNumber = signUpDonorPhoneNumber.getText().toString();
                donorAddress = signUpDonorAddress.getText().toString();
                donorPassword = signUpDonorPassword.getText().toString();
                donorPasswordComfirm = signUpDonorComfirmPassword.getText().toString();

        if (validate(donorName,donorEmail,donorPassword,donorPasswordComfirm,donorAddress,donorPhoneNumber)){
            donorModel.setDonorName(donorName);
            donorModel.setDonorEmail(donorEmail);
            donorModel.setDonorAddress(donorAddress);
            donorModel.setDonorPhoneNumber(donorPhoneNumber);
            donorModel.setDonorProfileImage("");
            globalDonorModel = donorModel;
            createDonorAccountOnFirebaseAuthentication(donorEmail,donorPassword);
        }
    }

    // this method use the donor object that return from the fetchDonorDataFromUi() and push it to firebase
    // using createAccountWithEmailAndPassword() to create the donor account on firebase Authentication
    public void createDonorAccountOnFirebaseAuthentication(String email,String password){

        mFirebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.e(TAG, "createUserWithEmail:success");
                            Toast.makeText(getActivity(), "Authentication success.",
                                    Toast.LENGTH_SHORT).show();
                            createDonorProfileOnFirebaseDatabase(globalDonorModel);
                            FirebaseUser user = mFirebaseAuth.getCurrentUser();
//                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.e(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(getActivity(), "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
//                            updateUI(null);
                        }
                    }
                });

    }

    // this method use to create the donor profile and push it's data to firebase database
    public void createDonorProfileOnFirebaseDatabase(final DonorModel donorModel){
        //  here is firebase code to Create new Account
        String userID = mFirebaseUser.getUid();
        DatabaseReference donorUserDatabaseReference = mDatabaseReference.child(FirebaseConstants.USERS).child(FirebaseConstants.DONOR_USERS).child(userID);
        donorUserDatabaseReference.setValue(donorModel).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Log.e(TAG, "createProfile:success", task.getException());
                    HomePage.userType = donorModel.getUserType();
                    Intent intent =new Intent(getActivity(),HomePage.class);
                    startActivity(intent);
                }else {
                    Log.e(TAG, "createProfile:failure", task.getException());
                }
            }
        });
    }

    // here to check if the user data is filled correctly or not
    public boolean validate(String donorName, String donorEmail, String donorPassword, String donorPasswordComfirm,
                            String donorAddress, String donorPhoneNumber){

        if (TextUtils.isEmpty(donorName)) {
            Toast.makeText(getActivity(), "يرجى كتابة اسم المتبرع", Toast.LENGTH_SHORT).show();
            return false;
        }else if (TextUtils.isEmpty(donorEmail)) {
            Toast.makeText(getActivity(), "يرجى كتابة البريد الالكترونى ", Toast.LENGTH_SHORT).show();
            return false;
        }else if (TextUtils.isEmpty(donorPassword)) {
            Toast.makeText(getActivity(), "يرجى كتابة كلمة المرور ", Toast.LENGTH_SHORT).show();
            return false;
        }else if (TextUtils.isEmpty(donorPasswordComfirm)) {
            Toast.makeText(getActivity(), "يرجى كتابة تاكيد كلمة المرور", Toast.LENGTH_SHORT).show();
            return false;
        }else if (TextUtils.isEmpty(donorAddress)) {
            Toast.makeText(getActivity(), "يرجى كتابة العنوان", Toast.LENGTH_SHORT).show();
            return false;
        }else if (TextUtils.isEmpty(donorPhoneNumber)) {
            Toast.makeText(getActivity(), "يرجى كتابة رقم الهاتف", Toast.LENGTH_SHORT).show();
            return false;
        }else if (!donorPassword.equals(donorPasswordComfirm)) {
            Toast.makeText(getActivity(), "كلمة المرور غير متطابقه", Toast.LENGTH_SHORT).show();
            return false;
        }else
            return true;
    }



    // here the action of the register button
    public View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            fetchDonorDataFromUi();

        }
    };

}