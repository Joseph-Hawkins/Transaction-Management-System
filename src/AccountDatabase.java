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
		int n = accounts.length;
		
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
		int n = accounts.length;
		
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
		int n = accounts.length;
		for (int i = 0; i < n; i++) {
			String temp = accounts[i].toString();
			double monthly_interest = 0;
			double monthly_fee = 0;
			if ( accounts[i] instanceof MoneyMarket ) {
				MoneyMarket item = (MoneyMarket) accounts[i];
				monthly_interest = item.monthlyInterest();
				monthly_fee = item.monthlyFee();
			}
			if ( accounts[i] instanceof Checking ) {
				Checking item = (Checking) accounts[i];
				monthly_interest = item.monthlyInterest();
				monthly_fee = item.monthlyFee();
			}
			if ( accounts[i] instanceof Savings ) {
				Savings item = (Savings) accounts[i];
				monthly_interest = item.monthlyInterest();
				monthly_fee = item.monthlyFee();
			}
			
		}
	}
	public static void main (String[] args) {
		Profile john_cena = new Profile("John","Cena");
		Date open_date = new Date(2020,10,6);
		
	    Checking item = new Checking(john_cena,500.00,open_date,false);
		AccountDatabase database = new AccountDatabase();
		database.add(item);
		database.deposit(item,10000000.00);
		database.withdrawal(item,250.00);
		database.withdrawal(item,250.00);
		database.withdrawal(item,250.00);
		
		Account temp = database.accounts[0];
		//System.out.print(temp.getBalance());
		//database[0].getDate();
		//System.out.println(((MoneyMarket)item).getWithdrawals());
		System.out.println("Cena".compareTo("John")); //neg
		System.out.println("John".compareTo("John")); //0
		System.out.println("John".compareTo("Cena")); //pos
		//System.out.println("I work");
	}
}