package com.blabla;

import com.blabla.Abstract.*;

/**
 * Created by user on 06.06.2018.
 */
public class Converter implements IConverter {
    private IRateService service;

    Converter(IRateService service){
        this.service=service;
    }

    @Override
    public AbstractConvertionResult convert(double amount, String currencyFrom, String currencyTo) {
        AbstractRate rate=service.getRateById(currencyFrom,currencyTo);
        if (rate==null){
            Currency from=new Currency(currencyFrom);
            Currency to=new Currency(currencyTo);
            Rate noRate=new Rate(from, to, 0);
            ConvertionResult r=new ConvertionResult(noRate.getRate(), noRate, amount);
            r.setError("Не найден курс");
            return r;
        }

        ConvertionResult r=new ConvertionResult(amount/rate.getRate(),rate,amount);
        r.setSuccess();
        return r;
    }

}
