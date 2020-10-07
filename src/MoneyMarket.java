/**
 * This is a specific type of .
 * @author Joseph Hawkins, Gustavo Garcia
 *
 */
public class MoneyMarket extends Account {
	private int withdrawals;
	
	/**
	 * Initializes a money market account
	 * @param holder holder of the account
	 * @param balance balance of the account
	 * @param dateOpen date the account was opened
	 */
	public MoneyMarket(Profile holder, double balance, Date dateOpen) {
		super(holder,balance,dateOpen);
		withdrawals = 0;
	}
	
	/**
	 * Returns the total monthly interest for the account
	 */
	@Override
	public double monthlyInterest() {
		double monthly_interest_rate = 0.65 / 12;
		return monthly_interest_rate * getBalance();
	}
	
	/**
	 * Returns the monthly fee for the account
	 */
	@Override
	public double monthlyFee() {
		if ( getBalance() >= 2500 && withdrawals <= 6) {
			return 0;
		}
		return 12;
	}
	
	/**
	 * Sets the number of withdrawals
	 * @param withdrawals
	 */
	public void setWithdrawals(int withdrawals) {
		this.withdrawals = withdrawals;
	}
	
	/**
	 * Returns withdrawals
	 * @return withdrawals This 
	 */
	public int getWithdrawals() {
		return withdrawals;
	}
}