package ru.sbrf.payment.client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ru.sbrf.payment.server.Account;

@AllArgsConstructor
@NoArgsConstructor
@Getter

public class User {

    private String phoneNumber;
    private Account userAccount;

}
