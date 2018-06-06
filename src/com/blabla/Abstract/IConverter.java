package com.blabla.Abstract;

/**
 * Интерфейс. Функционал конвертера
 */
public interface IConverter {
    /**
     * Конвертация
     * @param amount
     * @param currencyFrom
     * @param currencyTo
     * @return
     */
    ConversionResultAbstract convert(double amount, String currencyFrom, String currencyTo);
}
