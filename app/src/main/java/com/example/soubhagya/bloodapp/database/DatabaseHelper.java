package com.example.soubhagya.bloodapp.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.soubhagya.bloodapp.database.DbSchema.UserProfileTable;
import com.example.soubhagya.bloodapp.model.UserProfile;
import com.example.soubhagya.bloodapp.utils.DataStash;

import static com.facebook.FacebookSdk.getApplicationContext;

/**
 * Created by soubhagya on 9/6/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "userProfileBase.db";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + UserProfileTable.NAME + "(" +
                    " _id integer primary key autoincrement, " +
                    UserProfileTable.Columns.USER_ID + ", " +
                    UserProfileTable.Columns.USERNAME + ", " +
                    UserProfileTable.Columns.DATE_OF_BIRTH + ", " +
                    UserProfileTable.Columns.EMAIL + ", " +
                    UserProfileTable.Columns.PHONE +
                    ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + UserProfileTable.NAME);

        // Create tables again
        onCreate(db);
    }

}
