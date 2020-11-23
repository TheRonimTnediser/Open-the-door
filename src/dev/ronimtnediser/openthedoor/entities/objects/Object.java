package dev.ronimtnediser.openthedoor.entities.objects;

import dev.ronimtnediser.openthedoor.Game;
import dev.ronimtnediser.openthedoor.entities.Entity;
import dev.ronimtnediser.openthedoor.managers.ColisionManager;

public abstract class Object extends Entity {

	protected boolean dead;
	protected boolean visible = true;
	protected float x, y, width, height;

	protected ColisionManager colisionManager;

	public Object(Game game, float x, float y, float width, float height) {
		super(game);

		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;

		colisionManager = new ColisionManager(game, x, y, width, height);
	}
	
	public boolean collided(Object object) {
		if(x >= object.x) {
			if(x + width <= object.x + object.width) {
				return true;
			}
		}
		return false;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

}
