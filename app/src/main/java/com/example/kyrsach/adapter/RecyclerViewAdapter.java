package com.example.kyrsach.adapter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.kyrsach.ConverterActivity;
import com.example.kyrsach.R;
import com.example.kyrsach.repository.retrofit.ApiResponse;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.CurrencyViewHolder>{

    //Здесь хранятся объекты с информацией о валютах
    private  List<ApiResponse> data;

    public RecyclerViewAdapter(List<ApiResponse> data) {
        this.data = data;
    }

    //Передаем новые данные и уведомляем адаптер о том что данные были изменены
    public void updateCurrencyList(List<ApiResponse> list) {
        this.data = list;
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

    @SuppressLint("DefaultLocale")
    @Override
    public void onBindViewHolder(@NonNull CurrencyViewHolder currencyViewHolder, int i) {
        //Заполнение элементов view данными из списка обьектов
        currencyViewHolder.currencyName.setText(data.get(i).getCurrencyName());
        currencyViewHolder.currencyPrice.setText(String.format("%.3f", data.get(i).getCurrencyPrice()));
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
        CardView cardView;
        CurrencyViewHolder(@NonNull View itemView) {
            super(itemView);
            currencyName = itemView.findViewById(R.id.currencyName);
            currencyPrice= itemView.findViewById(R.id.currencyPrice);
            currencySymbol = itemView.findViewById(R.id.currencySymbol);
            cardView = itemView.findViewById(R.id.cardView);
            // По нажатию на элемент списка откроеться активити с конвертером
            cardView.setOnClickListener((View v) -> {
                Intent intent = new Intent(itemView.getContext(), ConverterActivity.class);
                intent.putExtra("symbol",currencySymbol.getText());
                itemView.getContext().startActivity(intent);
            });
        }
    }
}
