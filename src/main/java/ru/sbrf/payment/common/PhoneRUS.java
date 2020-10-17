package ru.sbrf.payment.common;

import lombok.Getter;

@Getter
public class PhoneRUS extends Phone {

    private final String PREFIX = "+7";
    private final int LENGTH = 12;

    public PhoneRUS(String number) {
        super(number);
    }
}
