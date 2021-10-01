package com.bank.account.kata.utils;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.time.LocalDate;

public class ClockTest {

    @Test
    public void should_return_date_dd_MM_yyyy_in_string_format() {
        Clock clock = new Clock();

        String date = clock.dateAsString();

        MatcherAssert.assertThat(date, Matchers.is("01/10/2021"));
    }

    private static class MockedClock extends Clock {
        @Override
        protected LocalDate today() {
            return LocalDate.of(2021, 10, 1);
        }
    }
}
