package com.pierrefervel.android.baladetontoutou.models;

/**
 * Created by Pierre FERVEL on 09/01/2018.
 */

public class User {
    private String mFirstName;

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    @Override
    public String toString() {
        return "User{" +
                "mFirstName='" + mFirstName + '\'' +
                '}';
    }
}
