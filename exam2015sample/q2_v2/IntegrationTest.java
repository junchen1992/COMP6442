package q2_v2;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class IntegrationTest {
	private CounterGUI gui;

	@Before
	public void setUp() throws Exception {
		gui = new CounterGUI();
	}

	@Test
	public void test() {
		assertEquals("0", gui.label.getText());
		for (int i = 1; i <= 10; i++) {
			gui.incButton.doClick();
			assertEquals(Integer.toString(i), gui.label.getText());
		}
		gui.resetButton.doClick();
		assertEquals("0", gui.label.getText());

	}

}
