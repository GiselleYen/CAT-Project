package bday.gits;

import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.annotation.DrawableRes;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.Toast;

public class BitwaWish extends AppCompatActivity {

    MediaPlayer player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitwa_wish);
    }

    public void play(View v) {
        if(player == null){
            player = MediaPlayer.create(this, R.raw.hbdaymusic);
        }
        player.start();
    }
    private void stopPlayer(){
        if (player!=null){
            player.release();
            player=null;
            Toast.makeText(this, "Music Stopped!", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onStop(){
        super.onStop();
        stopPlayer();
    }
}
