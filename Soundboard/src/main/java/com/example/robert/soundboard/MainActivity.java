package com.example.robert.soundboard;

import android.media.Image;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    MediaPlayer orangeSound;
    MediaPlayer wPolsceSound;
    MediaPlayer medicTwoSound;
    MediaPlayer medicOneSound;
    RelativeLayout relativeLayout;
    Button b1;
    Button b2;
    Button b3;
    Button b4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button2);
        b3=(Button)findViewById(R.id.button3);
        b4=(Button)findViewById(R.id.button4);
        relativeLayout=(RelativeLayout)findViewById(R.id.relative);
        medicOneSound = MediaPlayer.create(this,R.raw.wet_need_medic1);
        medicTwoSound = MediaPlayer.create(this,R.raw.wet_need_medic2);
        wPolsceSound = MediaPlayer.create(this,R.raw.testo_w_polsce);
        orangeSound = MediaPlayer.create(this,R.raw.orange)
    }

    public void orangeClick(View view){
        orangeSound.start();
        relativeLayout.setBackgroundResource(R.drawable.orange_background);
    }
    public void wPolsceClick(View view){
        wPolsceSound.start();
        relativeLayout.setBackgroundResource(R.drawable.testo_background);
    }
    public void medicTwoClick(View view){
        medicTwoSound.start();
        relativeLayout.setBackgroundResource(R.drawable.wolfenstein_background);
    }
    public void medicOneClick(View view) {
        medicOneSound.start();
        relativeLayout.setBackgroundResource(R.drawable.background);
    }
}
