package com.blabla.Abstract;

import com.blabla.enums.OperationResultEnum;

/**
 * Абстрактный. Результат конверсии
 */
public abstract class ConversionResultAbstract {
    protected double result;
    protected RateAbstract rate;
    protected double inputAmount;
    protected OperationResultEnum operationResult;
    protected String errorMessage;
    private String operationResultString;

    protected String getOperationResultString() {
        operationResultString="Не известно";
        switch (operationResult){
            case SUCCESS:
                operationResultString="Успешно";
                break;
            case ERROR:
                operationResultString="Неуспешно";
                break;
        }
        return operationResultString;
    }




    @Override
    public String toString() {
        return String.format("Операция выполнена: %S\nИсходная валюта %S\nПолучено: %.2f %s\nВалюта %S\nВыдано %.2f %s\nКурс: 1 %s = %.2f %s"
                , getOperationResultString(), rate.getFrom().getName(),inputAmount,rate.getFrom().getShortName(), rate.getTo().getName(),result,rate.getTo().getShortName(),rate.getTo().getShortName(),rate.getRate(), rate.getFrom().getShortName());
    }
}
