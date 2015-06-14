package com.example.alinapc.securitycam;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by AlinaPc on 12.06.2015.
 */
public class UserPhoneStore {

    public static final String SP_NAME = "userDetails";
    SharedPreferences userPhoneDatabase;

    public UserPhoneStore(Context context){
      userPhoneDatabase = context.getSharedPreferences(SP_NAME, 0);

    }

    public void storeUserData(User user){
        SharedPreferences.Editor spEditor = userPhoneDatabase.edit();
        spEditor.putString("fname", user.fname);
        spEditor.putString("surnname", user.surname);
        spEditor.putInt("age", user.age);
        spEditor.putString("username", user.username);
        spEditor.putString("password", user.pass);
        spEditor.putString("retype", user.retype);
        spEditor.commit();
    }

    public User getStoredUser(){
        String fname = userPhoneDatabase.getString("fname", "");
        String surname = userPhoneDatabase.getString("surname", "");
        int age = userPhoneDatabase.getInt("age", -1);
        String username = userPhoneDatabase.getString("username", "");
        String pass = userPhoneDatabase.getString("password", "");
        String retype = userPhoneDatabase.getString("retype", "");

        User storedUser = new User(fname,surname, age, username, pass, retype);
        return storedUser;

    }

    public void setLoggedInUser(boolean loggedIn){
        SharedPreferences.Editor spEditor = userPhoneDatabase.edit();
        spEditor.putBoolean("loggedIn", loggedIn);
        spEditor.commit();

    }

    public boolean getLoggedInUser(){
        if(userPhoneDatabase.getBoolean("loggedIn", false))
            return true;
        else
            return false;
    }

    public void clearData(){
        SharedPreferences.Editor spEditor = userPhoneDatabase.edit();
        spEditor.clear();
        spEditor.commit();
    }
}
