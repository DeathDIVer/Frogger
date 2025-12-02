package game;

/*
CLASS: Frogger
DESCRIPTION: Extending Game, YourGameName is all in the paint method.
NOTE: This class is the metaphorical "main method" of your program,
      it is your control center.

*/
import java.awt.*;
import java.awt.event.*;

class Frogger extends Game {
	private static final long serialVersionUID = 1L;

	private Frog frog;
	private Car car, car1;
	private Truck truck;
	private Frog.Lives lives;

	public Frogger() {
		super("Frogger", 500, 500);
		this.setFocusable(true);
		this.requestFocus();

		Point[] shape = { new Point(0, 0), new Point(50, 0), new Point(50, 50), new Point(0, 50) };
		Point[] shape2 = { new Point(0, 0), new Point(100, 0), new Point(100, 50), new Point(0, 50) };
		Point position = new Point(215, 450);
		double rotation = 0; // degrees

		frog = new Frog(shape, position, rotation);

		car = new Car(shape, new Point(0, 390), rotation);
		truck = new Truck(shape2, new Point(0, 240), rotation);
		car1 = new Car(shape2, new Point(0, 160), rotation);
		lives = frog.new Lives();

		this.addKeyListener(this);
	}

	/**
	 * Paints the etire game
	 *
	 * @param brush The graphics context used for painting.
	 */
	public void paint(Graphics brush) {
		if (!isGameOver() && !isGameWon()) {
			brush.setColor(Color.black);
			brush.fillRect(0, 0, width, height);

			brush.setColor(Color.green);
			frog.paint(brush);

			brush.setColor(Color.orange);
			car.move();
			car1.move();

			car.paint(brush);
			car1.paint(brush);

			brush.setColor(Color.cyan);
			truck.move();

			truck.paint(brush);

			if (frog.collides(car) || frog.collides(truck) || frog.collides(car1)) {
				lives.decrease();
				frog.position.x = 215;
				frog.position.y = 450;
			}

		} else if (isGameOver()) {
			brush.setColor(Color.white);
			brush.fillRect(0, 0, width, height);

			brush.setColor(Color.black);
			brush.drawString("Game over", 250, 250);
		} else if (isGameWon()) {
			brush.setColor(Color.yellow);
			brush.fillRect(0, 0, width, height);

			brush.setColor(Color.black);
			brush.drawString("Game win!", 250, 250);
		}
	}

	/**
	 * Main method 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Frogger a = new Frogger();
		a.repaint();
	}

	/**
	 * Checks if game is over
	 * 
	 * @return Whether or not game is over or not
	 */
	public boolean isGameOver() {
		if (lives.isGameOver()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Checks if game is won
	 * 
	 * @return Whether or not game is won or not
	 */
	public boolean isGameWon() {
		if (frog.position.y <= 0) {
			return true;
		} else {
			return false;
		}
	}

	//// KEYLISTENER METHODS ////

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			frog.move(0, -50);
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			frog.move(0, 50);
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			frog.move(-50, 0);
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			frog.move(50, 0);
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
}