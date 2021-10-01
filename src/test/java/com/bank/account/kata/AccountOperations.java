package com.bank.account.kata;

import com.bank.account.kata.model.Account;
import com.bank.account.kata.repository.OperationRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AccountOperations {

    @Mock
    private OperationRepository operationRepository;

    private Account account;

    @Before
    public void initialise() {
        account = new Account(operationRepository);
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
}
