package bankaccount;

public class BankAccountTest {

	public static void main(String[] args) {
		
		BankAccount account1 = new BankAccount();
		BankAccount account2 = new BankAccount();
		
		account1.deposit(100, "checking");
		account1.deposit(10, "savings");
		account1.withdraw(50, "checking");
		account1.withdraw(1000, "checking");
		account1.withdraw(-50, "checking");
		
		account2.deposit(200, "checking");
		account2.deposit(20, "savings");
		account2.withdraw(5, "savings");
		account2.withdraw(25, "CD");

		BankAccount.printTotalMoney();
	}
}
