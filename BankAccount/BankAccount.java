/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment;

import java.util.Scanner;

class CustomException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	CustomException() {
	}

	CustomException(String s) {
		super(s);
	}
}

class BankOps {
	static long MINIMUM_BALANCE = 500;
	public static int index = 0;
	public static int flag = 0;
	public static int success = 0;
	String accName;
	String accNum;
	int pin;
	long balance;

	BankOps() {
	}

	BankOps(String accName, String accNum, int pin, long balance) {
		this.accName = accName;
		this.accNum = accNum;
		this.pin = pin;
		this.balance = balance;
	}

	void Deposit(long amount, BankOps arr[]) {
		arr[BankOps.index].balance = arr[BankOps.index].balance + amount;
		System.out.print("The balance for the account number " + arr[BankOps.index].accNum + " is "
				+ arr[BankOps.index].balance);
		System.out.println("\nThankyou");
	}

	void Withdrawal(BankOps arr[]) {
		System.out.println("Enter the amount you want to withdraw:");
		Scanner obj = new Scanner(System.in);
		long amount = obj.nextLong();
		try {

			min_balance(amount);
		} catch (Exception e) {

			System.out.println(e);
			obj.close();
		}

		arr[BankOps.index].balance = arr[BankOps.index].balance - amount;
		System.out.println("New Balance : " + arr[BankOps.index].balance);

		if (arr[BankOps.index].balance < 1000) {

			System.out.println("Insufficient balance: DO YOU WANT TO Deposit?(Y/N)");
			String choice = obj.next();

			if (choice.equals("Y")) {

				System.out.println("Enter amount to Deposit :");
				Deposit(obj.nextLong(), arr);
				obj.close();
			} else {

				System.out.println("Thankyou");
				obj.close();
			}
		}

		System.out.println("\nThank you");
	}

	void AccValidate(String s, BankOps arr[]) throws CustomException {
		if (s.length() != 12)
			throw new CustomException("Not Valid Account Number");

		for (int i = 0; i < 3; i++) {
			if (arr[i].accNum.compareTo(s) == 0) {
				BankOps.flag = 1;
				BankOps.index = i;
			}
		}
		if (flag == 0)
			throw new CustomException("Account Number not found");
	}

	void PinValidate(int num, BankOps arr[]) throws CustomException {
		int pin_length = Integer.toString(num).length();
		if (pin_length != 4)
			throw new CustomException("pin should be of length 4");
		if (pin_length > 4)
			throw new CustomException("pin can't be more than 4");
		if (pin_length < 4)
			throw new CustomException("pin can't be less than 4");
		if (num != (int) num)
			throw new CustomException("Type mismatch");
		if (arr[BankOps.index].pin == num) {
			System.out.println("Sucess login");
			BankOps.success = 1;
		} else
			throw new CustomException("Mismatched Details");
	}

	void min_balance(long num) throws CustomException {
		if (num < BankOps.MINIMUM_BALANCE)
			throw new CustomException("Less than minimum balance. Can't withdraw");
	}
}

public class BankAccount {
	public static void main(String[] args) {
		BankOps arr[] = new BankOps[3];
		// class object= new class(accName,Account_num,pin,Balance);
		BankOps obj1 = new BankOps("Pawan", "923456789112", 3234, 25000);
		BankOps obj2 = new BankOps("Nabeela", "567456789134", 5134, 1450);
		BankOps obj3 = new BankOps("Venkat", "789456789156", 6334, 5000);
		BankOps call = new BankOps();
		arr[0] = obj1;
		arr[1] = obj2;
		arr[2] = obj3;
		boolean select = true;
		Scanner obj = new Scanner(System.in);
		while (select) {
			System.out.print("\nEnter Account Number:");
			String cur = obj.next();
			try {
				call.AccValidate(cur, arr);
				select = false;
			} catch (Exception e) {
				System.out.print(e);
				select = true;
			}
		}
		select = true;
		while (select) {
			if (BankOps.flag == 1) {
				System.out.print("\n\nEnter pin:");
				int intCur = obj.nextInt();
				try {
					call.PinValidate(intCur, arr);
					select = false;
				} catch (Exception e) {
					System.out.print(e);
					select = true;
				}
			} else {
				obj.close();
			}
		}

		if (BankOps.success == 1) {
			System.out.println("\n\nEnter choice:");
			System.out.println("1.Deposit:");
			System.out.println("2.Withdrawal:");
			int choice = obj.nextInt();
			switch (choice) {
			case 1:
				System.out.print("Enter amount to Deposit :");
				call.Deposit(obj.nextLong(), arr);
				break;
			case 2:
				call.Withdrawal(arr);
				break;
			default:
				System.out.print("\nWrong choice entered");
				break;
			}
		}

	}
}
