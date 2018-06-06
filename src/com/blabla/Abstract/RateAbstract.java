package com.blabla.Abstract;

/**
 * Абстрактный. Курс вылюты.
 */
public abstract class RateAbstract {
    protected CurrencyAbstract from;
    protected CurrencyAbstract to;
    protected double rate;

    public double getRate() {
        return rate;
    }

    public CurrencyAbstract getTo() {
        return to;

    }

    public CurrencyAbstract getFrom() {
        return from;
    }

    @Override
    public String toString() {
        return String.format("%S/%S : 1-%.2f",from.getId(),to.getId(),rate);
    }
}
