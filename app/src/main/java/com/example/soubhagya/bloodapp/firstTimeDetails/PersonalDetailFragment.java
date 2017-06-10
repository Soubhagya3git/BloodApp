package com.example.soubhagya.bloodapp.firstTimeDetails;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.soubhagya.bloodapp.R;
import com.example.soubhagya.bloodapp.database.DatabaseHelper;
import com.example.soubhagya.bloodapp.database.DbSchema.UserProfileTable;
import com.example.soubhagya.bloodapp.utils.DataStash;
import com.example.soubhagya.bloodapp.utils.SharedPrefManager;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by soubhagya on 1/6/17.
 */

public class PersonalDetailFragment extends Fragment {

    private EditText mEditTextUsername;
    private EditText mEditTextDateOfBirth;
    private static String mUsername;
    private static String mDateOfBirth;
    private static String mUserId;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_details_personal, container, false);

        mUserId = FirebaseAuth.getInstance().getCurrentUser().getUid();

        mEditTextUsername = (EditText) view.findViewById(R.id.editText_username);
        mEditTextUsername.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mUsername = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mEditTextDateOfBirth = (EditText) view.findViewById(R.id.editText_date_of_birth);
        mEditTextDateOfBirth.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mDateOfBirth = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        Log.d("PERSONAL_VIEW: ", "is destroyed");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("PERSONAL_FRAGMENT: ", "is destroyed");
    }

    public static void addPersonalToDatabase() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(UserProfileTable.Columns.USERNAME, mUsername);
        contentValues.put(UserProfileTable.Columns.DATE_OF_BIRTH, mDateOfBirth);

        String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();

        SQLiteDatabase database = DataStash.INSTANCE.getDatabase();
        database.update(UserProfileTable.NAME, contentValues,
                        UserProfileTable.Columns.USER_ID + " = ?",
                        new String[] {userId});
    }
}
