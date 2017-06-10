package com.example.soubhagya.bloodapp.firstTimeDetails;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.soubhagya.bloodapp.R;
import com.example.soubhagya.bloodapp.database.DbSchema;
import com.example.soubhagya.bloodapp.utils.DataStash;
import com.google.firebase.auth.FirebaseAuth;

import com.example.soubhagya.bloodapp.database.DbSchema.UserProfileTable;

/**
 * Created by soubhagya on 1/6/17.
 */

public class WelcomeFragment extends Fragment {

    private static String mUserId;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mUserId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        Log.d("WELCOME_FRAGMENT: ", "is created");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_details_welcome, container, false);
        return view;
    }

    public static void addUserIdToDatabase() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(UserProfileTable.Columns.USER_ID, mUserId);

        SQLiteDatabase database = DataStash.INSTANCE.getDatabase();
        database.insert(UserProfileTable.NAME, null, contentValues);
    }
}
