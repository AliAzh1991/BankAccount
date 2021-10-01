package com.bank.account.kata;

import com.bank.account.kata.model.Account;
import com.bank.account.kata.model.Operation;
import com.bank.account.kata.repository.OperationRepository;
import com.bank.account.kata.utils.OperationPrinter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class AccountOperations {

    @Mock
    private OperationRepository operationRepository;

    @Mock
    private OperationPrinter operationPrinter;

    private Account account;

    @Before
    public void initialise() {
        account = new Account(operationRepository, operationPrinter);
    }

    @Test
    public void should_save_deposit_operation() {
        account.deposit(100);

        Mockito.verify(operationRepository).addDeposit(100);
    }

    @Test
    public void should_save_withdraw_operation() {
        account.withdraw(100);

        Mockito.verify(operationRepository).addWithdraw(100);
    }

    @Test
    public void should_print_operation() {
        List<Operation> operations = Arrays.asList(new Operation());
        BDDMockito.given(operationRepository.allOperations()).willReturn(operations);

        account.printStatement();

        Mockito.verify(operationPrinter).print(operations);
    }
}
