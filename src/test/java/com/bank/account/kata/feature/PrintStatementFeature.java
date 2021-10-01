package com.bank.account.kata.feature;

import com.bank.account.kata.model.Account;
import com.bank.account.kata.model.Console;
import com.bank.account.kata.repository.OperationRepository;
import com.bank.account.kata.utils.Clock;
import com.bank.account.kata.utils.OperationPrinter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PrintStatementFeature {

    @Mock
    private Console console;

    @Mock
    private Clock clock;

    private Account account;

    @Before
    public void initialise() {
        OperationRepository operationRepository = new OperationRepository(clock);
        OperationPrinter operationPrinter = new OperationPrinter(console);
        account = new Account(operationRepository, operationPrinter);
    }

    @Test
    public void print_statement_containing_all_transactions() {
        BDDMockito.given(clock.dateAsString()).willReturn("01/09/2021", "15/09/2021", "30/09/2021");

        account.deposit(1000);
        account.withdraw(100);
        account.deposit(500);

        account.printStatement();

        InOrder inOrder = Mockito.inOrder(console);
        inOrder.verify(console).printLine("DATE ## AMOUNT ## BALANCE");
        inOrder.verify(console).printLine("30/09/2021 ## 500,00 ## 1400,00");
        inOrder.verify(console).printLine("15/09/2021 ## -100,00 ## 900,00");
        inOrder.verify(console).printLine("01/09/2021 ## 1000,00 ## 1000,00");

    }

}
