package com.example.simplesmssender;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button send;
    EditText phnNumber, sms;

//    private final String SENT = "SMS_SENT";
//    private final String DELIVERED = "SMS_DELIVERED";
//    PendingIntent sentPI, deliveredPI;
//    BroadcastReceiver smsSentReceiver, smsDeliveredReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        send = findViewById(R.id.btnSend);
        phnNumber = findViewById(R.id.editText_phone);
        sms = findViewById(R.id.editText_sms);
    }

    public void SendSms(View view) {
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},
                    0);
        }
        else {
            String message = sms.getText().toString();
            String number = phnNumber.getText().toString();
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(number, null, message, null, null);
        }

    }
}
