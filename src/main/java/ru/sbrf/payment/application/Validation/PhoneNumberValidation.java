package ru.sbrf.payment.application.Validation;

import lombok.AllArgsConstructor;
import ru.sbrf.payment.common.Phone;
import ru.sbrf.payment.common.exception.WrongNumberFormatException;


@AllArgsConstructor
public class PhoneNumberValidation<T extends Phone> {
    private T phoneNumber;

    public void checkPhoneNumber() {
        if (!phoneNumber.getNumber().startsWith(phoneNumber.getPREFIX()) || phoneNumber.getNumber().length() != phoneNumber.getLENGTH()) {
            throw new WrongNumberFormatException(phoneNumber + " не является номером мобильного телефона");
        }
    }
}
