package com.blabla;

import com.blabla.Abstract.AbstractConvertionResult;
import com.blabla.Abstract.AbstractRate;

/**
 * Created by user on 06.06.2018.
 */
public class ConvertionResult extends AbstractConvertionResult {
/*
    protected double result;
    protected AbstractRate rate;
    protected double inputAmount;
    protected String operationResult;
    protected String errorMessage;
     */
    public void setSuccess(){
        operationResult="SUCCESS";
    }

    public void setError(String errorMessage){
        this.operationResult="ERROR";
        this.errorMessage=errorMessage;
    }

    public ConvertionResult(double result, AbstractRate rate, double inputAmount){
        this.result=result;
        this.rate=rate;
        this.inputAmount=inputAmount;
    }

    @Override
    public String toString() {
        if(operationResult=="ERROR") {
            return String.format("Результат: %S\nСообщение: %S",
                    getOperationResultString(), errorMessage);
        } else {
            return super.toString();
        }
    }
}
