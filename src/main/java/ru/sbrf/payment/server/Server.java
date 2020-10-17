package ru.sbrf.payment.server;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ru.sbrf.payment.client.User;
import ru.sbrf.payment.common.Payment;

import java.util.ArrayList;
import java.util.HashMap;

@AllArgsConstructor
@NoArgsConstructor
@Getter

public class Server implements MakeAPayment {

    //Делаем коллекцию на хранение детаелй платежа
    private HashMap<String, Payment> payments = new HashMap<String, Payment>();

    //Почему в инициализации если писать просто <> ругается на уровень языка - якобы он 6? Раньше до проекта не ругался.
    private ArrayList<User> users = new ArrayList<User>();

    @Override
    public void paymentApprove(Payment payment) {
        //проверка на уникальность платежа
        if (payments.containsKey(payment.getId())) {
            System.out.println("Задвоение платежа");
            return;
        }
        //если уникальный добавляем в мапу содержащую список платежей с ключом по их ID
        payments.put(payment.getId(), payment);

        //Выполняем какую-то логику по проведению платежа - например уменьшаем баланс счета с которого осуществляется платеж
        payment.getUser().getUserAccount().setAmount(payment.getUser().getUserAccount().getAmount() - payment.getAmount());
        //тут можно было красивее - возможно сохранять ссылку на счет в платеже?
        System.out.println("Платеж проведен. Остаток на счете: " + payment.getUser().getUserAccount().getAmount() / 100);
    }
}
