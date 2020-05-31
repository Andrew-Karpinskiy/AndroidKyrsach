package com.example.kyrsach;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ConverterActivity extends AppCompatActivity {

    private String currencySymbol;
    private EditText fromUahAmount;
    private EditText toUahAmount;
    private TextView resultFromUah;
    private TextView resultToUah;
    private ConverterViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);
        initViewModel();
        currencySymbol = getIntent().getStringExtra("symbol");
        initViews();
    }

    @SuppressLint("SetTextI18n")
    private  void initViews() {
        TextView fromUahLabel = findViewById(R.id.fromUahLabel);
        TextView toUahLabel = findViewById(R.id.toUahLabel);
        Button buttonFromUah = findViewById(R.id.buttonFromUah);
        Button buttonToUah = findViewById(R.id.buttonToUah);
        fromUahAmount = findViewById(R.id.fromUahAmount);
        toUahAmount = findViewById(R.id.toUahAmount);
        resultFromUah = findViewById(R.id.resultFromUah);
        resultToUah = findViewById(R.id.resultToUah);
        fromUahLabel.setText("Отримаєте " + currencySymbol);
        toUahLabel.setText("Віддаєте " + currencySymbol);
        //Обработчики нажатия на кнопки
        buttonFromUah.setOnClickListener((View v) -> {
            viewModel.convertFomUah(fromUahAmount,currencySymbol,resultFromUah);
        });
        buttonToUah.setOnClickListener((View v) -> {
            viewModel.convertToUah(toUahAmount,currencySymbol,resultToUah);
        });
    }
    //Инициализация viewModel для этой активности
    private void initViewModel() {
        viewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(ConverterViewModel.class);
    }
}
