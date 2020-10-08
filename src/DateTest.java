import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DateTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testIsValid() {
		//Leap year test
		Date d1 = new Date(1901, 7, 31);//months with 31 days non leap year
		Date d2 = new Date(1904, 7, 31);//months with 31 days leap year
		Date d3 = new Date(1901, 6, 30);//months with 30 days non leap year
		Date d4 = new Date(1904, 6, 30);//months with 30 days leap year
		Date d5 = new Date(1901, 2, 28);//months with 28 or 29 days non leap years
		Date d6 = new Date(1904, 2, 28);//months with 28 or 29 days leap years

		//Check valid days
		assertTrue(d1.isValid()); //expected output is true
		assertTrue(d2.isValid()); //expected output is true
		assertTrue(d3.isValid()); //expected output is true
		assertTrue(d4.isValid()); //expected output is true
		assertTrue(d5.isValid()); //expected output is true
		assertTrue(d6.isValid()); //expected output is true

		//Check valid months
		Date d7 = new Date(1994, 0, 28);
		Date d8 = new Date(1901, -1, 20);
		Date d9 = new Date(1901, 13, 18);	
		assertFalse(d7.isValid()); //expected output is false
		assertFalse(d8.isValid()); //expected output is false
		assertFalse(d9.isValid()); //expected output is false
		
		//Valid months
		Date d10 = new Date(1901, 1, 31); //months with 31 days
		Date d11 = new Date(1901, 4, 30); //months with 30 days
		assertTrue(d10.isValid()); //expected output is true
		assertTrue(d11.isValid()); //expected output is true

		//Check Valid Year
		Date d13 = new Date(0, 7, 4); // zero year
		Date d14 = new Date(-1901, 7, 4); // negative year
		assertFalse(d13.isValid()); //expected output is false
		assertFalse(d14.isValid()); //expected output is false

		//Edge cases
		Date d15 = new Date(2000, 2, 29);//months with 31 days non leap year
		Date d16 = new Date(1900, 7, 29);//months with 31 days non leap year
		

		assertTrue(d15.isValid()); //expected output is true
		assertFalse(d16.isValid()); //expected output is false

	}

}
