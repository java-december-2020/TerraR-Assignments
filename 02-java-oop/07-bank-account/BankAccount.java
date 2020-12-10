package bankaccount;

import java.util.Random;

public class BankAccount {
	// =======================================================================
	// Instance variables
	// =======================================================================	
	private String accountNumber;
	private double checkingBalance;
	private double savingsBalance;

	public static int numberOfAccounts = 0;
	public static double totalAmountMoney = 0;

	// =======================================================================
	// Constructor
	// =======================================================================		
	public BankAccount() {
		this.accountNumber = randomNumberGenerator();
		this.checkingBalance = 0;
		this.savingsBalance = 0;
		numberOfAccounts++;
	}

	// =======================================================================
	// Getters and Setters
	// =======================================================================		
	public String getAccountNumber() {
		return accountNumber;
	}

	public double getCheckingBalance() {
		return checkingBalance;
	}

	public void setCheckingBalance(double checkingBalance) {
		this.checkingBalance = checkingBalance;
	}

	public double getSavingsBalance() {
		return savingsBalance;
	}

	public void setSavingsBalance(double savingsBalance) {
		this.savingsBalance = savingsBalance;
	}

	public double getTotalMoney() {
		return totalAmountMoney;
	}

	public void setTotalMoney(double totalMoney) {
		totalAmountMoney = totalMoney;
	}
	
	// =======================================================================
	// Methods
	// =======================================================================		

	// Generate random 10 digit number
	private String randomNumberGenerator() {
		Random randomNum = new Random();
		int num = 0;
		int length = 0;
		while (length < 10) {
			int rand = randomNum.nextInt();
			num = +rand;
			length = (int) (Math.log10(num) + 1);
		}
		System.out.printf("%nAccount number created: %s", String.valueOf(num));
		return String.valueOf(num);
	}

	// Deposit to checking or savings
	public void deposit(double depositAmt, String accountType) {
		if( accountType != "checking" && accountType != "savings" ) {
			System.out.printf("%nAccount type invalid ");
			return;
		}		
		if ( accountType == "checking" ) {
			setCheckingBalance(getCheckingBalance() + depositAmt);		
		} else if ( accountType == "savings" ) {
				setSavingsBalance(getSavingsBalance() + depositAmt);
		}
		setTotalMoney(getTotalMoney() + depositAmt);
	}

	// Withdrawal from checking or savings
	public void withdraw(double withdrawalAmt, String accountType) {
		if( accountType != "checking" && accountType != "savings" ) {
			System.out.printf("%nAccount type invalid ");
			return;
		}
		if( withdrawalAmt <=0 ) {
			System.out.printf("%nWithdrawal amount invalid ");
			return;
		}
		if ( accountType == "checking" ) {
			if( getCheckingBalance() <= 0 || withdrawalAmt > getCheckingBalance() ) {
				System.out.printf("%nInsufficient funds");
				return;
			}
			setCheckingBalance(getCheckingBalance() - withdrawalAmt);
		} else if ( accountType == "savings" ) {
			if( getSavingsBalance() <= 0 || withdrawalAmt > getSavingsBalance() ) {
				System.out.printf("%nInsufficient funds");
				return;
			}
				setSavingsBalance(getSavingsBalance() - withdrawalAmt);
		}
		setTotalMoney(getTotalMoney() - withdrawalAmt);
	}

	// Print total balance
	public static void printTotalMoney() {
		System.out.printf("%nTotal number of accounts: %d", numberOfAccounts );
		System.out.printf("%nTotal amount of money in every account: %f", totalAmountMoney );
	}



}
