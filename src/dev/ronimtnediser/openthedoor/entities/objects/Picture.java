package dev.ronimtnediser.openthedoor.entities.objects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.ronimtnediser.openthedoor.Game;
import dev.ronimtnediser.openthedoor.Unit;

public class Picture extends Object {

	private BufferedImage img;

	public Picture(Game game, float x, float y, float width, float height, BufferedImage img) {
		super(game, x, y, width, height);

		this.img = img;
	}

	@Override
	public void tick() {

	}

	@Override
	public void render(Graphics g) {
		g.drawImage(img, (int) (Unit.x * x), (int) (Unit.y * y), (int) (Unit.x * width), (int) (Unit.x * height), null);
	}

}
