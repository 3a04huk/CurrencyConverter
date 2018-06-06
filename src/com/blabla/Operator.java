package com.blabla;

import com.blabla.Abstract.*;

import java.time.Year;
import java.util.Date;

/**
 * Created by user on 06.06.2018.
 */
public class Operator implements IOperator {

    @Override
    public AbstractConvertionRequest createConvertionRequest(IClient client, AbstractCurrency currencyFrom, double amount, AbstractCurrency currencyTo, AbstractRate rate) {
        if (check(client)) {
            ConvertionRequest cr=new ConvertionRequest();
            cr.setFrom(currencyFrom);
            cr.setTo(currencyTo);
            cr.setAmount(amount);
            cr.setRate(rate);
            return cr;
        } else {
            return null;
        }
    }

    boolean check(IClient client) {
        if (client.getDul()==null) return false;
        if(new Date().getYear()-client.getDul().getBirthday().getYear()<18) return false;
        return true;
    }
}
