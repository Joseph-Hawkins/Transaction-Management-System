public class Date implements Comparable<Date> {
	private int year;
	private int month;
	private int day;
	
	public Date(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}

	@Override
	public int compareTo(Date o) {
		// TODO Auto-generated method stub
		return 0;
	}
}