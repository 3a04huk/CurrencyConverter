package com.blabla;

import com.blabla.Abstract.*;
import com.blabla.enums.OperationResultEnum;

import java.util.Date;

/**
 * Created by user on 06.06.2018.
 */
public class Operator implements IOperator {
    private IConverter converter;

    Operator(IConverter converter){
        this.converter=converter;
    }

    @Override
    public ConversionRequestAbstract createConversionRequest(IClient client, CurrencyAbstract currencyFrom, double amount, CurrencyAbstract currencyTo) {
        ConversionRequest cr=new ConversionRequest();
        cr.setFrom(currencyFrom);
        cr.setTo(currencyTo);
        cr.setAmount(amount);
        if (!check(client)) {
            cr.setOperationResult(OperationResultEnum.ERROR, "ДУЛ не подошел :)");
        } else {
            if (amount<=0) {
                cr.setOperationResult(OperationResultEnum.ERROR, "Сумма меньше 0");
            } else {
                cr.setOperationResult(OperationResultEnum.SUCCESS, "");
            }
        }
        return cr;
    }

    @Override
    public ConversionResultAbstract doOperation(ConversionRequestAbstract request) {
        if (request.getOperationResult()==OperationResultEnum.ERROR){
            ConversionResult cr=new ConversionResult(0,new Rate(request.getFrom(),request.getTo(),0),request.getAmount());
            cr.setError(request.getErrorMessage());
            return cr;
        } else {
            return converter.convert(request.getAmount(), request.getFrom().getId(), request.getTo().getId());
        }
    }

    private boolean check(IClient client) {
        if (client.getDul()==null) return false;
        if(new Date().getYear()-client.getDul().getBirthday().getYear()<18) return false;
        return true;
    }
}
