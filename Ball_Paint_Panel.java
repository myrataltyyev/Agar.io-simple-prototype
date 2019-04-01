package Ball;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.ScrollPaneConstants;
import javax.swing.Timer;

public class Ball_Paint_Panel extends JPanel implements ActionListener,
		KeyListener, MouseMotionListener {

	// Store ArrayList of foods and non-foods
	ArrayList<Food> foods = new ArrayList<Food>();
	ArrayList<Non_food> non_foods = new ArrayList<Non_food>();

	int x, y;
	
	public Ball_Paint_Panel() {

		// Set size of panel
		setPreferredSize(new Dimension(Ball.wind_size_X, Ball.wind_size_Y));
		setLayout(new BorderLayout());
		add(new Info_panel(), BorderLayout.EAST);
		setBackground(Color.WHITE);

		// Timer for repainting Ball
		Timer timer = new Timer(10, this);
		timer.start();

		// Add listeners
		addKeyListener(this);
		addMouseMotionListener(this);

		// Timer for foods
		Timer tf = new Timer(900, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				foods.add(new Food());
			}
		});
		tf.start();

		// Timer for non_foods
		Timer tn = new Timer(8000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				non_foods.add(new Non_food());
			}
		});
		tn.start();
	
	}

	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		// Draw Ball
		g2d.setColor(Ball.color);
		Ball.ball = new Ellipse2D.Double(Ball.x, Ball.y, Ball.weight,
				Ball.weight);
		g2d.fill(Ball.ball);

		// Draw foods
		for (Food food : foods) {
			food.paintComponent(g2d);
		}

		// Draw non-foods
		for (Non_food non_food : non_foods) {
			non_food.paintComponent(g2d);
		}

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		// Calculate distance between mouse and ball
		Ball.dis_X = x - Ball.x - Ball.weight / 2;
		Ball.dis_Y = y - Ball.y - Ball.weight / 2;

		// Set position of ball to move
		Ball.x += Ball.dis_X * Ball.speed;
		Ball.y += Ball.dis_Y * Ball.speed;
		JLabel label1 = new JLabel("Speed: " + Ball.speed * 1000);
		
		// Eat foods and get bigger
		for (int i = 0; i < foods.size(); i++) {
			// Check intersection method takes 2 shape objects as parameters
			if (Ball.checkIntersection(foods.get(i).getFood())) {
				Ball.getBigger();
				foods.remove(i);
			}
		}

		// Eat non_foods and get smaller
		for (int i = 0; i < non_foods.size(); i++) {
			// Check intersection method takes 2 shape objects as parameters
			if (Ball.checkIntersection(non_foods.get(i).getNon_food())) {
				Ball.getSmaller();
				non_foods.remove(i);
			}
		}

		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP)
			Ball.y -= 5;
		else if (e.getKeyCode() == KeyEvent.VK_DOWN)
			Ball.y += 5;
		else if (e.getKeyCode() == KeyEvent.VK_LEFT)
			Ball.x -= 5;
		else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			Ball.x += 5;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	

}
