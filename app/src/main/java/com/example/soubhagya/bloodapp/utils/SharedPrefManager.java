package com.example.soubhagya.bloodapp.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by soubhagya on 31/5/17.
 */

public class SharedPrefManager {

    private SharedPreferences mSharedPreferences;
    private Context mContext;

    private int PRIVATE_MODE = 0;

    private static final String SHARED_PREF_FILE = "bloodApp.sharedPref.file";
    private static final String IS_FIRST_LAUNCH = "isFirstLaunch";
    private static final String NOT_FOUND = "information not found";
    private static final String USERNAME = "username";
    private static final String DATE_OF_BIRTH = "dateOfBirth";
    private static final String EMAIL = "userEmail";
    private static final String PHONE = "userPhone";

    public SharedPrefManager(Context context) {
        this.mContext = context;
        this.mSharedPreferences = mContext
                            .getSharedPreferences(SHARED_PREF_FILE, PRIVATE_MODE);
    }

    public void setFirstLaunch(boolean isFirstLaunch) {
        mSharedPreferences
                .edit()
                .putBoolean(IS_FIRST_LAUNCH, isFirstLaunch)
                .apply();
    }

    public boolean isFirstLaunch() {
        return mSharedPreferences.getBoolean(IS_FIRST_LAUNCH, true);
    }

    public void setUsername(String username) {
        storeStringInformation(USERNAME, username);
    }

    public String getUsername() {
        return mSharedPreferences.getString(USERNAME, NOT_FOUND);
    }

    public void setDateOfBirth(String dateOfBirth) {
        storeStringInformation(DATE_OF_BIRTH, dateOfBirth);
    }

    public String getDateOfBirth() {
        return mSharedPreferences.getString(DATE_OF_BIRTH, NOT_FOUND);
    }

    public void setEmail(String email) {
        storeStringInformation(EMAIL, email);
    }

    public String getEmail() {
        return mSharedPreferences.getString(EMAIL, NOT_FOUND);
    }

    public void setPhone(String phone) {
        storeStringInformation(PHONE, phone);
    }

    public String getPhone() {
        return mSharedPreferences.getString(PHONE, NOT_FOUND);
    }

    private void storeStringInformation(String KEY, String value) {
        mSharedPreferences
                .edit()
                .putString(KEY, value)
                .apply();
    }
}
