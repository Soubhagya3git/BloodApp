package com.example.soubhagya.bloodapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.soubhagya.bloodapp.database.DatabaseHelper;
import com.example.soubhagya.bloodapp.database.DbSchema;
import com.example.soubhagya.bloodapp.database.UserProfileCursorWrapper;
import com.example.soubhagya.bloodapp.firstTimeDetails.DetailsSliderActivity;
import com.example.soubhagya.bloodapp.model.UserProfile;
import com.example.soubhagya.bloodapp.utils.DataStash;
import com.example.soubhagya.bloodapp.utils.SharedPrefManager;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.example.soubhagya.bloodapp.database.DbSchema.UserProfileTable;

public class MainActivity extends AppCompatActivity {

    private String mUserId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUserId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        Log.d("MAIN_ACTIVITY: ", mUserId);

        UserProfile userProfile = DataStash.INSTANCE.getUserProfileFromDatabase(mUserId);

        Log.d("MAIN_ACTIVITY: ", userProfile.getUsername() + userProfile.getDateOfBirth() +
                                userProfile.getEmail() + userProfile.getPhone());

    }
}
