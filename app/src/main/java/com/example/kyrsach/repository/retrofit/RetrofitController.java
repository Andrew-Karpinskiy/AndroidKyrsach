package com.example.kyrsach.repository.retrofit;

import android.content.Context;
import android.widget.Toast;
import com.example.kyrsach.MainActivity;
import com.example.kyrsach.R;
import com.example.kyrsach.repository.AppRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//Класс для настройки Retrofit и отправки запроса на получение данных от Api
public class RetrofitController {

        private static final String BASE_URL = "https://bank.gov.ua/NBUStatService/v1/statdirectory/";
        private RetrofitClient client;

        //Настройка Retrofit
        private Retrofit buildRetrofit() {
                Gson gson = new GsonBuilder().serializeNulls().create();
                return new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .build();
        }

        public RetrofitController() {
                client = buildRetrofit().create(RetrofitClient.class);
        }

        //Отправка запроса к Api
        public void getData(Context context) {
                Call<List<ApiResponse>> c = client.getPostWithID();
                c.enqueue(new Callback<List<ApiResponse>>() {
                        @Override
                        public void onResponse(Call<List<ApiResponse>> call, Response<List<ApiResponse>> response) {
                                //Если запрос усешен заполняем список в DataStorage,обновляем флаг и данные в RecyclerView
                                AppRepository.getInstance().setIsData(true);
                                AppRepository.getInstance().setList(response.body());
                                MainActivity.recyclerViewAdapter.updateCurrencyList(response.body());
                        }
                        @Override
                        public void onFailure(Call<List<ApiResponse>> call, Throwable t) {
                                //Если запрос провалился выводим тост на экран
                                AppRepository.getInstance().setIsData(false);
                                Toast.makeText(context, R.string.retrofit_message, Toast.LENGTH_SHORT).show();
                        }
                });
        }
}