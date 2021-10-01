package com.bank.account.kata.model;

import com.bank.account.kata.repository.OperationRepository;

public class Account {

    private final OperationRepository operationRepository;

    public Account(OperationRepository operationRepository) {
        this.operationRepository = operationRepository;
    }

    public void deposit(int amount) {
        operationRepository.addDeposit(amount);
    }

    public void withdraw(int amount) {
        operationRepository.addWithdraw(amount);
    }

    public void printStatement() {
        throw new UnsupportedOperationException();
    }
}
