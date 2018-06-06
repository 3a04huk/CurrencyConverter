package com.blabla;

import com.blabla.Abstract.AbstractConvertionRequest;
import com.blabla.Abstract.AbstractRate;

import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Currency usd=new Currency("USD","$","Доллар США");
        Currency rub=new Currency("RUB","руб.","Российский рубль");
        Rate r1=new Rate(rub, usd, 25);
        Rate r2=new Rate(usd, rub,0.25);

        CentralBankService s=new CentralBankService();
        s.add(r1);
        s.add(r2);
        AbstractRate current=s.getRateById("RUB","USD");
        DUL clientDul=new DUL();
        Calendar calendar=Calendar.getInstance();
        calendar.set(1982,1,1);
        clientDul.setBirthday(calendar.getTime());
        Client client=new Client(clientDul);
        Operator operator=new Operator();
        AbstractConvertionRequest request=operator.createConvertionRequest(client,usd,100,rub,r1);
//        Converter c=new Converter(s);
//        System.out.println(c.convert(25,"RUB","USD"));
//        System.out.println();
//        System.out.println(c.convert(25,"RUB","EUR"));
    }
}
