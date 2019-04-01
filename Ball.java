// eyyupguzel47@gmail.com

package Ball;

import java.awt.event.*;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.*;
import java.util.Random;

import javax.swing.*;

public class Ball extends JFrame {

	static Random rand = new Random();

	protected static double x;
	protected static double y;
	protected static double dis_X;
	protected static double dis_Y;
	protected static Color color = randomColor();
	protected static String score = "0";
	protected static double speed = 0.03;
	protected static double weight = 50;
	protected static Ellipse2D ball;

	protected final static int wind_size_X = 1920;
	protected final static int wind_size_Y = 1080;

	JScrollPane scroll;
	static JViewport view;
	
	public Ball(String name) {

		super(name);
		setVisible(true);
		setSize(wind_size_X, wind_size_Y);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		JPanel panel = new Ball_Paint_Panel();
		
//		scroll = new JScrollPane();
//		view = new JViewport();
//		view.add(panel);
//		//scroll.setViewport(view);
//		scroll.setViewportView(view);
//		scroll.addMouseMotionListener(new MouseMotionListener() {
//			
//			@Override
//			public void mouseMoved(MouseEvent e) {
//				// TODO Auto-generated method stub
//				Point p = e.getPoint();
//				view.setViewPosition(new Point(p.x+2000, p.y+1000));	
//			}
//			
//			@Override
//			public void mouseDragged(MouseEvent e) {
//				// TODO Auto-generated method stub
//			}
//		});
//		//scroll.setPreferredSize(new Dimension(Ball.wind_size_X, Ball.wind_size_Y));
//		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
//		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
//		add(scroll);
		
		add(panel);
	}

	protected static void getBigger() {
		weight += Food.size / 6.0;

		if (speed >= 0.01)
			speed -= 0.0001;
	}

	protected static void getSmaller() {
		if (weight >= 10)
			weight -= 2;

		if (speed >= 0.01)
			speed += 0.0001;
	}

	protected static boolean checkIntersection(Ellipse2D A) {
		return ball.getBounds().intersects(A.getBounds());
	}

	protected static Color randomColor() {
		return new Color(rand.nextInt(255), rand.nextInt(255),
				rand.nextInt(255));
	}

	public static void main(String[] args) {
		Ball b = new Ball("Surviving Ball");
	}

}
