package com.blabla;

import com.blabla.Abstract.CurrencyAbstract;
import com.blabla.Abstract.RateAbstract;

/**
 * Created by user on 06.06.2018.
 */
public class Rate extends RateAbstract {
    public Rate(CurrencyAbstract from, CurrencyAbstract to, double rate){
        this.from=from;
        this.to=to;
        this.rate=rate;
    }
}
