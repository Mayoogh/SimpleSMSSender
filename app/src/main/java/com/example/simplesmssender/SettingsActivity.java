package com.example.simplesmssender;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {

    EditText phoneNumber, SmsA, SmsB;
    Button save;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        phoneNumber = findViewById(R.id.editTextPhone);
        SmsA = findViewById(R.id.editTextSMS1);
        SmsB = findViewById(R.id.editTextSMS2);
        save = findViewById(R.id.btnSave);
    }

    public void save(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("myData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("message1",SmsA.getText().toString());
        editor.putString("message2",SmsB.getText().toString());
        editor.putString("PhnNmbr",phoneNumber.getText().toString());
        editor.commit();
//        editor.apply();
        Toast.makeText(this,"Data Saved",Toast.LENGTH_SHORT).show();
    }
}
