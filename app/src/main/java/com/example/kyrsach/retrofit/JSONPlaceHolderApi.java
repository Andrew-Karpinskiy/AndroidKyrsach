package com.example.kyrsach.retrofit;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

//Интерфейс в котором указываем куда отправляем запрос и описываем в каком виде получаем ответ
public interface JSONPlaceHolderApi {
    @GET("exchange?json")
    Call<List<ApiResponse>> getPostWithID();
}