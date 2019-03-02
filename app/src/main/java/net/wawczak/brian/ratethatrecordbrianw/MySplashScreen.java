package net.wawczak.brian.ratethatrecordbrianw;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class MySplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_splash_screen_activity);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                finish();

                startActivity(new Intent(MySplashScreen.this, MainActivity.class));
            }
        };

        Timer start = new Timer();
        start.schedule(task, 4200);
    }
}
