package com.blabla.Abstract;

import java.util.Date;

/**
 * Абстрактый. Документ, удостоверяющий личность
 */
public class DULAbstract {
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    Date birthday;

}
