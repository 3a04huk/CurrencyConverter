package com.blabla;

import com.blabla.Abstract.AbstractConvertionRequest;
import com.blabla.Abstract.AbstractConvertionResult;
import com.blabla.Abstract.AbstractRate;
import com.blabla.Helpers.Printer;

import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Currency usd=new Currency("USD","$","Доллар США");
        Currency rub=new Currency("RUB","руб.","Российский рубль");
        Rate r1=new Rate(rub, usd, 25);
        Rate r2=new Rate(usd, rub,0.04);

        CentralBankService s=new CentralBankService();
        s.add(r1);
        s.add(r2);
        AbstractRate current=s.getRateById("RUB","USD");
        DUL clientDul=new DUL();
        Calendar calendar=Calendar.getInstance();
        calendar.set(1982,1,1);
        clientDul.setBirthday(calendar.getTime());
        Client client=new Client(clientDul);
        Operator operator=new Operator(s,new Converter(s));
        double amount=100;
        AbstractConvertionRequest request=operator.createConvertionRequest(client,usd,amount,rub,r1);
        if (request == null) {
            System.out.println("Проверка не пройдена");
            return;
        }
        System.out.println();
        AbstractConvertionResult result= operator.doOperation(request);
        Printer.PrintConvertionResult(result);
        request=operator.createConvertionRequest(client,rub,amount,usd,r1);
        result= operator.doOperation(request);
        Printer.PrintConvertionResult(result);
        Currency eur=new Currency("EUR","E","Европейский евро");
        request=operator.createConvertionRequest(client,rub,amount,eur,r1);
        result= operator.doOperation(request);
        Printer.PrintConvertionResult(result);
    }
}
