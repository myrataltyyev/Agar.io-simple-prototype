package Ball;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

public class Info_panel extends JPanel {

	int i = 0;
   static JLabel label1;
	public Info_panel() {

		JPanel bar = new JPanel();
		bar.setBackground(new Color(0, 0, 0, 70));
		bar.setPreferredSize(new Dimension(200, 300));
		bar.setLayout(new GridLayout(3, 0));

		label1 = new JLabel("Speed: " + Ball.speed * 1000);
		final JLabel label2 = new JLabel("Weight: " + Ball.weight);
		final JLabel label3 = new JLabel("Time: 0");

		// Timer for updating label1
		Timer t1 = new Timer(100, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				label1.setText("Speed: " + String.format("%.1f", Ball.speed*1000));
				
			}
		});
		t1.start();

		// Timer for updating label2
		Timer t2 = new Timer(100, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				label2.setText("Weight: " + String.format("%.1f", Ball.weight));
			}
		});
		t2.start();

		// Timer for updating label3
		Timer t3 = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				label3.setText("Time: " + ++i);
			}
		});
		t3.start();

		label1.setBorder(new EmptyBorder(30, 30, 30, 30));
		label2.setBorder(new EmptyBorder(30, 30, 30, 30));
		label3.setBorder(new EmptyBorder(30, 30, 30, 30));

		label1.setFont(new Font("Verdana", Font.BOLD, 17));
		label2.setFont(new Font("Verdana", Font.BOLD, 17));
		label3.setFont(new Font("Verdana", Font.BOLD, 17));

		label1.setForeground(new Color(178, 34, 34));
		label2.setForeground(new Color(178, 34, 34));
		label3.setForeground(new Color(178, 34, 34));

		bar.add(label1);
		bar.add(label2);
		bar.add(label3);

		this.setLayout(new GridLayout(3, 0));
		this.setBorder(new EmptyBorder(20, 0, 0, 20));
		this.setBackground(new Color(0, 0, 0, 0));
		this.add(bar);
	}
}
