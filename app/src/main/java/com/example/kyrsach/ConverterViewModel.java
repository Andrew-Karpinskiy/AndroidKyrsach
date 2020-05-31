package com.example.kyrsach;

import android.annotation.SuppressLint;
import android.app.Application;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import com.example.kyrsach.converter.CurrencyConverter;
import com.example.kyrsach.repository.AppRepository;

public class ConverterViewModel extends AndroidViewModel {

    private CurrencyConverter currencyConverter;

    public ConverterViewModel(@NonNull Application application) {
        super(application);
        currencyConverter  = new CurrencyConverter();
    }

    @SuppressLint("SetTextI18n")
    void convertFomUah(EditText fromUahAmount, String currencySymbol, TextView resultFromUah) {
        if( AppRepository.getInstance().getIsData()) {
            String result = currencyConverter.convertFromUah(fromUahAmount, currencySymbol);
            resultFromUah.setText(""+result);
        }
    }

    @SuppressLint("SetTextI18n")
    void  convertToUah(EditText toUahAmount, String currencySymbol, TextView resultToUah) {
        if( AppRepository.getInstance().getIsData()) {
            String result = currencyConverter.convertToUah(toUahAmount, currencySymbol);
            resultToUah.setText(""+result);
        }
    }
}
