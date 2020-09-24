package ru.sbrf.payment.client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ru.sbrf.payment.common.Phone;
import ru.sbrf.payment.server.Account;

@AllArgsConstructor
@NoArgsConstructor
@Getter

public class User {

    private Phone phoneNumber;
    private Account userAccount;

}
