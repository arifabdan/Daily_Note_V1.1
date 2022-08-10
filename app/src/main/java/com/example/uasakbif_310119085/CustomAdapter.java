package com.example.uasakbif_310119085;
//NIM : 10119085
//Nama : Arif Abdan Syakur
//Kelas : IF-3
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>{

    public Context context;
    public ArrayList id, date, judul, kategori, isi;

   public CustomAdapter(Context context,
                         ArrayList id,
                         ArrayList date,
                         ArrayList judul,
                         ArrayList kategori,
                         ArrayList isi){
        this.context = context;
        this.id = id;
        this.date = date;
        this.judul = judul;
        this.kategori = kategori;
        this.isi = isi;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return  new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.ctt_id.setText(String.valueOf(id.get(position)));
        holder.ctt_tanggal.setText(String.valueOf(date.get(position)));
        holder.ctt_judul.setText(String.valueOf(judul.get(position)));
        holder.ctt_kategori.setText(String.valueOf(kategori.get(position)));
        holder.ctt_isi.setText(String.valueOf(isi.get(position)));
        holder.btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent edit = new Intent(context, Edit.class);
                edit.putExtra("id", String.valueOf(id.get(position)));
                edit.putExtra("date", String.valueOf(date.get(position)));
                edit.putExtra("judul", String.valueOf(judul.get(position)));
                edit.putExtra("kategori", String.valueOf(kategori.get(position)));
                edit.putExtra("isi", String.valueOf(isi.get(position)));
                context.startActivity(edit);
            }
        });


    }

    @Override
    public int getItemCount() {
        return id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView  ctt_id, ctt_tanggal, ctt_judul, ctt_kategori, ctt_isi;
        LinearLayout my_row;
        Button btn_edit, btn_hapus;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ctt_id = itemView.findViewById(R.id.ctt_id);
            ctt_tanggal = itemView.findViewById(R.id.ctt_tanggal);
            ctt_judul = itemView.findViewById(R.id.ctt_judul);
            ctt_kategori = itemView.findViewById(R.id.ctt_kategori);
            ctt_isi = itemView.findViewById(R.id.ctt_isi);
            my_row = itemView.findViewById(R.id.my_row);
            btn_edit = itemView.findViewById(R.id.btn_edit);

        }
    }
}
