package com.example.soubhagya.bloodapp.utils;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.soubhagya.bloodapp.database.DatabaseHelper;
import com.example.soubhagya.bloodapp.database.DbSchema;
import com.example.soubhagya.bloodapp.database.UserProfileCursorWrapper;
import com.example.soubhagya.bloodapp.model.UserProfile;

import static com.facebook.FacebookSdk.getApplicationContext;

/**
 * Created by soubhagya on 9/6/17.
 */

public enum DataStash {

    INSTANCE;

    private SQLiteDatabase mDatabase = new DatabaseHelper(getApplicationContext())
                                        .getWritableDatabase();

    private DataStash() {

    }

    public SQLiteDatabase getDatabase() {
        return mDatabase;
    }

    public UserProfile getUserProfileFromDatabase(String userId) {

        UserProfileCursorWrapper cursorWrapper = queryUserProfiles(
                DbSchema.UserProfileTable.Columns.USER_ID + " = ?",
                new String[] {userId}
        );

        try {
            if (cursorWrapper.getCount() == 0) {
                return null;
            }

            cursorWrapper.moveToFirst();
            return cursorWrapper.getUserProfile();
        } finally {
            cursorWrapper.close();
        }
    }

    private UserProfileCursorWrapper queryUserProfiles(String whereClause, String[] whereArgs) {
        SQLiteDatabase database = DataStash.INSTANCE.getDatabase();
        Cursor cursor = database.query(
                DbSchema.UserProfileTable.NAME,
                null, //selects all columns
                whereClause,
                whereArgs,
                null, //groupBy
                null, //having
                null //orederBy
        );

        return new UserProfileCursorWrapper(cursor);
    }

}
