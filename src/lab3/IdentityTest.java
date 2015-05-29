package lab3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 
 */

/**
 * @author Jason
 *
 */
public class IdentityTest {
	/**
	 * Create a single test case that will show that there is a problem with this implementation.
	 */
	@Test
	public void testIdentity1() {
		assertEquals(Identity.identity(10), 10);
	}
	
	/**
	 * Create a minimum set of test cases that all pass and have execute every statement in the method 
	 * (the set of test cases execute every line of code).
	 */
	@Test
	public void testIdentity2() {
		assertEquals(Identity.identity(20), 20);
	}
	
	/**
	 * Create a minimum set of test cases that all pass and have complete branch coverage 
	 * (all branches are evaluated to true and to false).
	 */
	@Test
	public void testIdentity3() {
		assertEquals(Identity.identity(31), 31);
		assertEquals(Identity.identity(24), 24);
	}
	
	/**
	 * Create a set of tests that has complete path coverage 
	 * (all paths through the method are executed in the set of test cases).
	 */
	@Test
	public void testIdentity4() {
		assertEquals(Identity.identity(20), 20);
		assertEquals(Identity.identity(6), 6);
		assertEquals(Identity.identity(2), 2);		
	}
}
