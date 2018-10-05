package com.example.manpreetparmar.assignment3again;


import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceHelper {


    private SharedPreferences sharedPreferences;
    public SharedPreferenceHelper(Context context)
    {
        sharedPreferences = context.getSharedPreferences("ProfilePreference", Context.MODE_PRIVATE );
    }

    public Profile getProfile(){

        Profile tProfile= new Profile(getProfileName(),getProfileAge(),getProfileStudentID());
        return tProfile;
    }


    public void saveProfile(Profile profile){

        saveProfileName(profile.getName());
        saveProfileAge(profile.getAge());
        saveProfileStudentID(profile.getID());

    }

    public void saveProfileName(String name)
    {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("profileName",name );
        editor.commit();
    }
    public String getProfileName()
    {
        return sharedPreferences.getString("profileName", null);
    }

    public void saveProfileAge(String age){

        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("profileAge",age);
        editor.commit();
    }
    public String getProfileAge()
    {
        return sharedPreferences.getString("profileAge", null);
    }


    public void saveProfileStudentID(String ID) {

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("profileStudentID", ID);
        editor.commit();
    }

    public String getProfileStudentID()
    {
        return sharedPreferences.getString("profileStudentID", null);
    }


}