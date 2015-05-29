package lab2;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/* ShoeSizeGUI - Eric McCreath 2015 - GPL 
 * Uses a Swing GUI to display/edit a persons shoe size. */

public class ShoeSizeGUI {

	private static final int SHOESIZETEXTFIELDWIDTH = 5;

	JFrame jframe;
	JPanel mainpanel;
	JTextField sizejtextfield;

	ShoeSize shoesize;

	public ShoeSizeGUI() {

		shoesize = new ShoeSize();

		jframe = new JFrame("Shoe Size");
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		mainpanel = new JPanel();

		mainpanel.add(new JLabel("Shoe Size:"));
		sizejtextfield = new JTextField(SHOESIZETEXTFIELDWIDTH);
		sizejtextfield.setText(shoesize.show());
		sizejtextfield.getDocument().addDocumentListener(
				new DocumentListener() {
					public void changedUpdate(DocumentEvent documentEvent) {
						update();
					}

					public void insertUpdate(DocumentEvent documentEvent) {
						update();
					}

					public void removeUpdate(DocumentEvent documentEvent) {
						update();
					}

					private void update() {
						try {
							if (shoesize.set(Integer.parseInt(sizejtextfield
									.getText()))) {
								sizejtextfield.setBackground(Color.white);
							} else {
								sizejtextfield.setBackground(Color.red);
							}

						} catch (NumberFormatException nfe) {
							shoesize.set(null);
							sizejtextfield.setBackground(Color.red);
						}
					}
				});
		mainpanel.add(sizejtextfield);
		jframe.getContentPane().add(mainpanel);
		jframe.pack();
		jframe.setVisible(true);
	}

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		ShoeSizeGUI sc = new ShoeSizeGUI();
	}
}
