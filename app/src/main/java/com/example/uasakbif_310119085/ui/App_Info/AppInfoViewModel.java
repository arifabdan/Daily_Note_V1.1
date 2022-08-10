package com.example.uasakbif_310119085.ui.App_Info;
//NIM : 10119085
//Nama : Arif Abdan Syakur
//Kelas : IF-3
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AppInfoViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public AppInfoViewModel() {
        mText = new MutableLiveData<>();
    }

    public LiveData<String> getText() {
        return mText;
    }
}