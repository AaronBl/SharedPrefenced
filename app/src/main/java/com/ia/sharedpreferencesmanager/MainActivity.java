package com.ia.sharedpreferencesmanager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editTextName = this.findViewById(R.id.edit_text_name);
       // String name = sharedPreferences.getString("name","");

        final EditText editTextLastName = this.findViewById(R.id.edit_text_last_name);
       // String lastName = sharedPreferences.getString("lastName","");
        final EditText editTextEmail = this.findViewById(R.id.edit_text_email);
        //String email = sharedPreferences.getString("email","");
        final EditText editTextAge = this.findViewById(R.id.edit_text_age);
       // int ageValue = sharedPreferences.getInt("ageValue",0);
        final Button buttonSave = this.findViewById(R.id.button_save);
        final TextView textViewWelcomeMessage = this.findViewById(R.id.text_view_welcome);

        CheckBox cbRecorda = findViewById(R.id.cbrecordar);

        boolean recordarr =  SharpreferencesManager.isUserRecordar(MainActivity.this);
        cbRecorda.setChecked(recordarr);

         cbRecorda.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                  SharpreferencesManager.isUserRecordar(MainActivity.this,isChecked);

             }
         });


         if(SharpreferencesManager.isUserRecordar(MainActivity.this)){
             User user = SharpreferencesManager.getUserData(this);
             editTextName.setText(user.getName());
         }



       boolean isDataSave = SharpreferencesManager.isUserDataSave(this);
            if(isDataSave){
                Intent intent = new Intent(MainActivity.this,ShowDataActivity.class);
                startActivity(intent);
                finish();
            }




        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = editTextName.getText().toString().trim();
                String lastName = editTextLastName.getText().toString().trim();
                String email = editTextEmail.getText().toString().trim();
                String Age = editTextAge.getText().toString().trim();
                int a = Integer.valueOf(Age);
                User user = new User(name,lastName,email,a);

                SharpreferencesManager.saveUserData(getApplicationContext(),user);

                Intent intent = new Intent(MainActivity.this,ShowDataActivity.class);
                startActivity(intent);
                finish();

            }
        });





        /* User user = SharpreferencesManager.getUserData(getApplicationContext());
        editTextName.setText(user.getName());
        editTextLastName.setText(user.getLastName());
        editTextEmail.setText(user.getEmail());
        editTextAge.setText(String.valueOf(user.getAge()));*/
    }
}
