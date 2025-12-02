package game;

import java.awt.Graphics;

public class Car extends Polygon {
	private Speed speed;

	public Car(Point[] inShape, Point inPosition, double inRotation) {
		super(inShape, inPosition, inRotation);

		this.speed = new Speed(2);
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
		position.x += speed.getSpeed();

		if (position.x > 500) {
			resetLocation.resetLocation();
		}
	}

	/**
	 * Resets the location of the car when it travels off the field
	 */
	Updates resetLocation = new Updates() {
		@Override
		public void resetLocation() {
			position.x = 0;
		}
	};

	public class Speed {
		private int speed;

		public Speed(int speed) {
			this.speed = speed;
		}

		/**
		 * Returns speed
		 * 
		 * @return
		 */
		public int getSpeed() {
			return speed;
		}
	}
}
