package oefenopdracht6;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TestFactuur {

	@Test
	void test() {
		Factuurregel test = new Factuurregel();		
		Product p = new Product();
		
		p.setPrijs(9);
		test.setAantalP(4);
		double output = test.getPrijsInclusiefBtw();		
		assertEquals(5, output);
	}

}
