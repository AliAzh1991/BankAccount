package com.bank.account.kata.repository;

import com.bank.account.kata.model.Operation;
import com.bank.account.kata.utils.Clock;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class OperationRepositoyTest {

    public static final String WANTED_DTAE = "10/09/2021";
    @Mock
    private Clock clock;

    private OperationRepository operationRepository;

    @Before
    public void initialise() {
        operationRepository = new OperationRepository(clock);
        BDDMockito.given(clock.dateAsString()).willReturn(WANTED_DTAE);

    }

    @Test
    public void should_create_deposit_operation() {
        operationRepository.addDeposit(100);

        List<Operation> operations = operationRepository.allOperations();

        MatcherAssert.assertThat(operations.size(), Matchers.is(1));
        MatcherAssert.assertThat(operations.get(0), Matchers.is(operation(WANTED_DTAE, 100)));
    }

    @Test
    public void should_create_withdraw_operation() {
        operationRepository.addWithdraw(100);

        List<Operation> operations = operationRepository.allOperations();

        MatcherAssert.assertThat(operations.size(), Matchers.is(1));
        MatcherAssert.assertThat(operations.get(0), Matchers.is(operation(WANTED_DTAE, -100)));
    }

    private Operation operation(String date, int amount) {
        return new Operation(date, amount);
    }
}
