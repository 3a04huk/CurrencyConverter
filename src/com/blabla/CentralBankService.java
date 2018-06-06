package com.blabla;

import com.blabla.Abstract.AbstractRate;
import com.blabla.Abstract.IRateService;

import java.util.ArrayList;

/**
 * Created by user on 06.06.2018.
 */
public class CentralBankService implements IRateService {
    ArrayList<AbstractRate> rates=new ArrayList<>();

    @Override
    public void add(AbstractRate rate) {
        rates.add(rate);
    }

    @Override
    public void update(AbstractRate rate) {
        rates.remove(rate);
        add(rate);
    }

    @Override
    public void delete(AbstractRate rate) {
        rates.remove(rate);
    }

    @Override
    public ArrayList<AbstractRate> getRates() {
        return rates;
    }

    @Override
    public AbstractRate getRateById(String idFrom, String idTo) {
        for (AbstractRate r:rates) {
            if(r.getFrom().getId()==idFrom && r.getTo().getId()==idTo){
                return  r;
            }
        }
        return null;
    }
}
