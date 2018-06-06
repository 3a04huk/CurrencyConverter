package com.blabla.Abstract;

/**
 * Created by user on 06.06.2018.
 */
public abstract class AbstractConvertionRequest {
    public AbstractRate getRate() {
        return rate;
    }

    public void setRate(AbstractRate rate) {
        this.rate = rate;
    }

    AbstractRate rate;

    AbstractCurrency from;

    public AbstractCurrency getTo() {
        return to;
    }

    public void setTo(AbstractCurrency to) {
        this.to = to;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    AbstractCurrency to;

    public AbstractCurrency getFrom() {
        return from;
    }

    public void setFrom(AbstractCurrency from) {
        this.from = from;
    }

    double amount;

}
