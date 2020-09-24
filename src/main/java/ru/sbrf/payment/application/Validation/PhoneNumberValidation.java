package ru.sbrf.payment.application.Validation;

import lombok.AllArgsConstructor;
import ru.sbrf.payment.common.exception.WrongNumberFormatException;


@AllArgsConstructor
public class PhoneNumberValidation {
    private String phoneNumber;

    public void checkPhoneNumber() {
        if (!phoneNumber.startsWith("+7") || phoneNumber.length() != 12) {
            throw new WrongNumberFormatException(phoneNumber + " не является номером мобильного телефона");
        }
    }
}
