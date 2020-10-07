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
	
	@Override
	/**
	 * Formats the account information
	 */
	public String toString() {
		return "";
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
	 * Gets openDate
	 * @return returns openDate
	 */
	public Date getDate() {
		return dateOpen;
	}
	
	public Profile getHolder() {
		return holder;
	}
}
