package com.example.uasakbif_310119085;
//NIM : 10119085
//Nama : Arif Abdan Syakur
//Kelas : IF-3
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class IntroAct extends AppCompatActivity {

    private ViewPager screenPager;
    IntroAdapter introAdapter;
    Button selanjutnya;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        getSupportActionBar().hide();

        tabLayout = findViewById(R.id.tablayout);


        List<ScreenItem> list = new ArrayList<>();
        list.add(new ScreenItem("Selamat Datang!", "Selamat datang di aplikasi Daily Note","Swipe Untuk Selanjutnya ===>"));
        list.add(new ScreenItem("Apa Itu Daily Note?", "Daily Note adalah aplikasi yang menyimpan catatan harian atau catatan penting.","Swipe Untuk Selanjutnya ===>"));
        list.add(new ScreenItem("Aman Tidak?", "Sudah dipastikan aman karena data akan tersimpan rapih dan anda bisa melihatnya di lain waktu", "Silahkan Tekan Tombol Dibawah"));

        screenPager = findViewById(R.id.viewpager);
        introAdapter = new IntroAdapter(this, list);
        screenPager.setAdapter(introAdapter);

        tabLayout.setupWithViewPager(screenPager);

        selanjutnya = findViewById(R.id.selanjutnya);
        selanjutnya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntroAct.this, Login.class);
                startActivity(intent);
            }
        });

    }

}