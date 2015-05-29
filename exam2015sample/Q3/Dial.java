package Q3;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;

import javax.swing.JComponent;

public class Dial extends JComponent implements MouseMotionListener,
		MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final double MOUSEVALUESCALINGFACTOR = 100.0;
	final static Dimension dim = new Dimension(70, 70);
	final static int inset = 8;

	protected double value; // range from 0.0 - 1.0

	protected Integer dragStart;
	protected DialGUI gui;

	public double value() {
		return value;
	}

	public Dimension getPreferredSize() {
		return dim;
	}
	
	@Override
	protected void paintComponent(Graphics gg) {
		
	}
	
	// draw a line that radiates from the center of the dial
	// the angle of the line is based on the value for this dial
	protected void drawtick(Graphics2D g, double v, double s, double e) {
		double ang = (1.0 - v) * Math.PI * 2.0 * 0.8 + Math.PI * 0.2;
		double x1 = Math.sin(ang) * s + dim.width / 2.0;
		double y1 = Math.cos(ang) * s + dim.height / 2.0;
		double x2 = Math.sin(ang) * e + dim.width / 2.0;
		double y2 = Math.cos(ang) * e + dim.height / 2.0;
		g.draw(new Line2D.Double(x1, y1, x2, y2));
	}

	@Override
	public void mouseDragged(MouseEvent me) {
		if (dragStart != null) {
			value += (me.getX() - dragStart) / MOUSEVALUESCALINGFACTOR;
			if (value < 0.0)
				value = 0.0;
			if (value > 1.0)
				value = 1.0;
			dragStart = me.getX();
		}
		this.repaint();
		gui.update();
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	@Override
	public void mousePressed(MouseEvent me) {
		dragStart = me.getX();
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		dragStart = null;
	}
}
