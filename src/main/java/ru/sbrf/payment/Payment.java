package ru.sbrf.payment;

public class Payment {

    String phoneNumber;
    long amount;
    User user;

    public Payment(String phoneNumber, long amount, User user) {
        this.phoneNumber = phoneNumber;
        this.amount = amount;
        this.user = user;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
