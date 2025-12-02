package game;

import java.awt.Graphics;

public class Truck extends Polygon {

	public Truck(Point[] inShape, Point inPosition, double inRotation) {
		super(inShape, inPosition, inRotation);
	}

	/**
	 * Paints the polygon by filling it with the current graphics context.
	 *
	 * @param brush The graphics context used for painting.
	 */
	public void paint(Graphics brush) {
		Point[] points = getPoints();

		int[] xPoints = new int[points.length];
		int[] yPoints = new int[points.length];

		for (int i = 0; i < points.length; i++) {
			xPoints[i] = (int) points[i].getX();
			yPoints[i] = (int) points[i].getY();
		}

		brush.fillPolygon(xPoints, yPoints, points.length);
	}

	/**
	 * Moves car in the y direction, resetting its location when it travels off the
	 * grid
	 */
	public void move() {
		position.x -= 6;

		if (position.x < 0) {
			resetLocation.resetLocation();
		}
	}

	/**
	 * Resets the location of the truck when it travels off the field
	 */
	Updates resetLocation = () -> {
		position.x = 500;
	};

}
