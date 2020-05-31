package com.example.kyrsach.repository;

import android.content.Context;
import com.example.kyrsach.repository.data.DataStorage;
import com.example.kyrsach.repository.retrofit.ApiResponse;
import com.example.kyrsach.repository.retrofit.RetrofitController;
import java.util.List;

//Класс репозиторий который работает с Retrofit и DataStorage
public class AppRepository {

    private static AppRepository instance;
    private RetrofitController retrofit;
    private DataStorage dataStorage;

    public static AppRepository getInstance() {
        if (instance == null) {
            instance = new AppRepository();
        }
        return instance;
    }

    private AppRepository() {
        retrofit = new RetrofitController();
        dataStorage = new DataStorage();
    }

    public void getDataFromApi(Context context) {
        for(int i = 0; i < 2; i++) {
            if(!dataStorage.getIsData())
                retrofit.getData(context);
        }
    }

    public List<ApiResponse> getList() {
        return dataStorage.getList();
    }

    public void setList(List<ApiResponse> list) {
        dataStorage.setList(list);
    }

    public  boolean getIsData() {
        return dataStorage.getIsData();
    }

    public void setIsData(boolean isData) {
       dataStorage.setIsData(isData);
    }

    public  ApiResponse getCurrencyByName(String name) {
        return dataStorage.getCurrencyBySymbol(name);
    }
}
