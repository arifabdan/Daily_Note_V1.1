package com.example.uasakbif_310119085;
//NIM : 10119085
//Nama : Arif Abdan Syakur
//Kelas : IF-3
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Handler h = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(MainActivity.this, IntroAct.class);
                startActivity(i);
                finish();
            }
        },5000);

    }
}