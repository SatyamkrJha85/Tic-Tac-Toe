package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

public class Splash extends AppCompatActivity {
    View animationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        animationView=findViewById(R.id.animationView);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
             startActivity(new Intent(Splash.this,AddPlayers.class));
                finish();
            }
        }, 4000);
    }
}