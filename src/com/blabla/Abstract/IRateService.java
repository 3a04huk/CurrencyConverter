package com.blabla.Abstract;

import java.util.ArrayList;

/**
 * Интерфейс. Функционал источник курсов
 */
public interface IRateService {
    void add(RateAbstract rate);
    void update(RateAbstract rate);
    void delete(RateAbstract rate);
    ArrayList<RateAbstract> getRates();
    RateAbstract getRateById(String idFrom, String idTo);
}
