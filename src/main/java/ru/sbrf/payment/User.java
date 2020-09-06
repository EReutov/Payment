package ru.sbrf.payment;

public class User {

    int id;
    String phoneNumber;
    Account userAccount;
    Account operatorAccount;

    public User() {
    }

    public User(int id, String phoneNumber, Account userAccount, Account operatorAccount) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.userAccount = userAccount;
        this.operatorAccount = operatorAccount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Account getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(Account userAccount) {
        this.userAccount = userAccount;
    }

    public Account getOperatorAccount() {
        return operatorAccount;
    }

    public void setOperatorAccount(Account operatorAccount) {
        this.operatorAccount = operatorAccount;
    }

}
