/**
 * Date encapsulates year, month, day integer data fields.
 * @author Joseph Hawkins, Gustavo Garcia
 *
 */
public class Date implements Comparable<Date> {
	private int year;
	private int month;
	private int day;
	
	/**
	 * Constructor class for date
	 * @param year Year account was made
	 * @param month Month account was made
	 * @param day Day account was made.
	 */
	public Date(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}

	/**
	 * Compares two dates.
	 * @param o Date object 
	 * @return 
	 */
	@Override
	public int compareTo(Date o) {
		if ( this.year > o.year ) {
			return 0;
		}
		return 0;
	}
	
	
}