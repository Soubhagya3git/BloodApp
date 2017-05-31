package com.example.soubhagya.bloodapp.firstTimeDetails;

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
    private static final String IS_FIRST_LAUNCH = "bloodApp.isFirstLaunch";

    public SharedPrefManager(Context context) {
        this.mContext = context;
        mSharedPreferences = mContext
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
}
