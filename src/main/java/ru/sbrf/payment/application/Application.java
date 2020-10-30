package ru.sbrf.payment.application;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import ru.sbrf.payment.application.Validation.AccountValidation;
import ru.sbrf.payment.application.Validation.PhoneNumberValidation;
import ru.sbrf.payment.client.User;
import ru.sbrf.payment.common.Payment;
import ru.sbrf.payment.common.Phone;
import ru.sbrf.payment.common.PhoneBLR;
import ru.sbrf.payment.common.PhoneRUS;
import ru.sbrf.payment.common.exception.WrongAccountRequirementsException;
import ru.sbrf.payment.common.exception.WrongNumberFormatException;
import ru.sbrf.payment.server.Account;

import java.util.Date;
import java.util.Scanner;

@AllArgsConstructor
@NoArgsConstructor
@Getter

@Component
public class Application implements Pay {
    private Payment payment;

    /*static {
        userToPay = new User("=79002066899",new Account("40817810570000123456",));
    }*/

    @Override
    public void pay(User userToPay) {

        Scanner sc = new Scanner(System.in);
        Phone phoneNumberToPay = null;
        Account accountToPay;

        try {
            //Вводим номер телефона для оплаты (Добавлять ли далее выбор - номер из пользователя или ввод вручную?)
            System.out.println("Введите номер телефона:");
            String number = sc.nextLine();
            if (number.startsWith("+375")) phoneNumberToPay = new PhoneBLR(number);
            if (number.startsWith("+7")) phoneNumberToPay = new PhoneRUS(number);

            PhoneNumberValidation PhoneNumberValidation = new PhoneNumberValidation(phoneNumberToPay);

            //phoneNumberValidation.checkPhoneNumber(phoneNumberValidation.getPhoneNumber() -> !phoneNumberValidation.getPhoneNumber().getNumber().startsWith(phoneNumberValidation.getPhoneNumber().getPREFIX()) || phoneNumberValidation.getPhoneNumber().getNumber().length() != phoneNumberValidation.getPhoneNumber().getLENGTH());
            //phoneNumberValidation.checkPhoneNumber(phoneNumberToPay);
            PhoneNumberValidation.checkPhoneNumber(phoneNumber -> !phoneNumber.getNumber().startsWith(phoneNumber.getPREFIX()) || phoneNumber.getNumber().length() != phoneNumber.getLENGTH());

            //номер счета пока что получаем из пользователя (Реализовывать ли выбор из нескольких счетов относящихся к пользователю?)
            accountToPay = userToPay.getUserAccount();

            //получаем сумму оплаты
            long amountToPay = sc.nextLong() * 100;

            AccountValidation accountValidation = new AccountValidation(accountToPay, amountToPay);

            accountValidation.checkAccountId().chekAccountAmount();

            Long paymentTime = new Date().getTime();

            //Создаем идентификатор платежа
            String paymentId = paymentTime + phoneNumberToPay.getNumber() + accountToPay.getAccountId();

            payment = new Payment(paymentId, phoneNumberToPay.getNumber(), amountToPay, userToPay);
        } catch (WrongAccountRequirementsException ex) {
            System.out.println(ex);
        } catch (WrongNumberFormatException ex) {
            System.out.println(ex);
        }
    }
}
