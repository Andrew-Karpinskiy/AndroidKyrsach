package com.example.kyrsach.repository.data;

import com.example.kyrsach.repository.retrofit.ApiResponse;
import java.util.ArrayList;
import java.util.List;

//Класс в котором хранятся полученные от Api данные
public class DataStorage {
    private List<ApiResponse> list = new ArrayList<>();
    //Переменная флаг для проверки были ли получены данные
    private boolean isData;

    public List<ApiResponse> getList() {
        return list;
    }

    public void setList(List<ApiResponse> list) {
        this.list = list;
    }

    public  boolean getIsData() {
        return isData;
    }

    public  void setIsData(boolean isData) {
        this.isData = isData;
    }

    //Метод для нахождения в списке валюты по ее символу
    public  ApiResponse getCurrencyBySymbol(String string) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getCurrencySymbol().equals(string)) {
                  return list.get(i);
            }
        }
        return null;
    }
}
