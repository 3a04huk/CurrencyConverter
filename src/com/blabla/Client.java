package com.blabla;

import com.blabla.Abstract.DULAbstract;
import com.blabla.Abstract.IClient;

/**
 * Created by user on 06.06.2018.
 */
public class Client implements IClient {
    DUL dul;

    public Client(DUL dul) {
        this.dul = dul;
    }

    @Override
    public DULAbstract getDul() {
        return dul;
    }
}
