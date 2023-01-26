package bday.gits;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Call_me extends AppCompatActivity {

    LinearLayout call,msg,mail,whatsapp,insta,facebook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_me);
        call=(LinearLayout)findViewById(R.id.call);
        msg=(LinearLayout)findViewById(R.id.msg);
        mail=(LinearLayout)findViewById(R.id.mail);
        whatsapp=(LinearLayout)findViewById(R.id.whatsapp);
        insta=(LinearLayout)findViewById(R.id.insta);
        facebook=(LinearLayout)findViewById(R.id.facebook);

        // call phone
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jadu(); // call method named jadu()
            }
        });

        // message
        msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Call_me.this,SendMessage.class));
            }
        });

        // email function
        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] TO = {"a.081005@gmail.com"};
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.setType("text/plain");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "");
                startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            }
        });

        // whatsapp
        whatsapp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.whatsapp.com/"));
                startActivity(intent);
            }
        });

        // instagram
        insta.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.instagram.com/"));
                startActivity(intent);
            }
        });

        // facebook
        facebook.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.facebook.com/"));
                startActivity(intent);
            }
        });
    }

    // jadu method
    public void jadu()
    {
        final CharSequence options[] = new CharSequence[] {"Contact 1: 01123456789", "Contact 2: 0123456789"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setTitle("Select your option:");
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if("7987785055".equals(options[which]))
                {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:7987785055"));
                    startActivity(intent);
                }
                else if("9589497123".equals(options[which]))
                {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:9589497123"));
                    startActivity(intent);
                }
            }

        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //the user clicked on Cancel
            }
        });
        builder.show();
    }

}

