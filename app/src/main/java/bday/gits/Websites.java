package bday.gits;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Websites extends AppCompatActivity {

    LinearLayout gits;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_websites);
        gits=(LinearLayout)findViewById(R.id.bringfido);
        gits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.bringfido.com/"));
                    startActivity(intent);
            }
        });

        gits=(LinearLayout)findViewById(R.id.catworld);
        gits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://cat-world.com/"));
                    startActivity(intent);
            }
        });

        gits=(LinearLayout)findViewById(R.id.netflix);
        gits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.netflix.com/my-en/"));
                startActivity(intent);
            }
        });
    }

    MediaPlayer player;

    public void play(View v){
        if(player == null){
            player = MediaPlayer.create(this, R.raw.rolling_in_the_deep);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlayer();
                }
            });
        }

        player.start();
    }

    public void pause(View v){
        if(player != null){
            player.pause();
        }
    }

    public void stop(View v){
        stopPlayer();
    }

    private void stopPlayer(){
        if(player != null){
            player.release();
            player = null;
            Toast.makeText(this, "The Song Stopped!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopPlayer();
    }
}
