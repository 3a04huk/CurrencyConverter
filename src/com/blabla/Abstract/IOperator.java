package com.blabla.Abstract;

/**
 * Интерфейс. Функционал оператора
 */
public interface IOperator {
    /**
     * Формирует запрос на конвертацию
     * @param client
     * @param currencyFrom
     * @param amount
     * @param currencyTo
     * @return
     */
    ConversionRequestAbstract createConversionRequest(IClient client, CurrencyAbstract currencyFrom, double amount, CurrencyAbstract currencyTo);
    ConversionResultAbstract doOperation(ConversionRequestAbstract request);
}
