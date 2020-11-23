package dev.ronimtnediser.openthedoor.managers;

import dev.ronimtnediser.openthedoor.Game;

public class ColisionManager {

	private Game game;
	private float x, y, width, height;

	private boolean colided = false;

	public ColisionManager(Game game, float x, float y, float width, float height) {
		this.game = game;

		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public boolean mouseColision() {
		if ((int) ((game.getMouseMotionManager().x - x + width) / width) == 1) {
			if ((int) ((game.getMouseMotionManager().y - y + height) / height) == 1) {
				colided = true;
				return true;
			}
		}
		colided = false;
		return false;
	}

}
