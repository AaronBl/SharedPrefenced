package com.ia.sharedpreferencesmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ShowDataActivity extends AppCompatActivity {
    TextView tvName,tvLastName,tvEmail,tvAge;
    Button btnLimpiar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);

        tvName = findViewById(R.id.tvName);
        tvLastName = findViewById(R.id.lastName);
        tvEmail = findViewById(R.id.tvEmail);
        tvAge = findViewById(R.id.tvAge);
        btnLimpiar = findViewById(R.id.tvLimpiar);


        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              SharpreferencesManager.ClearUSer(ShowDataActivity.this);

                Intent intent = new Intent(ShowDataActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

       User user = SharpreferencesManager.getUserData(ShowDataActivity.this);
        tvName.setText(user.getName());
        tvLastName.setText(user.getLastName());
        tvEmail.setText(user.getEmail());
        tvAge.setText(String.valueOf(user.getAge()));

    }
}
