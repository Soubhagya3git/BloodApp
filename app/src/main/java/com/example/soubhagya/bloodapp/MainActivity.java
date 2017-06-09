package com.example.soubhagya.bloodapp;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.soubhagya.bloodapp.database.DatabaseHelper;
import com.example.soubhagya.bloodapp.firstTimeDetails.DetailsSliderActivity;
import com.example.soubhagya.bloodapp.utils.SharedPrefManager;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteDatabase database = new DatabaseHelper(getApplicationContext())
                                        .getWritableDatabase();
        database
    }
}
