package com.example.kyrsach.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.kyrsach.retrofit.ApiResponse;
import com.example.kyrsach.R;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.CurrencyViewHolder>{

    //Здесь хранятся объекты с информацией о валютах
    private  List<ApiResponse> data;
    //Для открытия нового окна по нажатию кнопки
    private Context context;

    public RecyclerViewAdapter(List<ApiResponse> data, Context context) {
        this.data = data;
        this.context = context;
    }

    //Передаем новые данные и уведомляем адаптер о том что данные были изменены
    public void updateCurrencyList(List<ApiResponse> movieList) {
        this.data = movieList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CurrencyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //Дерево элементов
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cardview_currency, viewGroup, false);
        return new CurrencyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CurrencyViewHolder currencyViewHolder, int i) {
        //Заполнение элементов view данными из списка обьектов
        currencyViewHolder.currencyName.setText(data.get(i).getCurrencyName());
        currencyViewHolder.currencyPrice.setText(""+data.get(i).getCurrencyPrice());
        currencyViewHolder.currencySymbol.setText(data.get(i).getCurrencySymbol());
    }

    //Размер списка
    @Override
    public int getItemCount() {
        return data.size();
    }

    static class CurrencyViewHolder extends RecyclerView.ViewHolder {
        TextView currencyName;
        TextView currencyPrice;
        TextView currencySymbol;
        CurrencyViewHolder(@NonNull View itemView) {
            super(itemView);
            currencyName = itemView.findViewById(R.id.currencyName);
            currencyPrice= itemView.findViewById(R.id.currencyPrice);
            currencySymbol = itemView.findViewById(R.id.currencySymbol);
        }
    }
}
