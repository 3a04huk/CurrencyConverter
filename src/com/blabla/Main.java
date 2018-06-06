package com.blabla;

import com.blabla.Abstract.ConversionRequestAbstract;
import com.blabla.Abstract.ConversionResultAbstract;
import com.blabla.Abstract.RateAbstract;
import com.blabla.Abstract.IRateService;
import com.blabla.Helpers.CurrencyHelper;
import com.blabla.Helpers.Printer;
import com.blabla.Helpers.RateServiceHelper;

import java.util.ArrayList;
import java.util.Calendar;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Currency usd=new Currency("USD","$","Доллар США");
        Currency rub=new Currency("RUB","руб.","Российский рубль");

        Rate r1=new Rate(rub, usd, 25);
        Rate r2=new Rate(usd, rub,0.04);

        IRateService s= RateServiceHelper.getSimpleRateService();

        RateAbstract current=s.getRateById("RUB","USD");
        DUL clientDul=new DUL();
        Calendar calendar=Calendar.getInstance();
        calendar.set(1982,1,1);
        clientDul.setBirthday(calendar.getTime());
        Client client=new Client(clientDul);
        Operator operator=new Operator(new Converter(s));
        double amount=100;
        ConversionRequestAbstract request=operator.createConversionRequest(client,usd,amount,rub);
        ConversionResultAbstract result= operator.doOperation(request);
        Printer.PrintConvertionResult(result);
        request=operator.createConversionRequest(client,rub,amount,usd);
        result= operator.doOperation(request);
        Printer.PrintConvertionResult(result);
        Currency eur=new Currency("EUR","E","Европейский евро");
        request=operator.createConversionRequest(client,rub,amount,eur);
        result= operator.doOperation(request);
        Printer.PrintConvertionResult(result);
        FileDataSource fds=new FileDataSource("./out/test.in");
        ArrayList<ClientOperationDTO> l=fds.load();
        for (ClientOperationDTO item: l) {
            clientDul=new DUL();
            clientDul.setBirthday(item.getBirthday());
            client=new Client(clientDul);
            Currency from=null;
            Currency to=null;
            try {
                from = CurrencyHelper.getCurrencyById(item.getCurrencyFrom());
                if(from==null){
                    System.out.println(String.format("Валюта %S не обслуживается.",item.getCurrencyFrom()));
                    continue;
                }
            } catch (Exception e){
                System.out.println(String.format("Ошибка получения валюты %S. Подробности:%s",item.getCurrencyFrom(),e));
                continue;
            }
            try {
                to = CurrencyHelper.getCurrencyById(item.getCurrencyTo());
                if(to==null){
                    System.out.println(String.format("Валюта %S не обслуживается.",item.getCurrencyFrom()));
                    continue;
                }
            } catch (Exception e){
                System.out.println(String.format("Ошибка получения валюты %S. Подробности:%s",item.getCurrencyTo(),e));
                continue;
            }
            request=operator.createConversionRequest(client, from,item.getAmount(),to);
            result= operator.doOperation(request);
            Printer.PrintConvertionResult(result);
        }
    }
}
