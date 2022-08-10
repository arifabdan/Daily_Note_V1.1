package com.example.uasakbif_310119085;
//NIM : 10119085
//Nama : Arif Abdan Syakur
//Kelas : IF-3
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class Edit extends AppCompatActivity {

    EditText date, judul, kategori, isi;
    Button btn_edt, btn_hapus;
    String id, date2, judul2, kategori2, isi2;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.mocha)));
        getSupportActionBar().setTitle("Edit");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_edit);

        date = findViewById(R.id.tanggal2);
        date.setFocusable(false);
        judul = findViewById(R.id.judul2);
        kategori = findViewById(R.id.kategori2);
        isi = findViewById(R.id.isi2);
        btn_edt = findViewById(R.id.btn_edt);
        btn_hapus = findViewById(R.id.btn_hapus);
        recyclerView = findViewById(R.id.recycleView);

        getAndSetIntentData();

        btn_edt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                com.example.uasakbif_310119085.MyDatabaseHelper mydb = new com.example.uasakbif_310119085.MyDatabaseHelper(Edit.this);
                date2 = date.getText().toString().trim();
                judul2 = judul.getText().toString().trim();
                kategori2 = kategori.getText().toString().trim();
                isi2 = isi.getText().toString().trim();
                mydb.editdata(id, date2, judul2, kategori2, isi2);
                Toast.makeText(Edit.this, "Berhasil Diedit", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Edit.this, home.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        btn_hapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                com.example.uasakbif_310119085.MyDatabaseHelper mydb = new com.example.uasakbif_310119085.MyDatabaseHelper(Edit.this);
                mydb.deleteOneRow(id);
                Toast.makeText(Edit.this, "Berhasil Dihapus", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Edit.this, home.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            }
        });


    }
    public  boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                this.finish();
                return true;
        }
        return  super.onOptionsItemSelected(item);
    }
    void getAndSetIntentData(){
       if (getIntent().hasExtra("id") && getIntent().hasExtra("date") &&
       getIntent().hasExtra("judul") && getIntent().hasExtra("kategori") &&
       getIntent().hasExtra("isi")){
           //Get data intent
           id = getIntent().getStringExtra("id");
           date2 = getIntent().getStringExtra("date");
           judul2 = getIntent().getStringExtra("judul");
           kategori2 = getIntent().getStringExtra("kategori");
           isi2 = getIntent().getStringExtra("isi");

           //Set Data intent
           date.setText(date2);
           judul.setText(judul2);
           kategori.setText(kategori2);
           isi.setText(isi2);
       }else {
           Toast.makeText(this, "No Data" , Toast.LENGTH_SHORT).show();
       }
    }

}