package com.bank.account.kata.utils;

import com.bank.account.kata.model.Console;
import com.bank.account.kata.model.Operation;

import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class OperationPrinter {

    private static final String HEADER = "DATE ## AMOUNT ## BALANCE";

    private final Console console;
    private final DecimalFormat decimalFormatter = new DecimalFormat("#.00");

    public OperationPrinter(Console console) {
        this.console = console;
    }

    public void print(List<Operation> operations) {
        console.printLine(HEADER);
        printStatementLine(operations);
    }

    private void printStatementLine(List<Operation> operations) {
        AtomicInteger actualBalance = new AtomicInteger(0);
        operations.stream()
                .map(op -> statementLine(op, actualBalance))
                .collect(Collectors.toCollection(LinkedList::new))
                .descendingIterator()
                .forEachRemaining(console::printLine);
    }

    private String statementLine(Operation operation, AtomicInteger actualBalance) {
        return operation.getDate()
                + " ## "
                + decimalFormatter.format(operation.getAmount())
                + " ## "
                + decimalFormatter.format(actualBalance.addAndGet(operation.getAmount()));
    }
}
