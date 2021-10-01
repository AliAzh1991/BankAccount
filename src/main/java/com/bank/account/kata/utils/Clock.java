package com.bank.account.kata.utils;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Clock {

    public String dateAsString() {
        LocalDate today = LocalDate.now();
        return today.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    protected LocalDate today() {
        return LocalDate.now();
    }
}
