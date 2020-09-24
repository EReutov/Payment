package ru.sbrf.payment;

import ru.sbrf.payment.application.Application;
import ru.sbrf.payment.client.User;
import ru.sbrf.payment.common.Currency;
import ru.sbrf.payment.common.PhoneRUS;
import ru.sbrf.payment.server.Account;
import ru.sbrf.payment.server.Server;

public class Main {
    public static void main(String[] args) {
        /*
        Прошу коммент по следующему предупреждению при package:
        Some problems were encountered while building the effective model for groupId:Payment:jar:1.0-SNAPSHOT
'build.plugins.plugin.version' for org.apache.maven.plugins:maven-compiler-plugin is missing. @ line 12, column 21
It is highly recommended to fix these problems because they threaten the stability of your build.
For this reason, future Maven versions might no longer support building such malformed projects.
        */

        User userToPay = new User(new PhoneRUS("+79002066899"), new Account("40817810570000123456", Currency.RUB, 30000));
        Application app = new Application();
        Server server = new Server();

        app.pay(userToPay);
        server.paymentApprove(app.getPayment());

    }
}
