package com.example.finaiapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {
    private Button buttonLogout;
    private Button buttonPersonal;
    private Button buttonSearchHousePrices;
    private Button buttonContactLoanOfficer;
    private Button buttonSelectLoanOfficer;
    private Button buttonCheckEligibility;
    private Button buttonRateApp;
    private TextView textViewUserEmail;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;


    private FirebaseAuth firebaseAuth;

    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        //initializing firebase authentication object
        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUtil.openFbReference("users");
        firebaseAuth = FirebaseAuth.getInstance();
        mFirebaseDatabase = FirebaseUtil.mFirebaseDatabase;
        mDatabaseReference = FirebaseUtil.mDatabaseReference;

        //if the user is not logged in
        //that means current user will return null
        if (firebaseAuth.getCurrentUser() == null) {
            //closing this activity
            finish();
            //starting login activity
            startActivity(new Intent(this, LoginActivity.class));
        }

        //getting current user
        user = firebaseAuth.getCurrentUser();

        //initializing views
        textViewUserEmail = (TextView) findViewById(R.id.textViewUserEmail);
        buttonLogout = (Button) findViewById(R.id.buttonLogout);
        buttonPersonal = (Button) findViewById(R.id.buttonPersonal);
        buttonSearchHousePrices = (Button) findViewById(R.id.buttonSearchHousePrices);
        buttonContactLoanOfficer = (Button) findViewById(R.id.buttonContactLoanOfficer);
        buttonSelectLoanOfficer = (Button) findViewById(R.id.buttonSelectLoanOfficer);
        buttonRateApp = (Button) findViewById(R.id.buttonRateApp);

        buttonCheckEligibility = (Button) findViewById((R.id.buttonCheckEligibility));
        mDatabaseReference = mDatabaseReference.child(firebaseAuth.getCurrentUser().getUid());
        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                 if (snapshot.hasChild("firstName")) {

                    String firstName = snapshot.child("firstName").getValue().toString();
                    //displaying logged in user name
                    textViewUserEmail.setText("Welcome " + firstName);
                } else {
                     String displayName = user.getDisplayName();

                     textViewUserEmail.setText("Welcome " + displayName);

                 }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        //adding listener to button
        buttonLogout.setOnClickListener(this);
        buttonPersonal.setOnClickListener(this);
        buttonSearchHousePrices.setOnClickListener(this);
        buttonContactLoanOfficer.setOnClickListener(this);
        buttonSelectLoanOfficer.setOnClickListener(this);
        buttonCheckEligibility.setOnClickListener(this);
        buttonRateApp.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        // perform action on click
        switch (view.getId()) {
            case R.id.buttonLogout:
                // logout is pressed
                //logging out the user
                firebaseAuth.signOut();


                GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                        .requestIdToken(getString(R.string.default_web_client_id))
                        .requestEmail()
                        .build();

                // Build a GoogleSignInClient with the options specified by gso.
                GoogleSignInClient mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

                // Google sign out
                mGoogleSignInClient.signOut().addOnCompleteListener(this,
                        new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
//                            updateUI(null);
                            }
                        });

                //closing activity
                finish();
                //starting login activity
                startActivity(new Intent(this, LoginActivity.class));
                break;

            case R.id.buttonPersonal:
                // move to personal info
                startActivity(new Intent(this, PersonalInfo.class));
                break;

            case R.id.buttonSearchHousePrices:
                finish();
                //starting login activity
                startActivity(new Intent(this, HouseDataActivity.class));
                break;

            case R.id.buttonContactLoanOfficer:
                //switch to contact loan officer activity
                startActivity(new Intent(this, ContactLoanOfficerActivity.class));
                break;

            case R.id.buttonSelectLoanOfficer:
                //switch to select loan officer activity
                startActivity(new Intent(this, SelectLoanOfficerActivity.class));
                break;

            case R.id.buttonRateApp:
                //switch to select rating activity
                startActivity(new Intent(this, RatingActivity.class));
                break;
        }
        if (view == buttonCheckEligibility) {
            finish();
            //starting login activity
            startActivity(new Intent(this, LoanEligibilityActivity.class));
        }

    }
}