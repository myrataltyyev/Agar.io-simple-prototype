package Ball;

import java.awt.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Non_food extends JPanel {

	private int x;
	private int y;
	private Color color;
	static int size;
	private Ellipse2D non_food;

	public Non_food() {
		this.x = Ball.rand.nextInt(Ball.wind_size_X);
		this.y = Ball.rand.nextInt(Ball.wind_size_Y);
		color = Color.RED;
		size = 40;
		non_food = new Ellipse2D.Double(x, y, size, size);
		this.setBorder(BorderFactory.createLineBorder(Color.black));
	}

	public void paintComponent(Graphics2D g2d) {
		g2d.setPaint(Color.BLACK);
		g2d.setStroke(new BasicStroke(10));
		g2d.drawRoundRect(x-2, y-2, size+2, size+2, size, size);
		g2d.setPaint(Color.RED);
		g2d.fill(non_food);
	}

	// Return shape object non_food
	public Ellipse2D getNon_food() {
		return non_food;
	}
}
