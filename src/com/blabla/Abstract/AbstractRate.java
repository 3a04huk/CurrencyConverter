package com.blabla.Abstract;

/**
 * Created by user on 06.06.2018.
 */
public abstract class AbstractRate {
    protected AbstractCurrency from;
    protected AbstractCurrency to;
    protected double rate;

    public double getRate() {
        return rate;
    }

    public AbstractCurrency getTo() {
        return to;

    }

    public AbstractCurrency getFrom() {
        return from;
    }

    @Override
    public String toString() {
        return String.format("%S/%S : 1-%.2f",from.getId(),to.getId(),rate);
    }
}
