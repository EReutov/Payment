package ru.sbrf.payment.application.Validation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.sbrf.payment.common.Phone;
import ru.sbrf.payment.common.exception.WrongNumberFormatException;

import java.util.function.Predicate;


@AllArgsConstructor
@Getter
public class PhoneNumberValidation<T extends Phone> {
    private T phoneNumber;

    public void checkPhoneNumber(Predicate<Phone> pr) {
        if (pr.test(phoneNumber)) {
            throw new WrongNumberFormatException(phoneNumber + " не является номером мобильного телефона");
        }
    }

    public T getPhoneNumber() {
        return phoneNumber;
    }
}
