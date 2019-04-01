package Ball;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Random;

import javax.swing.JPanel;

public class Food extends JPanel {

	private int x;
	private int y;
	private Color color;
	static int size;
	private Ellipse2D food;

	public Food() {
		this.x = Ball.rand.nextInt(Ball.wind_size_X);
		this.y = Ball.rand.nextInt(Ball.wind_size_Y);
		color = Ball.randomColor();
		size = Ball.rand.nextInt(20) + 10;
		food = new Ellipse2D.Double(x, y, size, size);
	}

	public void paintComponent(Graphics2D g2d) {
		g2d.setPaint(color);
		g2d.fill(food);
	}
	
	// Return shape object food
	public Ellipse2D getFood() {
		return food;
	}

}
