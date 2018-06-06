package com.blabla.Abstract;

/**
 * Created by user on 06.06.2018.
 */
public interface IOperator {
    AbstractConvertionRequest createConvertionRequest(IClient client,AbstractCurrency currencyFrom, double amount, AbstractCurrency currencyTo, AbstractRate rate);
    AbstractConvertionResult doOperation(AbstractConvertionRequest request);
}
