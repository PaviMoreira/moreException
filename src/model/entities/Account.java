package model.entities;

import model.exceptions.AccountException;

public class Account {
	private int number;
	private String holder;
	private double balance;
	private double withdrawLimit;

	public Account() {

	}

	public Account(int number, String holder, double balance, double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public boolean equals(Object o) {
		if (o instanceof Account) {
			Account p = (Account) o;
			return this.number == p.getNumber();
		} else
			return false;
	}

	public void deposit(Double value) {
		this.balance += value;
	}

	public void withdraw(Double value) {
		validateWithdraw(value);
		this.balance -= value;

	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public double getWithdrawLimit() {
		return withdrawLimit;
	}
	
	private void validateWithdraw(double amount) {
		if (amount > getWithdrawLimit()) {
			throw new AccountException("Withdraw Error: The ammount exceeds the withdraw limmit.");
		} 
		if (amount > getBalance()) {
			throw new AccountException("Withdraw Error: The ammount exceeds the balance.");
		}
	}

	@Override
	public String toString() {
		return "Account number= " + number + ", holder= " + holder + ", balance= " + balance + ", withdrawLimit= "
				+ withdrawLimit + " | ";
	}

}
