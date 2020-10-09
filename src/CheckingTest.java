import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CheckingTest {

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
	void testMonthlyInterest() {
		Profile gus = new Profile("Gustavo", "Garcia");
		Profile joe = new Profile("Joseph", "Hawkins");
		Date today = new Date("10/8/2020");
		
		Checking c1 = new Checking(gus, 1600, today, true);
		Checking c2 = new Checking(gus, 1500, today, true);
		Checking c3 = new Checking(gus, 1400, today, true);
		Checking c4 = new Checking(gus, 0, today, true);

		Checking c5 = new Checking(joe, 1600, today, false);
		Checking c6 = new Checking(joe, 1500, today, false);
		Checking c7 = new Checking(joe, 1400, today, false);
		Checking c8 = new Checking(joe, 0, today, false);
		
		String[] s = new String[]{"0.00", "0.07", "0.06", "0.06", "0.00", "0.07", "0.06", "0.06", "0.00"};
		
		assertEquals(s[1], String.format("%.2f", c1.monthlyInterest()));
		assertEquals(s[2], String.format("%.2f", c2.monthlyInterest()));
		assertEquals(s[3], String.format("%.2f", c3.monthlyInterest()));
		assertEquals(s[4], String.format("%.2f", c4.monthlyInterest()));
		
		assertEquals(s[5], String.format("%.2f", c5.monthlyInterest()));
		assertEquals(s[6], String.format("%.2f", c6.monthlyInterest()));
		assertEquals(s[7], String.format("%.2f", c7.monthlyInterest()));
		assertEquals(s[8], String.format("%.2f", c8.monthlyInterest()));
	}

	@Test
	void testMonthlyFee() {
		Profile gus = new Profile("Gustavo", "Garcia");
		Profile joe = new Profile("Joseph", "Hawkins");
		Date today = new Date("10/8/2020");
		
		Checking c1 = new Checking(gus, 1600, today, true);
		Checking c2 = new Checking(gus, 1500, today, true);
		Checking c3 = new Checking(gus, 1400, today, true);
		Checking c4 = new Checking(gus, 0, today, true);

		Checking c5 = new Checking(joe, 1600, today, false);
		Checking c6 = new Checking(joe, 1500, today, false);
		Checking c7 = new Checking(joe, 1400, today, false);
		Checking c8 = new Checking(joe, 0, today, false);
		fail("Not yet implemented");
		
		double[] s = new double[]{0, 0, 0, 0, 0, 0, 25, 25};
		
		assertEquals(s[1], c1.monthlyFee());
		assertEquals(s[2], c2.monthlyFee());
		assertEquals(s[3], c3.monthlyFee());
		assertEquals(s[4], c4.monthlyFee());
		
		assertEquals(s[5], c5.monthlyFee());
		assertEquals(s[6], c6.monthlyFee());
		assertEquals(s[7], c7.monthlyFee());
		assertEquals(s[8], c8.monthlyFee());

		//charge a fee, don't charge fee
		//direct deposit on/off
	}

}
