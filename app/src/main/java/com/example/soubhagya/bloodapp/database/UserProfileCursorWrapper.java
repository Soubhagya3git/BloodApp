package com.example.soubhagya.bloodapp.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.soubhagya.bloodapp.model.UserProfile;

import com.example.soubhagya.bloodapp.database.DbSchema.UserProfileTable;

/**
 * Created by soubhagya on 9/6/17.
 */

public class UserProfileCursorWrapper extends CursorWrapper {

    public UserProfileCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public UserProfile getUserProfile() {
        String userId = getString(getColumnIndex(UserProfileTable.Columns.USER_ID));
        String username = getString(getColumnIndex(UserProfileTable.Columns.USERNAME));
        String dateOfBirth = getString(getColumnIndex(UserProfileTable.Columns.DATE_OF_BIRTH));
        String email = getString(getColumnIndex(UserProfileTable.Columns.EMAIL));
        String phone = getString(getColumnIndex(UserProfileTable.Columns.PHONE));

        UserProfile userProfile = new UserProfile(userId, username, dateOfBirth, email, phone);
        return userProfile;
    }
}
