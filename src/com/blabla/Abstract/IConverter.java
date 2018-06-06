package com.blabla.Abstract;

/**
 * Created by user on 06.06.2018.
 */
public interface IConverter {
    AbstractConvertionResult convert(double amount, String currencyFrom, String currencyTo);
}
