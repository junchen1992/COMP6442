package lab1;
/*COMP6442 Software Construction lab 1
 *  02/03/2015
 */
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelloWorld {
	public static void main(String[] args) {
		// System.out.println("Hello World!");

		JFrame frame = new JFrame("First GUI Program");
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Hello World!");
		JButton button = new JButton("Jason");

		JMenuBar menubar = new JMenuBar();		
		
		
		// Create a "File" menu and add it to the menu bar:
		frame.add(menubar, BorderLayout.PAGE_START);
		JMenu FILE = new JMenu("File");
		JMenuItem item1 = new JMenuItem("Exit");
		// Add an action listener to the "Exit" menu item:
		item1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ae){
						System.out.println("EXIT command selected...");
					}
				});	
		FILE.add(item1);
		menubar.add(FILE);

		JButton buttonVikas = new JButton ("Vikas");
		
		JButton buttonScott = new JButton("Scott");

		label.setFont(new Font("Dialog", 1, 20));
		label.setHorizontalAlignment(JLabel.CENTER);
		frame.setSize(400, 300);
		panel.add(button);
		panel.add(buttonVikas);
		panel.add(buttonScott);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				System.out.println("Hello Jason.");
			}
		});
		buttonVikas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent vi) {
				System.out.println("Hello Vikas.");
			}
		});
		buttonScott.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent vi) {
				System.out.println("Hello Scott");
			}
		});

		JButton ericButton = new JButton("Exit");
		ericButton.setActionCommand("YES");
		ericButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Hello Eric");
			}
		});
		panel.add(ericButton);

		frame.add(label);
		frame.add(panel, BorderLayout.LINE_START);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}