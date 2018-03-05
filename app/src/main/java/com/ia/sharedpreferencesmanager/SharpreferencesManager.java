package com.ia.sharedpreferencesmanager;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by abautista on 3/5/2018.
 */

public class SharpreferencesManager {


    public static final String GLOBAL_PREFERENCES = "GLOBAL_PREFERENCES";
    private static SharedPreferences sharedPreferences;
    private SharpreferencesManager() {
    }

    private static String getPreferencesKEy (Context contex,String key){
        return  String.format("%s.%s",contex.getPackageName(),key);
    }

    private static SharedPreferences getSharedPreferences(Context context){
        if(sharedPreferences == null ){

            sharedPreferences = context.getSharedPreferences(getPreferencesKEy(context,GLOBAL_PREFERENCES),Context.MODE_PRIVATE);

        }
        return  sharedPreferences;
    }


    static User getUserData( Context context){
        SharedPreferences sharedPreferences = getSharedPreferences(context);


        String name = sharedPreferences.getString("name","");
        String lastName = sharedPreferences.getString("lastName","");
        String email = sharedPreferences.getString("email","");
        int ageValue = sharedPreferences.getInt("ageValue",0);
        return new User(name,lastName,email,ageValue);



    }

    static void saveUserData (Context context, User user){
        SharedPreferences sharedPreferences = getSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name",user.getName());
        editor.putString("lastName",user.getLastName());
        editor.putString("email",user.getEmail());
        editor.putInt("ageValue",user.getAge());
        editor.putBoolean("is_user_data_save",true);
        editor.apply();
    }

    static boolean isUserDataSave(Context context){
        SharedPreferences  sharpreferences = getSharedPreferences(context);
        return sharpreferences.getBoolean("is_user_data_save",false);
    }


    static boolean isUserRecordar(Context context){
        SharedPreferences  sharpreferences = getSharedPreferences(context);
        return sharpreferences.getBoolean("IS_user_remmeber",false);
    }


    static void isUserRecordar(Context context, boolean isActive){
        SharedPreferences  sharpreferences = getSharedPreferences(context);
        SharedPreferences.Editor editor = sharpreferences.edit();
        editor.putBoolean("IS_user_remmeber",isActive);
        editor.apply();
    }

    static void ClearUSer(Context context){

        SharedPreferences sharedPreferences = getSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();



        if(sharedPreferences.getBoolean("IS_user_remmeber",false)){

            String name = sharedPreferences.getString("name","");
            String lastName = sharedPreferences.getString("lastName","");
            String email = sharedPreferences.getString("email","");
            int ageValue = sharedPreferences.getInt("ageValue",0);
            editor.putBoolean("IS_user_remmeber",true);

        }else{
            editor.clear();

        }
        editor.putBoolean("is_user_data_save",false);

        editor.apply();


  }

}
