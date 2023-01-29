package model.entities;

import java.util.ArrayList;

import model.exceptions.AccountException;

public class AccountList {

	private ArrayList<Account> list;

	public AccountList() {
		this.list = new ArrayList<>();
	}

	public ArrayList<Account> getList() {
		return list;
	}

	public void setList(ArrayList<Account> list) {
		this.list = list;
	}

	public void addAccountToList(Account account) {
		this.list.add(account);
	}

	public Account filterByNumber(int number) {
		for (Account a : this.list) {
			if (a.getNumber() == number) {
				return a;
			}
		}
		throw new AccountException("Account does not exists.");
	}
	
	  @Override
	   public String toString() {
	        return ("All account values: "+ this.getList().toString());
	   }


	
}
