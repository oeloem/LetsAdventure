package com.example.oeloem.letsadventure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

public class SplashScreenActivity extends AppCompatActivity {

    private long ms = 0;
    private long splashTime = 3000;
    private boolean splashActive = true;
    private boolean pause = false;


    @Override
    protected void onCreate(Bundle savedInstantState) {
        super.onCreate(savedInstantState);
        setContentView(R.layout.activity_splash_screen);

        final ProgressBar progressBar = findViewById(R.id.progress_bar);

        Thread myThread = new Thread() {
            public void run() {
                try{
                    while (splashActive && ms <splashTime) {
                        if (!pause) {
                            ms = ms + 10;
                            sleep(10);
                            progressBar.setProgress((int)ms);
                        }
                    }
                } catch (Exception e) {

                } finally {

                    Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
    }
}
