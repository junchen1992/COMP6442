package q2_v2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CounterTest {

	private Counter counter;

	@Before
	public void setUp() throws Exception {
		counter = new Counter(0);
	}

	@Test
	public void IncTest() {
		assertEquals(0, counter.getCounter());
		counter.inc();
		assertEquals(1, counter.getCounter());
		counter.inc();
		assertEquals(2, counter.getCounter());
		counter.reset();
		assertEquals(0, counter.getCounter());
	}
	
	@Test
	public void ResetTest() {
		counter.reset();
		assertEquals(0, counter.getCounter());
	}

}
