
public class Checking extends Account {
	private boolean directDeposit;
	
	/**
	 * Initializes a Checking account
	 * @param holder holder of the account
	 * @param balance Balance of the account
	 * @param dateOpen Date the account was opened
	 * @param directDeposit Boolean statement for whether they have direct deposit
	 */
	public Checking(Profile holder, double balance, Date dateOpen, boolean directDeposit) {
		super(holder,balance,dateOpen);
		this.directDeposit = directDeposit;
	}
	@Override
	/**
	 * Returns the total monthly interest for the account
	 */
	public double monthlyInterest() {
		double monthly_interest_rate = 0.05 / 12;
		return monthly_interest_rate * getBalance();
	}
	
	@Override
	/**
	 * Returns the monthly fee for the account
	 */
	public double monthlyFee() {
		if ( getBalance() >= 1500 || directDeposit == true) {
			return 0;
		}
		return 25;
	}
}