package com.example.soubhagya.bloodapp.model;

/**
 * Created by soubhagya on 1/6/17.
 */

public class UserProfile {

    private String mUserId;
    private String mUsername;
    private String mDateOfBirth;
    private String mPhone;
    private String mEmail;

    public UserProfile(){}

    public UserProfile(String userId, String username,
                       String dateOfBirth, String phone, String email) {
        mUserId = userId;
        mUsername = username;
        mDateOfBirth = dateOfBirth;
        mPhone = phone;
        mEmail = email;
    }

    public String getUserId() {
        return mUserId;
    }

    public void setUserId(String userId) {
        mUserId = userId;
    }

    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String username) {
        mUsername = username;
    }

    public String getDateOfBirth() {
        return mDateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        mDateOfBirth = dateOfBirth;
    }

    public String getPhone() {
        return mPhone;
    }

    public void setPhone(String phone) {
        mPhone = phone;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }
}
