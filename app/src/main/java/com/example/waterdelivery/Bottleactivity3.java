package com.example.waterdelivery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

public class Bottleactivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottleactivity);

        //hidden navigation bar
        //getSupportActionBar().hide();

        //hidden status bar
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Textview for WATER DELIVERY APP
        TextView textView = findViewById(R.id.textwaterannimation);
        textView.animate().translationX(1300).setDuration(1500).setStartDelay(2500);

        // for moving to the main activity
        Thread thread = new Thread() {

            public void run() {
                try {
                    Thread.sleep(4000);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }

                finally {
                    Intent intent = new Intent(Bottleactivity3.this, WelcomeActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };

        thread.start();
    }
}