package junitEX.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import junitTarget.TargetClass;

public class TargetClassTest {

	private TargetClass classUnderTest;
	
	@Rule
	public TestName testName = new TestName();

	@Before
	public void setup() {
		classUnderTest = new TargetClass();
		System.out.println("Start " + testName.getMethodName());
	}

	@Test
	public void test_doubleANumber() {
		
		//Test the doubleANumber() method
		
	}

	@Test
	public void test_returnBooleanFoo_false() {
		
		//Test the returnABoolean() method with assertFalse
	}

	@Test
	public void test_returnBooleanFoo_true() {
		
		//Test the returnABoolean() method with assertTrue

	}

	@Test(expected = IllegalArgumentException.class)
	public void test_voidFoo_exception() throws IllegalAccessException {

		//Test the voidFoo() method
		
	}
	
	@Test(timeout = 1)
	public void test_timeout() {
		
		//Test the doubleANumber()		
		
	}
}
