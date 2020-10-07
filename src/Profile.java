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
	 * Getter method for last name
	 * @return
	 */
	public String getLname() {
		return lname;
	}
	
}