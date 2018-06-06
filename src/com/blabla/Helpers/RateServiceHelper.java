package com.blabla.Helpers;

import com.blabla.Abstract.IRateService;
import com.blabla.CentralBankService;
import com.blabla.Currency;
import com.blabla.Rate;

public class RateServiceHelper {
    /**
     * Тестовый источник курсов
     * @return
     */
    public static IRateService getSimpleRateService(){
        Currency usd=CurrencyHelper.getCurrencyById("USD");
        Currency rub=CurrencyHelper.getCurrencyById("RUB");;
        Currency eur=CurrencyHelper.getCurrencyById("EUR");;
        CentralBankService s=new CentralBankService();
        s.add(new Rate(rub, usd, 25));
        s.add(new Rate(usd, rub,0.04));
        s.add(new Rate(eur, rub,0.03));
        s.add(new Rate(rub, eur,30));
        return s;
    }
}
