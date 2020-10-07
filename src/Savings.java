/**
 * Savings account, subclass of Account.
 * @author Joseph Hawkins, Gustavo Garcia
 *
 */
public class Savings extends Account {
	private boolean isLoyal;
	
	/**
	 * Initializes a Savings account 
	 * @param holder Owner of the account
	 * @param balance Balance of the account
	 * @param dateOpen Date the account was opened
	 * @param isLoyal Boolean statement for whether they are a loyal customer
	 */
	public Savings(Profile holder, double balance, Date dateOpen, boolean isLoyal) {
		super(holder,balance,dateOpen);
		this.isLoyal = isLoyal;
	}
	
	
	/**
	 * Returns the total monthly interest for the account
	 */
	@Override
	public double monthlyInterest() {
		double monthly_interest_rate = 0;
		if ( this.isLoyal == true ) {	
			monthly_interest_rate = 0.35 / 12;
		} else {
			monthly_interest_rate = 0.25 / 12;
		}
		return monthly_interest_rate * getBalance();
	}
	
	
	/**
	 * Returns the monthly fee for the account
	 */
	@Override
	public double monthlyFee() {
		if ( getBalance() >= 300 ) {
			return 0;
		}
		return 5;
	}
}