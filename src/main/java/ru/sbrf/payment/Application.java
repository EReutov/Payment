package ru.sbrf.payment;

import ru.sbrf.payment.exception.NotEnoughMoneyException;
import ru.sbrf.payment.exception.WrongNumberFormatException;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Application implements Pay, WorkWithUserInfo {

    @Override
    public Payment pay() throws Exception {

        //получаем данные о клиенте
        User userToPay = workWithUserInfo();

        //получаем номер для оплаты
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long number = Long.parseLong(reader.readLine());
        String phoneNumberToPay = "";
        if (number < 9000000000L || number > 9999999999L) {
            throw new WrongNumberFormatException("+7" + number + " не является номером мобильного телефона");
        } else {
            phoneNumberToPay = "+7" + number;
        }

        //Получаем счет оплаты
        Account accountToPay = userToPay.getUserAccount();

        //получаем сумму оплаты
        long amountToPay = Long.parseLong(reader.readLine());
        if (amountToPay <= 0 || amountToPay > accountToPay.getAmount()) {
            throw new NotEnoughMoneyException("Недостаточно средств на счете или не введена сумма платежа");
        }

        Payment payment = new Payment(phoneNumberToPay, amountToPay, userToPay);

        return payment;
    }

    @Override
    //Получаем данные о пользователе?
    public User workWithUserInfo() {
        return null;
    }
}
