package net.wawczak.brian.ratethatrecordbrianw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import static net.wawczak.brian.ratethatrecordbrianw.R.layout.activity_display;

public class Display extends AppCompatActivity {

    TextView txtResult;

    ImageView winnerImg;

    int[] winners;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_display);



            winnerImg = findViewById(R.id.winner_image);
            txtResult = findViewById(R.id.txtResult);


            // get array of spinner values from MainActivity
            Bundle winnerArray = getIntent().getExtras();
            assert winnerArray != null;
            winners = winnerArray.getIntArray("scoreArray");



            // determine which song ranked the highest
            // change the TextView and ImageView to reflect the winner.
            assert winners != null;
            if (winners[0] > winners[1] && winners[0] > winners[2]) {
                txtResult.setText(R.string.claptonChoice);
                winnerImg.setImageResource(R.drawable.clapton);

            }else if (winners[1] > winners[0] && winners[1] > winners[2]) {
                txtResult.setText(R.string.alterbridgeChoice);
                winnerImg.setImageResource(R.drawable.alterbridge);
            }else if (winners[2] > winners[1] && winners[2] > winners[0]) {
                txtResult.setText(R.string.nightwishChoice);
                winnerImg.setImageResource(R.drawable.night_wish);
            }else{
                txtResult.setText(R.string.tie);
            }
        }
    }
