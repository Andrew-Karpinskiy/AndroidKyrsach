package com.example.kyrsach;

import android.app.Application;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import com.example.kyrsach.repository.AppRepository;

public class MainViewModel extends AndroidViewModel {

    private AppRepository repository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        repository = AppRepository.getInstance();
    }

    void getData(Context context) {
        repository.getDataFromApi(context);
    }
}
