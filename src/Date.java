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
	 * @param date This is an object that encapsulates month/day/year 
	 * @return -1 if this.date comes before date, 0 if same date, 1 if this.date comes after date.
	 */
	@Override
	public int compareTo(Date date) {
		//different years
		if ( this.year < date.year ) {
			return -1;
		}
		else if(this.year > date.year) {
			return 1;
		}
		
		//different months same year
		if(this.month < date.month) {
			return -1;
		}
		else if(this.month > date.month) {
			return 1;
		}
		
		//different day same month and year
		if(this.day < date.day) {
			return -1;
		}
		else if(this.day > date.day) {
			return 1;
		}
		
		//same month/day/year
		if ( (this.year == date.year) && (this.month == date.month) && (this.day == date.day) ) {
			return 0;
		}
		
		//something is wrong
		return 2;
	}
	
	/**
	 * Gives a string version of the date.
	 * @return str in format mm/dd/yyyy
	 */
	@Override
	public String toString() {
		return this.month + "/" + this.day + "/" + this.year;
	}
	
	/**
	 * Checks if a date is valid.
	 * out of range only i think
	 * @return true if date is valid, false otherwise.
	 */
	public boolean isValid() {
		return true;
	}
	
	
	public static void main (String[] args) {
		Date date1 = new Date(2002, 10, 24);
		
		Date date2 = new Date(2020, 9, 24);

		System.out.println(date1.compareTo(date2));
		
		
	}
}