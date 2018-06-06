package com.blabla;

import com.blabla.Abstract.ConversionResultAbstract;
import com.blabla.Abstract.RateAbstract;
import com.blabla.enums.OperationResultEnum;

/**
 * Created by user on 06.06.2018.
 */
public class ConversionResult extends ConversionResultAbstract {
/*
    protected double result;
    protected RateAbstract rate;
    protected double inputAmount;
    protected String operationResult;
    protected String errorMessage;
     */
    public void setSuccess(){
        operationResult= OperationResultEnum.SUCCESS;
    }

    public void setError(String errorMessage){
        this.operationResult=OperationResultEnum.ERROR;
        this.errorMessage=errorMessage;
    }

    public ConversionResult(double result, RateAbstract rate, double inputAmount){
        this.result=result;
        this.rate=rate;
        this.inputAmount=inputAmount;
    }

    @Override
    public String toString() {
        if(operationResult==OperationResultEnum.ERROR) {
            return String.format("Результат: %S\nСообщение: %S",
                    getOperationResultString(), errorMessage);
        } else {
            return super.toString();
        }
    }
}
