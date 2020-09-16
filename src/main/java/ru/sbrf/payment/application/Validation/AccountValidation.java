package ru.sbrf.payment.application.Validation;

import lombok.AllArgsConstructor;
import ru.sbrf.payment.common.exception.WrongAccountRequirementsException;
import ru.sbrf.payment.server.Account;

@AllArgsConstructor
public class AccountValidation {
    private Account accountToPay;
    private long amountToPay;

    public AccountValidation checkAccountId() {
        String accID = accountToPay.getAccountId();
        String accIDS = accID.substring(5, 7);
        if (accID.length() != 20 || (!accIDS.equals("810") && !accIDS.equals("840") && !accIDS.equals("643") && !accIDS.equals("978"))) {
            throw new WrongAccountRequirementsException(accID + "Не явялется номером счета!");
        }
        return this;
    }

    public AccountValidation chekAccountAmount() {
        String accID = accountToPay.getAccountId();
        if (amountToPay <= 0 || amountToPay > accountToPay.getAmount()) {
            throw new WrongAccountRequirementsException("На счете " + accID + " недостаточно средств или не введена сумма платежа");
        }
        return this;
    }
}
