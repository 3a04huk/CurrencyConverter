package com.blabla.Abstract;

/**
 * Created by user on 06.06.2018.
 */
public abstract class AbstractCurrency {

    protected String id;
    protected String shortName;
    protected String name;

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getShortName() {
        return shortName;
    }

    @Override
    public String toString() {
        return String.format("%S(%S)", name, id);
    }
}
