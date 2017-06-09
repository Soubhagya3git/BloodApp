package com.example.soubhagya.bloodapp.database;

/**
 * Created by soubhagya on 9/6/17.
 */

public class DbSchema {
    public static final class UserProfileTable {
        public static final String NAME = "userProfile";

        public static final class Columns {
            public static final String USER_ID = "userId";
            public static final String USERNAME = "username";
            public static final String DATE_OF_BIRTH = "dateOfBirth";
            public static final String EMAIL = "email";
            public static final String PHONE = "phone";
        }
    }
}
