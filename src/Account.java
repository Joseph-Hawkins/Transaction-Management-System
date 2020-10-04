public abstract class Account {
	private Profile holder;
	private double balance;
	private Date dateOpen;
	
		
	public Account(Profile holder, double balance, Date dateOpen) {
		this.holder = holder;
		this.balance = balance;
		this.dateOpen = dateOpen;
	}
}