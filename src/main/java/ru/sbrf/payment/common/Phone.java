package ru.sbrf.payment.common;

import lombok.Getter;

@Getter
public abstract class Phone {

    private String number;
    private String PREFIX;
    private int LENGTH;

    public Phone(String number) {
        this.number = number;
    }
}
