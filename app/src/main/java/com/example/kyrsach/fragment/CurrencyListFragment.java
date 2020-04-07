package com.example.kyrsach.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.kyrsach.R;
import com.example.kyrsach.adapter.RecyclerViewAdapter;
import com.example.kyrsach.retrofit.ApiResponse;
import com.example.kyrsach.retrofit.NetworkService;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CurrencyListFragment extends Fragment {

    private List<ApiResponse> data;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private View view;

    public CurrencyListFragment() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_currencylist, container, false);
        //Настройки recyclerView: создаем адаптер и менеджер и устанавливаем их
        recyclerView = view.findViewById(R.id.recyclerView);
        data = new ArrayList<>();
        recyclerViewAdapter = new RecyclerViewAdapter(data,getContext());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerViewAdapter);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        makeApiCall();
    }

    //Метод для создания Retrofit запроса к Api
    private void makeApiCall() {
        NetworkService.getInstance()
                .getJSONApi()
                .getPostWithID()
                .enqueue(new Callback<List<ApiResponse>>() {
                    //В случае удачного запроса
                    @Override
                    public void onResponse(Call<List<ApiResponse>> call, Response<List<ApiResponse>> response) {
                        //Передаем полученные данные в список
                        data = response.body();
                        //Обновляем данные в адаптере
                        recyclerViewAdapter.updateCurrencyList(data);
                    }
                    //В случае неудачи
                    @Override
                    public void onFailure(Call<List<ApiResponse>> call, Throwable t) {
                        Toast.makeText(getContext(), "Помилка при отриманні даних. Спробуйте ще раз!", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
