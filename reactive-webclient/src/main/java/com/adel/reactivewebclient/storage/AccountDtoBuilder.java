package com.adel.reactivewebclient.storage;

public final class AccountDtoBuilder {
    private String number;
    private String customerId;
    private int amount;

    private AccountDtoBuilder() {
    }

    public static AccountDtoBuilder anAccountDto() {
        return new AccountDtoBuilder();
    }

    public AccountDtoBuilder number(String number) {
        this.number = number;
        return this;
    }

    public AccountDtoBuilder customerId(String customerId) {
        this.customerId = customerId;
        return this;
    }

    public AccountDtoBuilder amount(int amount) {
        this.amount = amount;
        return this;
    }

    public AccountDto build() {
        AccountDto accountDto = new AccountDto();
        accountDto.setNumber(number);
        accountDto.setCustomerId(customerId);
        accountDto.setAmount(amount);
        return accountDto;
    }
}
