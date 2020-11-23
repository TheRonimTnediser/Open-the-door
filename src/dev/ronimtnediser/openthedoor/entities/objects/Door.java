package dev.ronimtnediser.openthedoor.entities.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.Timer;

import dev.ronimtnediser.openthedoor.Game;

public class Door extends Object {

	private ArrayList<BufferedImage> images = new ArrayList<>();
	private int currentImage = 0;

	public static final int CLOSED = 0;
	public static final int OPENING = 1;
	public static final int OPEN = 2;
	public static final int CLOSING = 3;

	private int state = CLOSED;

	private Timer timer;
	private int timerDelay = 1000 / 8;

	public Door(Game game, float x, float y, float width, float height, ArrayList<BufferedImage> images) {
		super(game, x, y, width, height);

		this.images = images;

		timer = new Timer(timerDelay, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (state == CLOSING) {
					if (currentImage == 0) {
						state = CLOSED;
						timer.stop();
					} else {
						currentImage -= 1;
					}
				} else if (state == OPENING) {
					if (currentImage == 5) {
						state = OPEN;
						timer.stop();
					} else {
						currentImage += 1;
					}
				} else if (state == OPEN || state == CLOSED) {
					timer.stop();
				}
			}
		});
	}

	@Override
	public void tick() {
		if (colisionManager.mouseColision() && game.getMouseManager().pressed && game.getMouseManager().button == MouseEvent.BUTTON1) {
			if (state == OPEN || state == OPENING) {
				state = CLOSING;
			} else if (state == CLOSED) {
				state = OPENING;
			}
			timer.start();
			
			game.getMouseManager().pressed = false;
		}
	}

	@Override
	public void render(Graphics g) {
		if (visible) {
			g.setColor(Color.WHITE);
			g.fillRect((int) x + (int) (width / 8), (int) y, (int) width - (int) (width / 8 * 2), (int) height);
			g.setColor(Color.BLACK);
			g.drawImage(images.get(currentImage), (int) x + (int) (width / 8), (int) y, (int) width - (int) (width / 8 * 2), (int) height, null);
		}
	}
}
