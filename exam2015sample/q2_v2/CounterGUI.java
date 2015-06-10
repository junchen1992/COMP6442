package q2_v2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class CounterGUI implements Runnable, ActionListener {

	/**
	 * HelloGUI - a simple "hello world" swing GUI. Eric McCreath 2015 -
	 */

	JFrame jframe;
	public JLabel label = new JLabel("0");
	public JButton incButton = new JButton("Inc");
	public JButton resetButton = new JButton("Reset");
	
	public Counter counter = new Counter(0);

	private static final String INCCOMMAND = "inc";
	private static final String RESEETCOMMAND = "reset";

	public CounterGUI() {
		SwingUtilities.invokeLater(this);
	}

	public static void main(String[] args) {
		new CounterGUI();
	}

	public void run() {
		label.setText(Integer.toString(counter.getCounter()));

		incButton.setActionCommand(INCCOMMAND);
		incButton.addActionListener(this);
		resetButton.setActionCommand(RESEETCOMMAND);
		resetButton.addActionListener(this);

		jframe = new JFrame("HelloGUI");
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.getContentPane().add(label, BorderLayout.NORTH);
		jframe.getContentPane().add(incButton, BorderLayout.CENTER);
		jframe.getContentPane().add(resetButton, BorderLayout.SOUTH);
		jframe.setVisible(true);
		jframe.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(INCCOMMAND)) {
			counter.inc();
			label.setText(counter.getCounter() + "");
		}
		if (e.getActionCommand().equals(RESEETCOMMAND)) {
			counter.reset();
			label.setText(counter.getCounter() + "");
		}
	}
}
