package ru.sbrf.payment.common;

import lombok.Getter;

@Getter
public class PhoneBLR extends Phone {

    private final String PREFIX = "+375";
    private final int LENGTH = 13;

    public PhoneBLR(String number) {
        super(number);
    }
}
