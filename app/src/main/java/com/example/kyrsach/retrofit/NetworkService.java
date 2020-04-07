package com.example.kyrsach.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//Класс для настройки Retrofit и отправки запроса на получение данных от Api
public class NetworkService {
        private static NetworkService mInstance;
        private static final String BASE_URL = "https://bank.gov.ua/NBUStatService/v1/statdirectory/";
        private Retrofit mRetrofit;

        private NetworkService() {
                mRetrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
        }

        public static NetworkService getInstance() {
                if (mInstance == null) {
                        mInstance = new NetworkService();
                }
                return mInstance;
        }

        public JSONPlaceHolderApi getJSONApi() {
                return mRetrofit.create(JSONPlaceHolderApi.class);
        }
}