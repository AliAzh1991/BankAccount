package com.bank.account.kata;

import com.bank.account.kata.model.Account;
import com.bank.account.kata.model.Console;
import com.bank.account.kata.repository.OperationRepository;
import com.bank.account.kata.utils.Clock;
import com.bank.account.kata.utils.OperationPrinter;

public class KataApplication {

	public static void main(String[] args) {
		Clock clock = new Clock();
		OperationRepository operationRepository = new OperationRepository(clock);
		Console console = new Console();
		OperationPrinter operationPrinter = new OperationPrinter(console);
		Account account = new Account(operationRepository, operationPrinter);

		account.deposit(2000);
		account.withdraw(500);
		account.withdraw(1000);
		account.deposit(700);

		account.printStatement();
	}

}
