package com.example.soubhagya.bloodapp.database;

import android.database.Cursor;
import android.database.CursorWrapper;

/**
 * Created by soubhagya on 9/6/17.
 */

public class UserProfileCursorWrapper extends CursorWrapper {

    public UserProfileCursorWrapper(Cursor cursor) {
        super(cursor);
    }
}
