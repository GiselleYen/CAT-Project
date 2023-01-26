package bday.gits;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.widget.EditText;
import android.view.View;


public class SendMessage extends AppCompatActivity {

    private EditText editTextNumber;
    private EditText editTextTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);

        ActivityCompat.requestPermissions(SendMessage.this, new String[]{Manifest.permission.SEND_SMS, Manifest.permission.READ_SMS}, PackageManager.PERMISSION_GRANTED);
        editTextTextMessage = findViewById(R.id.editTextTextMessage);
        editTextNumber = findViewById(R.id.editTextNumber);
    }
    public void sendSMS (View view){
        String message = editTextTextMessage.getText().toString();
        String number = editTextNumber.getText().toString();

        SmsManager mySmsManager = SmsManager.getDefault();
        mySmsManager.sendTextMessage(number, null, message, null, null);
    }
}


