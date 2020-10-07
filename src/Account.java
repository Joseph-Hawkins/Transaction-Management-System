/**
 * This is an abstract class that defines the common features of all account types.
 * @author Joseph Hawkins, Gustavo Garcia
 *
 */
public abstract class Account {
	private Profile holder;
	private double balance;
	private Date dateOpen;
	
	/**
	 * Initialized the account	
	 * @param holder holder of the account
	 * @param balance balance of the account
	 * @param dateOpen date the account was opened
	 */
	public Account(Profile holder, double balance, Date dateOpen) {
		this.holder = holder;
		this.balance = balance;
		this.dateOpen = dateOpen;
	}
	
	/**
	 * Decrease balance by amount
	 * @param amount amount the balance will be decreased by
	 */
	public void debit(double amount) {
		this.balance = this.balance - amount;
	}
	
	/**
	 * Increased balance by amount
	 * @param amount amount the balance will be increased by
	 */
	public void credit(double amount) {
		this.balance = this.balance + amount;
	}
	
	/**
	 * Formats the account information into a string
	 * @return string of account data
	 */
	@Override
	public String toString() {
		String full_name = holder.getFname() + " " + holder.getLname();
		String balance_to_string = "$" + String.valueOf(balance);
		String date_to_string = dateOpen.toString();
		
		return full_name + "* " + balance_to_string + "*" + date_to_string;  
	}
	/**
	 * Calculates the monthly interest of the account
	 * @return
	 */
	public abstract double monthlyInterest();
	
	/**
	 * Returns the monthly fee of the account
	 * @return monthlyFee 
	 */
	public abstract double monthlyFee();
	
	/**
	 * Getter method for balance.
	 * @return
	 */
	
	public double getBalance() {
		return balance;
	}
	
	/**
	 * Setter method for balance
	 * @param balance New balance for the account
	 */
	/*
	public void setBalance(double balance) {
		this.balance = balance;
	}
	*/
	
	/**
	 * Compares two accounts. Returns true if they are equal
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Account) {
			Account item = (Account) obj; // Cast to account item
			
			if ( (this.holder.equals(item.holder)) && (this.balance == item.balance) && (this.dateOpen.equals(item.dateOpen)) ) {
				return true;
			}
		}
		return false; 
	}
	
	/**
	 * Gets date account was opened.
	 * @return openDate the date when account was opened.
	 */
	public Date getDate() {
		return dateOpen;
	}
	
	/**
	 * Gets the profile of the account holder.
	 * @return profile this is info about the account holder.
	 */
	public Profile getHolder() {
		return holder;
	}
}
