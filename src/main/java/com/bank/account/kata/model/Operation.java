package com.bank.account.kata.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class Operation {

    private final String date;
    private final int amount;

    public Operation(String date, int amount) {
        this.date = date;
        this.amount = amount;
    }
}
