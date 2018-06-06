package com.blabla.Abstract;

import java.util.ArrayList;

/**
 * Created by user on 06.06.2018.
 */
public interface IRateService {
    void add(AbstractRate rate);
    void update(AbstractRate rate);
    void delete(AbstractRate rate);
    ArrayList<AbstractRate> getRates();
    AbstractRate getRateById(String idFrom, String idTo);
}
