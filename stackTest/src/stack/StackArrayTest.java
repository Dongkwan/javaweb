package stack;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StackArrayTest {

    protected StackArray myStack;

    @Before
    public void makeMyStack() {
    	System.out.println("Making my stack...");
    	myStack = new StackArray(3);
    }
	
	@Test
	public void testPush() {
        System.out.println("push");
        myStack.push(-17);
        assertEquals( myStack.topEl(), -17);
    }

	@Test
	public void testPop() {
        System.out.println("pop");
        myStack.push( 1 );
        assertEquals( 1, myStack.pop() );	
    }

	@Test
	public void testTopEl() {
        System.out.println("topEl");
        myStack.push( 1 );
        assertEquals( 1, myStack.topEl() );	
    }

	@Test
	public void testClear() {
        System.out.println("clear");
        myStack.clear();
        assertTrue( myStack.isEmpty() );	
	}

	@Test
	public void testIsEmpty() {
        System.out.println("isEmpty");
        myStack.push( 1 );
        assertFalse( myStack.isEmpty() );
	}
}
