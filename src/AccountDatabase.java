/**
 * This is an array-based container class. 
 * The array holds different instances in Checking, Savings, MoneyMarket
 * 
 * @author Joseph Hawkins, Gustavo Garcia
 *
 */
public class AccountDatabase {
	private Account[] accounts;
	private int size;
	
	/**
	 * Constructor for AccountDatabase, initilizes to size 5
	 */
	public AccountDatabase() {
		this.accounts = new Account [5];
		this.size = 0;
	}
	
	/**
	 * Checks to see if account exists
	 * @param account The account object
	 * @return 1 if it exists, -1 otherwise
	 */
	private int find(Account account) {
		
		for(int i = 0; i < size; i++) {
			if( accounts[i].equals(account) ) {
				return i; //Found
			}
		}
		return -1; //Not found
	}
	
	/**
	 * Methods to grow the account list by 5
	 */
	private void grow() {
		Account[] tempAccounts = new Account[size + 5];
		
		for (int i = 0; i < size; i++) {
			Account t = accounts[i];
			tempAccounts[i] = t;
		}
		
		accounts = tempAccounts;
	} 
	
	/**
	 * Adds a new account to the database.
	 * @param item New account to be added
	 */
	public boolean add(Account item) {
		
		if ( find(item) != -1 ) { //Has to be the first of its kind
			return false;
		}
		
		if( size < accounts.length ) {
			accounts[size] = item;
			size++;
			System.out.println("Account opened and added to the database.");
		} else {
		
			grow();
			add(item);
		}
		
		return true;	
	}
	
	/**
	 * Removes the accounts from the database
	 * @param item Account to be removed
	 * @return true if removed, false otherwise
	 */
	public boolean remove(Account item) {
		int accountIndex = find(item);
		
		if( accountIndex == -1 ) {
			return false;
		}
		
		accounts[accountIndex] = accounts[size - 1];
		accounts[size - 1] = null;
		size --;
		return true;
	}
	
	/**
	 * Increases account balance by amount
	 * @param account Account to be altered
	 * @param amount Amount the balance will be increased by
	 * @return Returns true if balance is increased, false otherwise
	 */
	public boolean deposit(Account account, double amount) {
		int accountIndex = find(account);
		
		if( accountIndex == -1 ) {
			return false;
		}
		
		account.credit(amount);
		
		return true;
	}
	
	/**
	 * Removes amount from account balance
	 * @param account Account to be altered
	 * @param amount Amount to be removed
	 * @return -1 if account does not exist, 0 if success, 1 if insufficient finds
	 */
	public int withdrawal(Account account, double amount) {
		int accountIndex = find(account);
		
		if ( accountIndex == -1 ) {
			return -1;
		}
		
		if ( account.getBalance() < amount ) {
			return 1;
		}
		
		account.debit(amount);
		
		if ( account instanceof MoneyMarket ) {
			MoneyMarket item = (MoneyMarket) account;
			item.setWithdrawals(item.getWithdrawals() + 1);
		}
		
		return 0;
	}
	
	/**
	 * Sorts the accounts by the date they were opened in ascending order.
	 * 
	 */
	private void sortByDateOpen() {
		int n = size;
		
		for (int i = 0; i < n - 1; i++) {
			int earliest_date = i;
			
			for (int j = i+1; j < n; j++) {
				if ( (accounts[j].getDate() ).compareTo( accounts[earliest_date].getDate() ) < 0 ) {
					earliest_date = j;
				}
			}
			
			Account temp = accounts[earliest_date];
			accounts[earliest_date] = accounts[i];
			accounts[i] = temp;
		}
	}
	
	/**
	 * Sorts accounts by the last name
	 */
	private void sortByLastName() {
		int n = size;
		
		for (int i = 0; i < n - 1; i++) {
			int earliest_name = i;
			for (int j = i + 1; j < n; j++) {
				if ( (accounts[j].getHolder().getLname() )
						.compareTo( accounts[earliest_name].getHolder().getLname() ) < 0 ) {
					earliest_name = j;
				}
			}
			
			Account temp = accounts[earliest_name];
			accounts[earliest_name] = accounts[i];
			accounts[i] = temp;
			
		}
	}
	
	/**
	 * Sorts by the date they were opened. Then prints the accounts statements
	 */
	public void printByDateOpen() {
		sortByDateOpen();
		System.out.print("--Printing statements by date opened--");
		for (int i = 0; i < size; i++) {
			String account_info = accounts[i].toString();
			String header = "";
			String interest = "";
			String fee = "";
			String new_balance = "";
			
			if ( accounts[i] instanceof MoneyMarket ) {
				MoneyMarket item = (MoneyMarket) accounts[i]; 
				header = "*Money Market*" + account_info;
				
				if (item.getWithdrawals() == 1) {
					header = header + "*1 withdrawal*";
				} else {
					header = header + "*" + Integer.toString(item.getWithdrawals()) + " withdrawals*";
				}
				
				interest = "-interest: $ " + String.format("%.2f", item.monthlyInterest());
				fee = "-fee: $ " + String.format("%.2f", item.monthlyFee());
				accounts[i].debit(item.monthlyInterest() + item.monthlyFee());
				new_balance = "-new balance: $ " + String.format("%.2f", accounts[i].getBalance());
				
			}
			
			if ( accounts[i] instanceof Checking ) {
				Checking item = (Checking) accounts[i];
				header = "*Checking*" + account_info;
				
				if (item.getDirectDeposit() == true) {
					header = header + "*direct deposit account*";
				}
				
				interest = "-interest: $ " + String.format("%.2f", item.monthlyInterest());
				fee = "-fee: $ " + String.format("%.2f", item.monthlyFee());
				accounts[i].debit(item.monthlyInterest() + item.monthlyFee());
				new_balance = "-new balance: $ " + String.format("%.2f", accounts[i].getBalance());
				
			}
			
			if ( accounts[i] instanceof Savings ) {
				Savings item = (Savings) accounts[i];
				header = "*Savings*" + account_info;
				
				if (item.getLoyalty() == true) {
					header = header + "*special Savings account*";
				}
				
				interest = "-interest: $ " + String.format("%.2f", item.monthlyInterest());
				fee = "-fee: $ " + String.format("%.2f", item.monthlyFee());
				accounts[i].credit(item.monthlyInterest());
				new_balance = "-new balance: $ " + String.format("%.2f", accounts[i].getBalance());
			}
			System.out.println('\n');
			System.out.println(header);
			System.out.println(interest);
			System.out.println(fee);
			System.out.print(new_balance);
		}
		System.out.println("");
		System.out.print("--end of printing--");
	}
	
	/**
	 * Prints accounts sorted by last name
	 */
	public void printByLastName() {
		sortByLastName();
		System.out.print("--Printing statements by last name--");
		for (int i = 0; i < size; i++) {
			String account_info = accounts[i].toString();
			String header = "";
			String interest = "";
			String fee = "";
			String new_balance = "";
			
			if ( accounts[i] instanceof MoneyMarket ) {
				MoneyMarket item = (MoneyMarket) accounts[i]; 
				header = "*Money Market*" + account_info;
				
				if (item.getWithdrawals() == 1) {
					header = header + "*1 withdrawal*";
				} else {
					header = header + "*" + Integer.toString(item.getWithdrawals()) + " withdrawals*";
				}
				
				interest = "-interest: $ " + String.format("%.2f", item.monthlyInterest());
				fee = "-fee: $ " + String.format("%.2f", item.monthlyFee());
				accounts[i].debit(item.monthlyInterest() + item.monthlyFee());
				new_balance = "-new balance: $ " + String.format("%.2f", accounts[i].getBalance());
				
			}
			
			if ( accounts[i] instanceof Checking ) {
				Checking item = (Checking) accounts[i];
				header = "*Checking*" + account_info;
				
				if (item.getDirectDeposit() == true) {
					header = header + "*direct deposit account*";
				}
				
				interest = "-interest: $ " + String.format("%.2f", item.monthlyInterest());
				fee = "-fee: $ " + String.format("%.2f", item.monthlyFee());
				accounts[i].debit(item.monthlyInterest() + item.monthlyFee());
				new_balance = "-new balance: $ " + String.format("%.2f", accounts[i].getBalance());
				
			}
			
			if ( accounts[i] instanceof Savings ) {
				Savings item = (Savings) accounts[i];
				header = "*Savings*" + account_info;
				
				if (item.getLoyalty() == true) {
					header = header + "*special Savings account*";
				}
				
				interest = "-interest: $ " + String.format("%.2f", item.monthlyInterest());
				fee = "-fee: $ " + String.format("%.2f", item.monthlyFee());
				accounts[i].credit(item.monthlyInterest());
				new_balance = "-new balance: $ " + String.format("%.2f", accounts[i].getBalance());
			}
			System.out.println('\n');
			System.out.println(header);
			System.out.println(interest);
			System.out.println(fee);
			System.out.print(new_balance);
		}
		System.out.println("");
		System.out.print("--end of printing--");
	}
	
	/**
	 * Prints all the accounts
	 */
	public void printAccounts() {
		System.out.println("--Listing accounts in the database--");
		for (int i = 0; i < size; i++) {
			
			if ( accounts[i] instanceof Checking ) {
				Checking item = (Checking) accounts[i];
				System.out.print("*Checking*" + accounts[i].toString());
				if (item.getDirectDeposit() == true) {
					System.out.print("*direct deposit account*");
				}
				System.out.println("");
			}
			
			if ( accounts[i] instanceof Savings ) {
				Savings item = (Savings) accounts[i];
				System.out.print("*Savings*" + accounts[i].toString());
				if (item.getLoyalty() == true) {
					System.out.print("*special Savings accounts*");
				} 	
				System.out.println("");
			}
			
			if ( accounts[i] instanceof MoneyMarket ) {
				MoneyMarket item = (MoneyMarket) accounts[i];
				System.out.print("*Money Market*" + accounts[i].toString());
				if (item.getWithdrawals() == 1) {
					System.out.print("*1 withdrawal*");
				} else {
					System.out.print("*" + Integer.toString(item.getWithdrawals()) + " withdrawals*");
				}
				System.out.println("");
			}
		}
		System.out.print("--end of listing--");
	}
	

	public static void main (String[] args) {
		
		Profile john_cena = new Profile("John","Cena");
		Profile jeff_hardy = new Profile("Jeff","Hardy");
		Profile randy_orton = new Profile("Randy","Orton");
		Date open_date = new Date(2018,10,9);
		Date open_date2 = new Date(2000,10,7);
		Date open_date3 = new Date(2020,10,8);
		
	    Checking item = new Checking(john_cena,500.00,open_date,false);
	    Savings item2 = new Savings(jeff_hardy,200.00,open_date2,true);
	    MoneyMarket item3 = new MoneyMarket(randy_orton,700.00,open_date3);
		AccountDatabase database = new AccountDatabase();
		database.add(item);
		database.add(item2);
		database.add(item3);
		

		
        database.printAccounts();
	}
}