package com.blabla.Abstract;

/**
 * Created by user on 06.06.2018.
 */
public abstract class AbstractConvertionResult {
    protected double result;
    protected AbstractRate rate;
    protected double inputAmount;
    protected String operationResult;
    protected String errorMessage;
    String operationResultString;

    protected String getOperationResultString() {
        operationResultString="Не известно";
        switch (operationResult){
            case "SUCCESS":
                operationResultString="Успешно";
                break;
            case "ERROR":
                operationResultString="Неуспешно";
                break;
        }
        return operationResultString;
    }




    @Override
    public String toString() {
        return String.format("Операция выполнена: %S\nИсходная валюта %S\nПолучено: %.2f %s\nВалюта %S\nВыдано %.2f %s\nКурс: 1 %s = %.2f %s"
                , getOperationResultString(), rate.getFrom().getName(),inputAmount,rate.getFrom().getShortName(), rate.getTo().getName(),result,rate.getTo().getShortName(),rate.getFrom().getShortName(),rate.getRate(), rate.getTo().getShortName());
    }
}
