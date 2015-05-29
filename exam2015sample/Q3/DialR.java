package Q3;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/*
 * DialR - a red nob for controlling a value that ranges between 0 and 1.
 * The dials value is changed as you drag the mouse horizontally.
 * Eric McCreath
 */

public class DialR extends Dial {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DialR(DialGUI gui) {
		value = 0.5;
		dragStart = null;
		this.gui = gui;
		this.addMouseMotionListener(this);
		this.addMouseListener(this);
	}

	@Override
	protected void paintComponent(Graphics gg) {
		Graphics2D g = (Graphics2D) gg;
		g.setColor(Color.white);
		g.fillRect(0, 0, dim.width, dim.height);
		g.setColor(Color.black);
		g.setStroke(new BasicStroke(1.0f));
		for (int s = 0; s <= 10; s++)
			drawtick(g, s / 10.0, dim.width / 2.0 - inset / 4.0, 0.0);

		g.setColor(Color.red);
		g.fillArc(inset, inset, dim.width - 2 * inset, dim.height - 2 * inset,
				0, 360);
		g.setColor(Color.black);
		g.setStroke(new BasicStroke(4.0f));
		drawtick(g, value, dim.width / 2.0 - inset, dim.width / 4.0);

	}

}
