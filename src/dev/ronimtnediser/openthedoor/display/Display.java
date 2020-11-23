package dev.ronimtnediser.openthedoor.display;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display {
	private JFrame frame;
	private Canvas canvas;

	private float width, height;
	private String title;

	public Display(float width, float height, String title) {
		this.width = width;
		this.height = height;
		this.title = title;

		createDisplay();
	}

	public void createDisplay() {
		frame = new JFrame(title);
		frame.setSize((int) width, (int) height);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setVisible(true);

		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension((int) width, (int) height));
		canvas.setMinimumSize(new Dimension((int) width, (int) height));
		canvas.setMaximumSize(new Dimension((int) width, (int) height));

		canvas.setVisible(true);

		frame.add(canvas);
		frame.pack();
	}

	public Canvas getCanvas() {
		return canvas;
	}

	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}
}
