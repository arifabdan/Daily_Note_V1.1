package com.example.uasakbif_310119085.ui.List;
//NIM : 10119085
//Nama : Arif Abdan Syakur
//Kelas : IF-3
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uasakbif_310119085.CustomAdapter;
import com.example.uasakbif_310119085.MyDatabaseHelper;
import com.example.uasakbif_310119085.R;
import com.example.uasakbif_310119085.Tambah;
import com.example.uasakbif_310119085.databinding.FragmentListBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ListFragment extends Fragment {

    private FragmentListBinding binding;
    FloatingActionButton tambah;
    RecyclerView recyclerView;
    MyDatabaseHelper mydb;
    ArrayList<String> id, date, judul, kategori, isi;
    CustomAdapter customAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ListViewModel listViewModel =
                new ViewModelProvider(this).get(ListViewModel.class);

        binding = FragmentListBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        recyclerView = (RecyclerView)root.findViewById(R.id.recycleView);
        tambah = (FloatingActionButton) root.findViewById(R.id.tambah);
        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Tambah.class);
                startActivity(intent);
            }
        });
        mydb = new MyDatabaseHelper(getActivity());
        id = new ArrayList<>();
        date = new ArrayList<>();
        judul = new ArrayList<>();
        kategori = new ArrayList<>();
        isi = new ArrayList<>();

        tampilData();

        customAdapter = new CustomAdapter(getActivity(), id, date, judul, kategori, isi);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return root;


    }



    void tampilData(){
        Cursor cursor = mydb.readData();
        while (cursor.moveToNext()){
            id.add(cursor.getString(0));
            date.add(cursor.getString(1));
            judul.add(cursor.getString(2));
            kategori.add(cursor.getString(3));
            isi.add(cursor.getString(4));

        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}