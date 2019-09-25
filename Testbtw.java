package oefenopdracht5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.math.RoundingMode;

class Testbtw {

	@Test
	void test() {
		Btw test = new Btw();
		test.setPrijs(0.99);
		double output = test.getPrijsInclusiefBtw();
		System.out.print(output);
		assertEquals(0.20, output);    
//		BigDecimal bd = new BigDecimal(output).setScale(2, RoundingMode.HALF_UP);
//        double newInput = bd.doubleValue();
//        System.out.print("Prijs inclusief btw: " + newInput);
	}

}
