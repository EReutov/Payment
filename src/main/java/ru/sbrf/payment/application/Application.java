package ru.sbrf.payment.application;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ru.sbrf.payment.application.Validation.AccountValidation;
import ru.sbrf.payment.application.Validation.PhoneNumberValidation;
import ru.sbrf.payment.client.User;
import ru.sbrf.payment.common.Payment;
import ru.sbrf.payment.common.exception.WrongAccountRequirementsException;
import ru.sbrf.payment.common.exception.WrongNumberFormatException;
import ru.sbrf.payment.server.Account;

import java.util.Date;
import java.util.Scanner;

@AllArgsConstructor
@NoArgsConstructor
@Getter

public class Application implements Pay {
    private Payment payment;

    /*static {
        userToPay = new User("=79002066899",new Account("40817810570000123456",));
    }*/

    @Override
    public void pay(User userToPay) throws Exception {

        Scanner sc = new Scanner(System.in);
        String phoneNumberToPay;
        Account accountToPay;

        //Вводим номер телефона для оплаты (Добавлять ли далее выбор - номер из пользователя или ввод вручную?)
        System.out.println("Введите номер телефона:");
        phoneNumberToPay = sc.nextLine();
        PhoneNumberValidation phoneNumberValidation = new PhoneNumberValidation(phoneNumberToPay);

        try {
            phoneNumberValidation.checkPhoneNumber();
        } catch (WrongNumberFormatException ex) {
            System.out.println(ex);
        }

        //номер счета пока что получаем из пользователя (Реализовывать ли выбор из нескольких счетов относящихся к пользователю?)
        accountToPay = userToPay.getUserAccount();

        //получаем сумму оплаты
        long amountToPay = sc.nextLong();
        AccountValidation accountValidation = new AccountValidation(accountToPay, amountToPay);

        try {
            accountValidation.checkAccountId().chekAccountAmount();
        } catch (WrongAccountRequirementsException ex) {
            System.out.println(ex);
        }

        //Создаем идентификатор платежа
        Long paymentTime = new Date().getTime();
        String paymentId = paymentTime + phoneNumberToPay + accountToPay.getAccountId();

        payment = new Payment(paymentId, phoneNumberToPay, amountToPay, userToPay);

    }
}
