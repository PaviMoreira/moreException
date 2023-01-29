package main;

import java.util.InputMismatchException;
import java.util.Scanner;
import model.entities.Account;
import model.entities.AccountList;

public class Main {
	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		Double ammount = 0.0;
		int index = 0;

		Account account = new Account(8021, "Bob Brown", 500.0, 300.0); // Generate generic account

		AccountList list = new AccountList(); // Serves as an account database

		list.addAccountToList(account); // adds accounts to database

		System.out.println("Enter account data: ");
		try {
			int number = ler.nextInt();
			account = list.filterByNumber(number); // Filters the account by the one that has the specific number
			index = list.getList().indexOf(account);

		} catch (InputMismatchException e) {
			System.out.println("Wrong input, accounts can only be a number. Please insert a number.");
		}
		
		try {
			System.out.println("Enter ammount for withdraw: ");
			ammount = ler.nextDouble();
		} catch (InputMismatchException e) {
			System.out.println("Wrong input, ammount needs to be in numbers.");
		}
		
		account.withdraw(ammount);
		list.getList().set(index, account);
		System.out.println("New Balance: " + account.getBalance());
		
		// System.out.println(list.toString());  Checking all accounts

		ler.close();
	}
}
