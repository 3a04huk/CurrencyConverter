package com.blabla;

import com.blabla.Abstract.AbstractCurrency;

/**
 * Created by user on 06.06.2018.
 */
public class Currency extends AbstractCurrency {
    public Currency(String id){
        this.id=id;
    }
    public Currency(String id, String shortName, String name){
        this.id=id;
        this.shortName=shortName;
        this.name=name;
    }
}
