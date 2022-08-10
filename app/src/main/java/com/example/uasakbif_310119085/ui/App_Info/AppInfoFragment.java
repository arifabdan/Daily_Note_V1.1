
package com.example.uasakbif_310119085.ui.App_Info;
//NIM : 10119085
//Nama : Arif Abdan Syakur
//Kelas : IF-3
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.uasakbif_310119085.databinding.FragmentAppInfoBinding;

public class AppInfoFragment extends Fragment {

    private FragmentAppInfoBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        AppInfoViewModel appInfoViewModel =
                new ViewModelProvider(this).get(AppInfoViewModel.class);

        binding = FragmentAppInfoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}