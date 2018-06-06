package com.blabla;

import com.blabla.Abstract.CurrencyAbstract;
import com.blabla.Abstract.RateAbstract;
import com.blabla.Abstract.IRateService;

import java.util.ArrayList;

/**
 * Источник курсов валют
 */
public class CentralBankService implements IRateService {
    ArrayList<RateAbstract> rates=new ArrayList<>();

    @Override
    public void add(RateAbstract rate) {
        rates.add(rate);
    }

    @Override
    public void update(RateAbstract rate) {
        rates.remove(rate);
        add(rate);
    }

    @Override
    public void delete(RateAbstract rate) {
        rates.remove(rate);
    }

    @Override
    public ArrayList<RateAbstract> getRates() {
        return rates;
    }

    @Override
    public RateAbstract getRateById(String idFrom, String idTo) {
        for (RateAbstract r:rates) {
            if(r.getFrom().getId()==idFrom && r.getTo().getId()==idTo){
                return  r;
            }
        }
        return null;
    }
}
