package net.wawczak.brian.ratethatrecordbrianw;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;


public class MainActivity extends AppCompatActivity {


    ImageButton btnClaptonPlay, btnAlterbridgePlay, btnNightwishPlay;
    Button btnVote;

    MediaPlayer oldLove, watchOverYou, ghostLoveScore;

    int selected;

    Spinner spClapton, spAlterbridge, spNightwish;

    int claptonScore;
    int alterbridgeScore;
    int nightwishScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnClaptonPlay = findViewById(R.id.btnClaptonPlay);
        btnAlterbridgePlay = findViewById(R.id.btnAlterbridgePlay);
        btnNightwishPlay = findViewById(R.id.btnNightwishPlay);
        btnVote = findViewById(R.id.btnVote);

        oldLove = new MediaPlayer();
        oldLove = MediaPlayer.create(this, R.raw.old_love);

        watchOverYou = new MediaPlayer();
        watchOverYou = MediaPlayer.create(this, R.raw.watch_over_you);

        ghostLoveScore = new MediaPlayer();
        ghostLoveScore = MediaPlayer.create(this, R.raw.ghost_love_score);

        spClapton = findViewById(R.id.spClapton);
        spAlterbridge = findViewById(R.id.spAlterbridge);
        spNightwish = findViewById(R.id.spNightwish);


        selected = 0;
        // case 0, play mp3, hide other buttons
        // case 1, pause mp3, show buttons
        btnClaptonPlay.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                switch (selected){
                    case 0:
                        oldLove.start();
                        selected = 1;
                        btnAlterbridgePlay.setVisibility(View.INVISIBLE);
                        btnNightwishPlay.setVisibility(View.INVISIBLE);
                        btnClaptonPlay.setImageResource(R.drawable.pause);
                        break;
                    case 1:
                        oldLove.pause();
                        selected = 0;
                        btnAlterbridgePlay.setVisibility(View.VISIBLE);
                        btnNightwishPlay.setVisibility(View.VISIBLE);
                        btnClaptonPlay.setImageResource(R.drawable.play);
                        break;
                }

            }
        });

        btnAlterbridgePlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (selected){
                    case 0:
                        watchOverYou.start();
                        selected = 1;
                        btnClaptonPlay.setVisibility(View.INVISIBLE);
                        btnNightwishPlay.setVisibility(View.INVISIBLE);
                        btnAlterbridgePlay.setImageResource(R.drawable.pause);
                        break;
                    case 1:
                        watchOverYou.pause();
                        selected = 0;
                        btnClaptonPlay.setVisibility(View.VISIBLE);
                        btnNightwishPlay.setVisibility(View.VISIBLE);
                        btnAlterbridgePlay.setImageResource(R.drawable.play);
                        break;
                }

            }
        });

        btnNightwishPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (selected){
                    case 0:
                        ghostLoveScore.start();
                        selected = 1;
                        btnAlterbridgePlay.setVisibility(View.INVISIBLE);
                        btnClaptonPlay.setVisibility(View.INVISIBLE);
                        btnNightwishPlay.setImageResource(R.drawable.pause);
                        break;
                    case 1:
                        ghostLoveScore.pause();
                        selected = 0;
                        btnAlterbridgePlay.setVisibility(View.VISIBLE);
                        btnClaptonPlay.setVisibility(View.VISIBLE);
                        btnNightwishPlay.setImageResource(R.drawable.play);
                        break;
                }

            }
        });

        btnVote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // get value from spinners and parse string to an int
                 //put values in an array and send with intent to Display.java
                claptonScore = Integer.parseInt(spClapton.getSelectedItem().toString());
                alterbridgeScore = Integer.parseInt(spAlterbridge.getSelectedItem().toString());
                nightwishScore = Integer.parseInt(spNightwish.getSelectedItem().toString());

                int[] scoreArray = {claptonScore, alterbridgeScore, nightwishScore};
                Intent intent = new Intent(MainActivity.this, Display.class);
                intent.putExtra("scoreArray", scoreArray);
                startActivity(intent);


            }
        });
    }
}
