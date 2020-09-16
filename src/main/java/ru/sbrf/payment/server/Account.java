package ru.sbrf.payment.server;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.sbrf.payment.common.Currency;

@AllArgsConstructor
@Getter
@Setter

public class Account {

    private String accountId;
    private Currency currency;
    private long amount;

}
