package com.example.kyrsach.repository.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//Класс шаблон для json полученного от api
public class ApiResponse {

    @SerializedName("r030")
    @Expose
    private Integer currencyNumber;
    @SerializedName("txt")
    @Expose
    private String currencyName;
    @SerializedName("rate")
    @Expose
    private Double currencyPrice;
    @SerializedName("cc")
    @Expose
    private String currencySymbol;
    @SerializedName("exchangedate")
    @Expose
    private String exchangeDate;

    public Integer getCurrencyNumber() {
        return currencyNumber;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public Double getCurrencyPrice() {
        return currencyPrice;
    }

    public String getCurrencySymbol() {
        return currencySymbol;
    }

    public String getExchangeDate() {
        return exchangeDate;
    }

    public ApiResponse(Integer currencyNumber, String currencyName, Double currencyPrice, String currencySymbol, String exchangeDate) {
        this.currencyNumber = currencyNumber;
        this.currencyName = currencyName;
        this.currencyPrice = currencyPrice;
        this.currencySymbol = currencySymbol;
        this.exchangeDate = exchangeDate;
    }
}