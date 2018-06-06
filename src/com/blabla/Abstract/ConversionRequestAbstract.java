package com.blabla.Abstract;

import com.blabla.enums.OperationResultEnum;

/**
 * Абстрактный кдасс запрос по конверсии
 */
public abstract class ConversionRequestAbstract {
    protected String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public OperationResultEnum getOperationResult() {
        return operationResult;
    }

    public void setOperationResult(OperationResultEnum operationResult, String errorMessage) {
        this.operationResult = operationResult;
        this.errorMessage=errorMessage;
    }

    protected OperationResultEnum operationResult;

    CurrencyAbstract from;

    public CurrencyAbstract getTo() {
        return to;
    }

    public void setTo(CurrencyAbstract to) {
        this.to = to;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    CurrencyAbstract to;

    public CurrencyAbstract getFrom() {
        return from;
    }

    public void setFrom(CurrencyAbstract from) {
        this.from = from;
    }

    double amount;

}
