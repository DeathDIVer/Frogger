package game;

import java.awt.Graphics;

public class Frog extends Polygon {

	public Frog(Point[] inShape, Point inPosition, double inRotation) {
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
	 * Movement of the frog character
	 * 
	 * @param xDir The x direction of movement
	 * @param yDir The y direction of movement
	 */
	public void move(int xDir, int yDir) {
		position.x += xDir;
		position.y += yDir;
	}

	/**
	 * Rotates by 90 degrees
	 */
	public void rotate() {
		super.rotate(90);
	}

	/**
	 * This is an inner class of Frog Provides frog with all information relevent to
	 * lives
	 */
	public class Lives {
		private int count;
		
		public Lives() {
			count = 3;
		}

		/**
		 * Getter method for lives
		 * 
		 * @return number of lives left
		 */
		public int getLives() {
			return count;
		}

		/**
		 * Decreases the amount of lives
		 */
		public void decrease() {
			count--;
		}

		/**
		 * Checks if the game is over or not
		 * 
		 * @return Whether or not game is over
		 */
		public boolean isGameOver() {
			return count <= 0;
		}
	}
}
