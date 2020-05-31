package com.example.kyrsach.converter;

import android.annotation.SuppressLint;
import android.widget.EditText;
import com.example.kyrsach.repository.AppRepository;

public class CurrencyConverter {

    //Метод для расчета из гривны в другую валюту
    @SuppressLint("DefaultLocale")
    public String convertFromUah(EditText text, String currencySymbol) {
        double receivedCurrency =   AppRepository.getInstance().getCurrencyByName(currencySymbol).getCurrencyPrice();
        double amount = getValueFromEditText(text);
        double result = amount/receivedCurrency;
        return String.format("%.2f", result);
    }

    //Метод для расчета из другой валюты в гривну
    @SuppressLint("DefaultLocale")
    public String convertToUah(EditText text, String currencySymbol) {
        double givenCurrency =   AppRepository.getInstance().getCurrencyByName(currencySymbol).getCurrencyPrice();
        double amount = getValueFromEditText(text);
        double result = amount * givenCurrency;
        return String.format("%.2f", result);
    }

    //Получение данных из формы и проверка на недопустимые символы
    private double getValueFromEditText(EditText editText) {
        if(editText.getText().length() == 0 || editText.getText().toString().equals("."))  {
            return 0;
        }
        return Double.parseDouble(editText.getText().toString());
    }
}
