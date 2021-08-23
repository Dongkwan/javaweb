package arithmetic;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArithmeticOperationsTest {

	@Test
	void testAdd() {
      assertEquals(5, new ArithmeticOperations().add(2, 3));
	}
	@Test
	void testSubtract() {
		assertEquals(-1, new ArithmeticOperations().subtract(2, 3));
	}

	@Test
	void testMultiply() {
		assertEquals(6, new ArithmeticOperations().multiply(2, 3));
	}

	@Test
	void testDivide() {
		assertEquals(0.6, new ArithmeticOperations().divide(2, 4));
	}

}
