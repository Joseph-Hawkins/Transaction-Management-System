
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
	
	@Override
	/**
	 * Returns the total monthly interest for the account
	 */
	public double monthlyInterest() {
		double monthly_interest_rate = 0.65 / 12;
		return monthly_interest_rate * getBalance();
	}
	
	@Override
	/**
	 * Returns the monthly fee for the account
	 */
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
	 * Returns withdrawls
	 * @return
	 */
	public int getWithdrawals() {
		return withdrawals;
	}
}