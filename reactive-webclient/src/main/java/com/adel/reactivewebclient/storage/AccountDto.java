package com.adel.reactivewebclient.storage;

public class AccountDto {

    private String number;
    private String customerId;
    private int amount;

    public AccountDto(String number, String customerId, int amount) {
        this.number = number;
        this.customerId = customerId;
        this.amount = amount;
    }

    public AccountDto() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
