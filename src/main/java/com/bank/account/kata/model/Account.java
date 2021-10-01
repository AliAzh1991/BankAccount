package com.bank.account.kata.model;

import com.bank.account.kata.repository.OperationRepository;
import com.bank.account.kata.utils.OperationPrinter;

public class Account {

    private final OperationRepository operationRepository;
    private final OperationPrinter operationPrinter;

    public Account(OperationRepository operationRepository,
                   OperationPrinter operationPrinter) {
        this.operationRepository = operationRepository;
        this.operationPrinter = operationPrinter;
    }

    public void deposit(int amount) {
        operationRepository.addDeposit(amount);
    }

    public void withdraw(int amount) {
        operationRepository.addWithdraw(amount);
    }

    public void printStatement() {
        operationPrinter.print(operationRepository.allOperations());
    }
}
