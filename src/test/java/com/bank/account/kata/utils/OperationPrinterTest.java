package com.bank.account.kata.utils;

import com.bank.account.kata.model.Console;
import com.bank.account.kata.model.Operation;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class OperationPrinterTest {

    private static final List<Operation> NO_OPERATIONS = Collections.emptyList();

    @Mock
    private Console console;

    private OperationPrinter operationPrinter;

    @Before
    public void initialise() {
        operationPrinter = new OperationPrinter(console);
    }

    @Test
    public void should_always_print_the_header() {
        operationPrinter.print(NO_OPERATIONS);
        Mockito.verify(console).printLine("DATE ## AMOUNT ## BALANCE");
    }

    @Test
    public void should_print_operations() {
        List<Operation> operations = operationsContaining(
                deposit("01/09/2021", 1000),
                withdraw("15/09/2021", 100),
                deposit("30/09/2021", 500));

        operationPrinter.print(operations);

        InOrder inOrder = Mockito.inOrder(console);
        inOrder.verify(console).printLine("DATE ## AMOUNT ## BALANCE");
        inOrder.verify(console).printLine("30/09/2021 ## 500,00 ## 1400,00");
        inOrder.verify(console).printLine("15/09/2021 ## -100,00 ## 900,00");
        inOrder.verify(console).printLine("01/09/2021 ## 1000,00 ## 1000,00");
    }

    private List<Operation> operationsContaining(Operation... operations) {
        return Arrays.asList(operations);
    }

    private Operation deposit(String date, int amount) {
        return new Operation(date, amount);
    }

    private Operation withdraw(String date, int amout) {
        return new Operation(date, -amout);
    }
}
