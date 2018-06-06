package com.blabla;

import com.blabla.Abstract.AbstractCurrency;
import com.blabla.Abstract.AbstractRate;

/**
 * Created by user on 06.06.2018.
 */
public class Rate extends AbstractRate {
    public Rate(AbstractCurrency from, AbstractCurrency to, double rate){
        this.from=from;
        this.to=to;
        this.rate=rate;
    }
}
