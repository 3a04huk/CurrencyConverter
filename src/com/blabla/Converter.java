package com.blabla;

import com.blabla.Abstract.AbstractConvertionResult;
import com.blabla.Abstract.AbstractRate;
import com.blabla.Abstract.IConverter;
import com.blabla.Abstract.IRateService;

/**
 * Created by user on 06.06.2018.
 */
public class Converter implements IConverter {
    IRateService service;

    public Converter(IRateService service){
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
        ConvertionResult r=new ConvertionResult(rate.getRate()*amount,rate,amount);
        r.setSuccess();
        return r;
    }
}
