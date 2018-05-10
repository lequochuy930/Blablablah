package vn.khoapham.manager;


import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.ActivityCompat;

import android.content.pm.PackageManager;
import android.Manifest;
import android.os.Bundle;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MySMSActivity extends AppCompatActivity {

    TextView mobileno, message;
    Button sendsms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_sms);

        mobileno = (TextView) findViewById(R.id.textPhone);
        message = (EditText) findViewById(R.id.editSMS);
        sendsms = (Button) findViewById(R.id.btnSendSms);

        //Performing action on button click
        sendsms.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                String no = mobileno.getText().toString();
                String msg = message.getText().toString();

                //Getting intent and PendingIntent instance
                Intent intent = new Intent(getApplicationContext(), MySMSActivity.class);
                PendingIntent pi = PendingIntent.getActivity(getApplicationContext(), 0, intent, 0);

                //Get the SmsManager instance and call the sendTextMessage method to send message
                SmsManager sms = SmsManager.getDefault();
                sms.sendTextMessage(no, null, msg, pi, null);

                Toast.makeText(getApplicationContext(), "Message Sent successfully!",
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}


