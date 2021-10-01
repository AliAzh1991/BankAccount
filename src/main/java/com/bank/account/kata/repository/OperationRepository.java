package com.bank.account.kata.repository;

import com.bank.account.kata.model.Operation;
import com.bank.account.kata.utils.Clock;

import java.util.ArrayList;
import java.util.List;

public class OperationRepository {

    private final Clock clock;
    private final List<Operation> operations = new ArrayList<>();
    public OperationRepository(Clock clock) {
        this.clock = clock;
    }

    public void addDeposit(int amount) {
        operations.add(new Operation(clock.dateAsString(), amount));
    }

    public void addWithdraw(int amount) {
        operations.add(new Operation(clock.dateAsString(), -amount));
    }

    public List<Operation> allOperations() {
        return operations;
    }
}
