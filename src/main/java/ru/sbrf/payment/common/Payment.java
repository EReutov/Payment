package ru.sbrf.payment.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.sbrf.payment.client.User;

@AllArgsConstructor
@Getter
@Setter

public class Payment {

    String Id;
    String phoneNumber;
    long amount;
    User user;

}
