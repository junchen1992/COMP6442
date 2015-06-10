package q2_v2;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CounterGUITest {
	private CounterGUI gui;

	@Before
	public void setUp() throws Exception {
		gui = new CounterGUI();
	}

	@Test
	public void testInc() {
		gui.incButton.doClick();
		assertEquals("1", gui.label.getText());
	}

	@Test
	public void testReset() {
		gui.resetButton.doClick();
		assertEquals("0", gui.label.getText());
	}

}
