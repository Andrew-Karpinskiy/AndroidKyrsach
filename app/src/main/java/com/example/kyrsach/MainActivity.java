package com.example.kyrsach;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;
import com.example.kyrsach.adapter.RecyclerViewAdapter;
import com.example.kyrsach.repository.retrofit.ApiResponse;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {

    @SuppressLint("StaticFieldLeak")
    public static RecyclerViewAdapter recyclerViewAdapter;
    private long backPressedTime;
    private Toast backToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViewModel();
        initRecyclerView();
    }

    //Настройка RecyclerView
    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        List<ApiResponse> data = new ArrayList<>();
        recyclerViewAdapter = new RecyclerViewAdapter(data);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    //Инициализация ViewModel для данной активности
    private void initViewModel() {
        MainViewModel mViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(MainViewModel.class);
        mViewModel.getData(this);
    }

    //Если нажать один раз на кнопку назад, будет выведен тост, если 2 то приложение закроеться
    @Override
    public void onBackPressed() {
        if(backPressedTime + 2000 > System.currentTimeMillis()) {
            backToast.cancel();
            super.onBackPressed();
            return;
        } else {
            backToast = Toast.makeText(getBaseContext(),R.string.exit,Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }
}