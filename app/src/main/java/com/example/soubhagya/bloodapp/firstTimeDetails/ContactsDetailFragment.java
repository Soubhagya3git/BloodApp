package com.example.soubhagya.bloodapp.firstTimeDetails;

import android.content.ContentValues;
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
import com.example.soubhagya.bloodapp.database.DbSchema;
import com.example.soubhagya.bloodapp.utils.DataStash;
import com.example.soubhagya.bloodapp.utils.SharedPrefManager;
import com.example.soubhagya.bloodapp.database.DbSchema.UserProfileTable;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by soubhagya on 1/6/17.
 */

public class ContactsDetailFragment extends Fragment {

    private EditText mEditTextEmail;
    private EditText mEditTextPhone;
    private static String mEmail;
    private static String mPhone;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_details_contacts, container, false);

        mEditTextEmail = (EditText) view.findViewById(R.id.editText_email);
        mEditTextEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mEmail = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mEditTextPhone = (EditText) view.findViewById(R.id.editText_phone);
        mEditTextPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mPhone = s.toString();
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

        Log.d("CONTACTS_VIEW: ", "is destroyed");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("CONTACTS_FRAGMENT: ", "is destroyed");
    }

    public static void addContactsToDatabase() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(UserProfileTable.Columns.EMAIL, mEmail);
        contentValues.put(UserProfileTable.Columns.PHONE, mPhone);

        String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();

        SQLiteDatabase database = DataStash.INSTANCE.getDatabase();
        database.update(UserProfileTable.NAME, contentValues,
                UserProfileTable.Columns.USER_ID + " = ?",
                new String[] {userId});
    }
}
