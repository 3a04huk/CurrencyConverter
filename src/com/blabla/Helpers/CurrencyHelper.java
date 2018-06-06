package com.blabla.Helpers;

import com.blabla.Currency;

import java.util.HashMap;

public class CurrencyHelper {
    static HashMap<String,Currency> currencyMap;
    static {
        currencyMap=new HashMap<String,Currency>();
        Currency usd=new Currency("USD","$","Доллар США");
        Currency rub=new Currency("RUB","руб.","Российский рубль");
        Currency eur=new Currency("EUR","E","Евро");
        currencyMap.put(usd.getId(),usd);
        currencyMap.put(rub.getId(),rub);
        currencyMap.put(eur.getId(),eur);
    }

    /**
     * Ищет валюту по ИД
     * @param id
     * @return
     */
    public static Currency getCurrencyById(String id){
        return currencyMap.get(id);
    }
}
