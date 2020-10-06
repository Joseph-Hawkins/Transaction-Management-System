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
	 * @return
	 */
	public abstract double monthlyFee();
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
}
