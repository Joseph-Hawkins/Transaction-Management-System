/**
 * Class that encapsulates the customers first and last name.
 * 
 * @author Joseph Hawkins, Gustavo Garcia
 *
 */
public class Profile {
	private String fname;
	private String lname;
	
	/**
	 * Initializes profile
	 * @param fname first name of the user
	 * @param lname last name of the user
	 */
	public Profile(String fname, String lname) {
		this.fname = fname;
		this.lname = lname;
	}
	
	/**
	 * Getter method for first name
	 * @return fname First name in string form.
	 */
	
	public String getFname() {
		return fname;
	}
	
	/**
	 * Getter method for last name
	 * @return lname Last name in string form.
	 */
	public String getLname() {
		return lname;
	}
	
}