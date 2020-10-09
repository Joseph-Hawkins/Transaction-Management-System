import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MoneyMarketTest {

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
		Profile john_cena = new Profile("John","Cena");
        Date open_date = new Date(2018,10,9);;
        MoneyMarket item = new MoneyMarket(john_cena,2504.00,open_date);
        item.debit(1);
        item.debit(1);
        item.debit(1);
        item.debit(1);
        
        assertEquals(0,item.monthlyFee());
        assertEquals("1.35",String.format("%.2f", item.monthlyInterest()));
        item.debit(1000);
        assertEquals(12,item.monthlyFee());
        assertEquals("0.81",String.format("%.2f", item.monthlyInterest()));
        item.debit(500);
        assertEquals(12,item.monthlyFee());
        assertEquals("0.54",String.format("%.2f", item.monthlyInterest()));
        item.credit(1000);
        assertEquals(12,item.monthlyFee());
        assertEquals("1.35",String.format("%.2f", item.monthlyInterest()));
	}

	@Test
	void testMonthlyFee() {
		Profile john_cena = new Profile("John","Cena");
        Date open_date = new Date(2018,10,9);;
        MoneyMarket item = new MoneyMarket(john_cena,2504.00,open_date);
        item.debit(1);
        item.debit(1);
        item.debit(1);
        item.debit(1);

        assertEquals(0,item.monthlyFee());
        item.debit(1000);
        assertEquals(12,item.monthlyFee());
        assertEquals(0.81,item.monthlyInterest());
        item.debit(500);
        assertEquals(12,item.monthlyFee());
        assertEquals(0.54,item.monthlyInterest());
        item.credit(1000);
        assertEquals(12,item.monthlyFee());
        assertEquals(1.35,item.monthlyInterest());
	}

}
